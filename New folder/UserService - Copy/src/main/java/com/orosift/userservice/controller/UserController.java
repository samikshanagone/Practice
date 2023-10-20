package com.orosift.userservice.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.orosift.userservice.Util.JwtUtil;
import com.orosift.userservice.Util.ResponseData;
import com.orosift.userservice.kafka.NotificationProducer;
import com.orosift.userservice.model.Login;
import com.orosift.userservice.model.LoginResponce;
import com.orosift.userservice.model.SessionForToken;
import com.orosift.userservice.model.User;
import com.orosift.userservice.model.UserOtp;
import com.orosift.userservice.model.UserResponce;
import com.orosift.userservice.service.SessionUtilMap;
import com.orosift.userservice.service.UserService;
import com.orosoft.kafkabase.kafkadomain.dto.KafkaUser;
import com.orosoft.kafkabase.kafkadomain.dto.KafkaUserEvent;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private JwtUtil jwtUtils;

//	@Autowired
//	private SessionServiceImpl sessionService;

	@Autowired
	private NotificationProducer notificationProducer;

	private Map<String, String> otpAttempts = new HashMap<>();

	private int counter = 0;

	/**
	 * @param user
	 * @return
	 * @throws InterruptedException
	 * @throws JsonProcessingException
	 * @throws JsonMappingException
	 */
	@PostMapping("/signup")
	public ResponseEntity<ResponseData> addUserDetails(@RequestBody String user1)
			throws InterruptedException, JsonMappingException, JsonProcessingException {

		JsonNode json = new ObjectMapper().readTree(user1);
		User user = new User();
		user.setName(json.get("name").asText());
		user.setEmail(json.get("email").asText());
		user.setDOB(json.get("DOB").asText());
		user.setContact(json.get("contact").asText());

		String email = user.getEmail();// for getting mail 
		String userByEmailId = "";
		if (!email.isEmpty()) {// mail should not be empty
			userByEmailId = userService.getEmailByEmailId(email);
		}
		if (email.equalsIgnoreCase(userByEmailId)) {
			ResponseData responseData = ResponseData.create(30);
			return ResponseEntity.ok(responseData);
		}
		String userId = "user" + User.generateAlphanumericID();
		user.setUserId(userId);
		String OTP = userService.generateOTP(6);
		KafkaUser ku = new KafkaUser();
		ku.setEmailId(email);
		ku.setOtp(OTP);
		ku.setUserId(userId);
		KafkaUserEvent event = new KafkaUserEvent();
		event.setStatus("PENDING");
		event.setUser(ku);
		notificationProducer.sendMessage(event);// publish event for kafka
		Thread.sleep(50);
		userService.addDataToCacheService(user);// data store into cache
		Thread.sleep(100);
		otpAttempts.put(userId, OTP);// otp put into map for validation(key-userID,value-OTP)
		UserResponce userResponce = new UserResponce();
		userResponce.setUserId(userId);
		ResponseData responseData = ResponseData.create(200, userResponce);
		return ResponseEntity.ok(responseData);
	}

	/**
	 * @param UserOtp
	 * @return
	 * @throws InterruptedException
	 * @throws JsonProcessingException
	 * @throws JsonMappingException
	 */
	@PostMapping("/validateotp") // userId,Otp
	public ResponseEntity<ResponseData> validateotp(@RequestBody String us)
			throws InterruptedException, JsonMappingException, JsonProcessingException {
		JsonNode json = new ObjectMapper().readTree(us);
		UserOtp otp1 = new UserOtp();
		System.out.println(us);
		otp1.setUserId(json.get("userId").asText());
		otp1.setOTP(json.get("OTP").asText());
		String otp = otp1.getOTP();
		String userId = otp1.getUserId();
		Set<String> keySet = otpAttempts.keySet();// store all the keys from hashmap
		if (!keySet.contains(userId)) {// checking present or not(key as userId),userId does not exits
			ResponseData responseData = ResponseData.create(1999);
			return ResponseEntity.ok(responseData);
		}
		boolean isOtpCorrect = validateOtpAgainstUser(userId, otp);
		if (isOtpCorrect) {//if otp is valid
			otpAttempts.remove(userId);
			ResponseData responseData = ResponseData.create(500);
			counter = 0;//reset the counter
			return ResponseEntity.ok(responseData);
		} else if (counter >= 3) { //more than three consecutive time
			ResponseData responseData = ResponseData.create(301);
			counter = 0;
			return ResponseEntity.ok(responseData);
		} else if (!isOtpCorrect) {// if otp is invalid
			ResponseData responseData = ResponseData.create(502);
			counter++;
			return ResponseEntity.ok(responseData);
		}

		return null;
	}

	/**
	 * @param userId
	 * @param otp
	 * @return
	 */
	private boolean validateOtpAgainstUser(String userId, String otp) {
		String integer = otpAttempts.get(userId);//we pass key as userid so that it will return value as otp
		return integer.equals(otp);
	}

	/**
	 * @param user
	 * @return
	 * @throws InterruptedException
	 */
	@PostMapping("/addUserDetails") // {Userid}/{pass}
	public ResponseEntity<ResponseData> storeUser(@RequestBody User us) throws InterruptedException {
		User user = new User();
		user = userService.getDataFromCacheService(us.getUserId());
		Thread.sleep(500);//thread waiting for get data from cache
		if (user == null) {
			ResponseData responseData = ResponseData.create(0);
			return ResponseEntity.ok(responseData);
		}
		user.setPassword(us.getPassword());
		System.out.println("data from cache = " + user.getEmail());
		KafkaUser ku = new KafkaUser();
		ku.setEmailId(user.getEmail());
		ku.setOtp(" ");// using existing pojo for welcome mail
		ku.setUserId(user.getUserId());
		KafkaUserEvent event = new KafkaUserEvent();
		event.setStatus("mail");
		event.setUser(ku);
		ResponseData responseData = ResponseData.create(200);
		userService.saveDetails(user);// data store into DB
		notificationProducer.sendMessage(event);// publish event for welcome mail
		userService.removeDataFromCacheService(us.getUserId());// removed data from cache
		return ResponseEntity.ok(responseData);
	}

	/**
	 * @param email
	 * @param pass
	 * @return
	 * @throws InterruptedException
	 */
	@PostMapping("/login") /// {userId}/{pass}/{device}
	public ResponseEntity<ResponseData> loginUser(@RequestBody Login login) throws InterruptedException {
		String device = login.getLoginDevice();
		String pass = login.getPassword();
		String userId = login.getUserId();
		User userbyuserID = userService.getUserbyuserID(userId);
		SessionForToken objForToken = new SessionForToken();
		// check if user is null return userID is invalid
		if (userbyuserID == null) {
			ResponseData responseData = ResponseData.create(201);
			return ResponseEntity.ok(responseData);
		}
		if (!(userbyuserID.getPassword().equals(pass))) { //credential more than 3
			counter++;
			if (counter > 3) {
				counter = 0;// reseting the counter
				ResponseData responseData = ResponseData.create(205);
				return ResponseEntity.ok(responseData);
			}
		}
		if (userbyuserID != null) {// user object could not be null
			String DbuserId = userbyuserID.getUserId();
			String password = userbyuserID.getPassword();
			// logic for phase - 1
			//SessionForToken session = sessionService.getSession(userId);// checked session is available for userID
			// for phase -2
			SessionForToken session = SessionUtilMap.getSession(userId);// checked session is available for userID
			if (session == null) {// if session is null (session is not present for userID)
				// Db userid and password should be match
				if (DbuserId.equals(userId) && password.equals(pass)) {
					String token = jwtUtils.generateToken(userId);// generating JWT token for userID
					objForToken.setToken(token);
					objForToken.setUserId(userId);
					objForToken.setDeviceString(device);
					objForToken.setSessionId(objForToken.generateAlphanumericID());
					SessionUtilMap.saveSession(objForToken);
					//Logic for -1 
					//sessionService.saveSession(objForToken);
					LoginResponce loginResponce=new LoginResponce();
					loginResponce.setSessionId(objForToken.getSessionId());
					loginResponce.setName(userbyuserID.getName());
					ResponseData responseData = ResponseData.create(200,loginResponce );
					counter = 0;//reset the counter
					return ResponseEntity.ok(responseData);
				} else if (!password.equals(pass) && userId.equals(userId)) {//pass is not valid
					ResponseData responseData = ResponseData.create(202);
					return ResponseEntity.ok(responseData);
				}

			} else if (!(session.getToken().isEmpty()) && device.equalsIgnoreCase(session.getDeviceString())) {
				ResponseData responseData = ResponseData.create(204);
				return ResponseEntity.ok(responseData);
			}else {
				System.out.println("**********Different Device************");
				ResponseData responseData = ResponseData.create(200,"**********Different Device************");
				return ResponseEntity.ok(responseData);
			}
		}
		return ResponseEntity.ok().build();
	}

	/**
	 * @param email
	 * @return
	 * @throws InterruptedException
	 */
	@PostMapping("/forgotPassword") // {email}
	public ResponseEntity<ResponseData> userForgetPass(@RequestBody User us) throws InterruptedException {
		String email = us.getEmail();
		User userByEmailId = userService.getUserByEmailId(email);
		Thread.sleep(100);
		if (userByEmailId == null) {
			ResponseData responseData = ResponseData.create(199);
			return ResponseEntity.ok(responseData);
		} else if ((userByEmailId.getEmail()).equals(email)) {
			String generateOTP = userService.generateOTP(6);
			otpAttempts.put(email, generateOTP);
			KafkaUser ku = new KafkaUser();
			ku.setEmailId(email);
			ku.setOtp(generateOTP);
			ku.setUserId(userByEmailId.getUserId());
			KafkaUserEvent event = new KafkaUserEvent();
			event.setStatus("PENDING");
			event.setUser(ku);
			notificationProducer.sendMessage(event);
			Thread.sleep(100);
			ResponseData responseData = ResponseData.create(200);
			return ResponseEntity.ok(responseData);
		} else {
			ResponseData responseData = ResponseData.create(199);
			return ResponseEntity.ok(responseData);
		}
	}

	/**
	 * @param email
	 * @param otp
	 * @return
	 * @throws InterruptedException
	 * @throws JsonProcessingException 
	 * @throws JsonMappingException 
	 */
	@PostMapping("/validateOTPForForgotPassword") // {email}/{otp}
	public ResponseEntity<ResponseData> validateOTPforForgetPassword(@RequestBody String us)
			throws InterruptedException, JsonMappingException, JsonProcessingException {
		JsonNode json = new ObjectMapper().readTree(us);
		UserOtp otp2 = new UserOtp();
		otp2.setEmail(json.get("email").asText());
		otp2.setOTP(json.get("OTP").asText());
		String email = otp2.getEmail();
		boolean isOtpCorrect = validateOtpAgainstUser(email, otp2.getOTP());
		Thread.sleep(100);
		System.out.println(isOtpCorrect);
		if (isOtpCorrect) {
			otpAttempts.remove(email);
			ResponseData responseData = ResponseData.create(200);
			return ResponseEntity.ok(responseData);
		} else {
			counter++;
			System.out.println(counter);
			if (counter > 3) {
				ResponseData responseData = ResponseData.create(301);
				counter = 0;
				return ResponseEntity.ok(responseData);
			}
			ResponseData responseData = ResponseData.create(199);
			return ResponseEntity.ok(responseData);
		}
	}

	/**
	 * @param email
	 * @param pass
	 * @return
	 * @throws InterruptedException
	 */
	@PostMapping("/changePassword") //
	public ResponseEntity<ResponseData> changePassword(@RequestBody User us) throws InterruptedException {
		User user = userService.getUserByEmailId(us.getEmail());
		Thread.sleep(100);
		user.setPassword(us.getPassword());
		String updateUser = userService.updateUser(user, user.getId());
		Thread.sleep(50);
		if (updateUser.equals("done")) {
			ResponseData responseData = ResponseData.create(200);
			return ResponseEntity.ok(responseData);
		} else {
			ResponseData responseData = ResponseData.create(199);
			return ResponseEntity.ok(responseData);
		}
	}

	@PostMapping("/logout") // {userId}/{sessionid}
	public ResponseEntity<ResponseData> logout(@RequestBody SessionForToken login) throws InterruptedException {
		//SessionForToken session = sessionService.getSession(login.getUserId(),login.getSessionId());
		SessionForToken session = SessionUtilMap.getSession(login.getUserId());
		Thread.sleep(100);
		if(login.getSessionId() ==  session.getSessionId()) {
			SessionUtilMap.removeSession(login.getUserId());
			ResponseData responseData = ResponseData.create(200);
			return ResponseEntity.ok(responseData);
		}
		ResponseData responseData = ResponseData.create(0);
		return ResponseEntity.ok(responseData);
		
	}
}
