package com.orosift.userservice.service;

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.orosift.userservice.Util.JwtUtil;
import com.orosift.userservice.Util.ResponseData;
import com.orosift.userservice.kafka.NotificationProducer;
import com.orosift.userservice.model.Login;
import com.orosift.userservice.model.LoginResponce;
import com.orosift.userservice.model.OTPResponse;
import com.orosift.userservice.model.SessionForToken;
import com.orosift.userservice.model.User;
import com.orosift.userservice.model.UserOtp;
import com.orosift.userservice.model.UserResponce;
import com.orosift.userservice.repository.UserRepository;
import com.orosoft.grpc.CachingServiceGrpc;
import com.orosoft.grpc.RemoveOTPRequest;
import com.orosoft.grpc.RemoveOTPResponse;
import com.orosoft.grpc.RemoveSessionRequest;
import com.orosoft.grpc.RemoveSessionResponse;
import com.orosoft.grpc.RemoveUserRequest;
import com.orosoft.grpc.RemoveUserResponse;
import com.orosoft.grpc.StoreOTP;
import com.orosoft.grpc.StoreOTPResponse;
import com.orosoft.grpc.StoreUserResponse;
import com.orosoft.grpc.UserData;
import com.orosoft.grpc.UserRequest;
import com.orosoft.grpc.UserSession;
import com.orosoft.grpc.UserSessionRequest;
import com.orosoft.grpc.ValidateOTPRequest;
import com.orosoft.grpc.ValidateOTPResponse;
import com.orosoft.kafkabase.kafkadomain.dto.KafkaUser;
import com.orosoft.kafkabase.kafkadomain.dto.KafkaUserEvent;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.client.inject.GrpcClient;

@Service
public class UserServiceImpl implements UserService {

	private static final String NUMBERS = "0123456789";
	private static final String NUMERIC = NUMBERS;
	private static final int ID_LENGTH = 04;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private NotificationProducer notificationProducer;

	@Autowired
	private JwtUtil jwtUtils;

	@GrpcClient("CachingService")
	private CachingServiceGrpc.CachingServiceBlockingStub cacheStub;

	@GrpcClient("CachingService")
	private CachingServiceGrpc.CachingServiceBlockingStub syncCacheStub;

	Map<String, Integer> loginAttempts = new HashMap<>();

	private int generateSessionID() {
		Random random = new Random();
		int id = random.nextInt(900) + 100;
		return id;
	}

	private String generateOTP(int length) {
		String numbers = "123456789";
		Random rndm_method = new Random();
		char[] otp = new char[length];
		for (int i = 0; i < length; i++) {
			otp[i] = numbers.charAt(rndm_method.nextInt(numbers.length()));
		}
		return new String(otp);
	}

	private static String generateAlphanumericID() {
		StringBuilder idBuilder = new StringBuilder();
		SecureRandom random = new SecureRandom();
		for (int i = 0; i < ID_LENGTH; i++) {
			int randomIndex = random.nextInt(NUMERIC.length());
			char randomChar = NUMERIC.charAt(randomIndex);
			idBuilder.append(randomChar);
		}
		return idBuilder.toString();
	}

	@Override
	public String updateUser(User user, Long id) {
		Optional<User> findById = userRepository.findById(id);
		User user2 = findById.get();
		user2.setName(user.getName());
		user2.setEmail(user.getEmail());
		user2.setContact(user.getContact());
		user2.setDOB(user.getDOB());
		userRepository.save(user2);
		return "done";
	}

	@Override
	public User getUserByEmailId(String emailId) {
		User user = userRepository.getUserByEmialId(emailId);
		return user;
	}

	public void addSessinToCacheService(SessionForToken token) {
		UserSession build = UserSession.newBuilder().setUserId(token.getUserId()).setSessionId(token.getSessionId())
				.setToken(token.getToken()).setDeviceString(token.getDeviceString()).build();
		syncCacheStub.storeUserSession(build);
	}

	public SessionForToken getSessionFromCacheService(String userid) {
		SessionForToken token = new SessionForToken();
		UserSessionRequest build = UserSessionRequest.newBuilder().setUserId(userid).build();
		UserSession userSession = syncCacheStub.getUserSession(build);
		token.setDeviceString(userSession.getDeviceString());
		token.setSessionId(userSession.getSessionId());
		token.setToken(userSession.getToken());
		token.setUserId(userSession.getUserId());
		return token;
	}
	
	public void removeSessionFromCache(String userId) {
		RemoveSessionRequest build = RemoveSessionRequest.newBuilder().setUserId(userId).build();
		RemoveSessionResponse removeUserSession = syncCacheStub.removeUserSession(build);
		System.out.println("Remove session "+removeUserSession);
	}

	public void addDataToCacheService(User user) {
		UserData build = UserData.newBuilder().setContact(user.getContact()).setDob(user.getDOB())
				.setEmail(user.getEmail()).setName(user.getName()).setUserId(user.getUserId()).build();
		StoreUserResponse storeUser = cacheStub.storeUser(build);
	}

	public User getDataFromCacheService(String userId) {
		User user = new User();
		UserRequest build = UserRequest.newBuilder().setUserId(userId).build();
		UserData data = cacheStub.getUser(build); 
				user.setDOB(data.getDob());
				user.setEmail(data.getEmail());
				user.setName(data.getName());
				user.setContact(data.getContact());
				user.setUserId(data.getUserId());
				return user;	
	}
	
	public OTPResponse validateOTPFromCache(UserOtp otp) {
		ValidateOTPRequest build = ValidateOTPRequest.newBuilder().setUserId(otp.getUserId()).setOtp(otp.getOTP())
				.setMaxTry(0).build();
		OTPResponse status = new OTPResponse();
		ValidateOTPResponse data=cacheStub.validateOTP(build); 
				status.setOTPMatch(data.getOptMatched());
				status.setMaxAttempt(data.getMaxTryReach());
				status.setUsedIdValid(data.getUserIdValid());
		return status;
	}

	public void addOTPToCache(UserOtp userOtp) {
		StoreOTP build = StoreOTP.newBuilder().setUserId(userOtp.getUserId()).setOTP(userOtp.getOTP()).build();
		StoreOTPResponse storeOTP = cacheStub.storeOTP(build) ;
	}

	public void removeDataFromCacheService(String userId) {
		RemoveUserRequest build = RemoveUserRequest.newBuilder().setUserId(userId).build();
		RemoveUserResponse removeUser = cacheStub.removeUser(build);
	}

	public void removeOTPFromCacheService(String userId) {
		RemoveOTPRequest build = RemoveOTPRequest.newBuilder().setUserId(userId).build();
		RemoveOTPResponse removeOTP = cacheStub.removeOTP(build); 
	}

	@Override
	public User getUserbyuserID(String userId) {
		User userbyUserID = userRepository.getUserbyUserID(userId);
		return userbyUserID;
	}

	private void KafkaEventPublisher(User user, String OTP, String status) {
		KafkaUser kufkaUser = new KafkaUser();
		kufkaUser.setEmailId(user.getEmail());
		kufkaUser.setOtp(OTP);
		kufkaUser.setUserId(user.getUserId());
		KafkaUserEvent event = new KafkaUserEvent();
		event.setStatus(status);
		event.setUser(kufkaUser);
		notificationProducer.sendMessage(event);// publish event for kafka
	}

	public ResponseEntity<ResponseData> signUp(String user1)
			throws InterruptedException, JsonMappingException, JsonProcessingException {
		JsonNode json = new ObjectMapper().readTree(user1);
		User user = new User();
		UserOtp otp = new UserOtp();
		user.setName(json.get("name").asText());
		user.setEmail(json.get("email").asText());
		user.setDOB(json.get("DOB").asText());
		user.setContact(json.get("contact").asText());
		String email = user.getEmail();// for getting mail
		String userByEmailId = "";
		userByEmailId = userRepository.getEmailByEmialId(email);
		if (email.equalsIgnoreCase(userByEmailId)) {
			ResponseData responseData = ResponseData.create(30);
			return ResponseEntity.ok(responseData);
		}
		String userId = "user" + generateAlphanumericID();
		user.setUserId(userId);
		String OTP = generateOTP(6);
		otp.setOTP(OTP);
		otp.setUserId(userId);
		addOTPToCache(otp);
		addDataToCacheService(user);// data store into cache
		try {
			KafkaEventPublisher(user, OTP, "PENDING");
		} catch (Exception exception) {
			ResponseData responseData = ResponseData.create(220);
			return ResponseEntity.ok(responseData);

		}
		UserResponce userResponce = new UserResponce();
		userResponce.setUserId(userId);
		ResponseData responseData = ResponseData.create(200, userResponce);
		return ResponseEntity.ok(responseData);
	}

	public ResponseEntity<ResponseData> validateotp(String user)
			throws JsonMappingException, JsonProcessingException, InterruptedException {
		JsonNode json = new ObjectMapper().readTree(user);
		UserOtp otp1 = new UserOtp();
		System.out.println(user);
		otp1.setUserId(json.get("userId").asText());
		otp1.setOTP(json.get("OTP").asText());
		String userID = otp1.getUserId();
		OTPResponse otpResponse = validateOTPFromCache(otp1);
		if (otpResponse.isMaxAttempt()) {
			ResponseData responseData = ResponseData.create(301);
			return ResponseEntity.ok(responseData);
		}
		if (otpResponse.isUsedIdValid()) {
			ResponseData responseData = ResponseData.create(1999);
			return ResponseEntity.ok(responseData);
		}
		if (otpResponse.isOTPMatch()) {
			ResponseData responseData = ResponseData.create(500);
			removeOTPFromCacheService(userID);
			return ResponseEntity.ok(responseData);
		} else {
			ResponseData responseData = ResponseData.create(502);
			return ResponseEntity.ok(responseData);
		}
	}

	public ResponseEntity<ResponseData> storeUser(User userObj) throws InterruptedException {
		User user = new User();
		user = getDataFromCacheService(userObj.getUserId());
		Thread.sleep(500);
		System.out.println("user " + user);
		user.setPassword(userObj.getPassword());
		System.out.println("data from cache = " + user.getEmail());
		try {
			userRepository.save(user);// data store into DB
		} catch (DataAccessException e) {
			ResponseData responseData = ResponseData.create(0);
			return ResponseEntity.ok(responseData);
		}
		KafkaEventPublisher(user, "", "success");
		removeDataFromCacheService(userObj.getUserId());// removed data from cache
		ResponseData responseData = ResponseData.create(200);
		return ResponseEntity.ok(responseData);
	}

	public ResponseEntity<ResponseData> loginUser(Login login) throws InterruptedException {
		String device = login.getLoginDevice();
		String pass = login.getPassword();
		String userId = login.getUserId();
		User userbyuserID = getUserbyuserID(userId);
		SessionForToken objForToken = new SessionForToken();
		LoginResponce loginResponce = new LoginResponce();
		Integer count = loginAttempts.getOrDefault(userId, 0);
		// check if user is null return userID is invalid
		if (userbyuserID == null) {
			ResponseData responseData = ResponseData.create(201);
			return ResponseEntity.ok(responseData);
		}
		if (!(userbyuserID.getPassword().equals(pass))) { // credential more than 3
			count++;
			loginAttempts.put(userId, count);
			System.out.println("login att " + count);
			if (count >= 3) {
				ResponseData responseData = ResponseData.create(205);
				count = loginAttempts.put(userId, 0);// reseting the counter
				return ResponseEntity.ok(responseData);
			}
		}
		if (userbyuserID != null) {// user object could not be null
			String DbuserId = userbyuserID.getUserId();
			String password = userbyuserID.getPassword();
			// logic for phase - 1
			// SessionForToken session = sessionService.getSession(userId);// checked
			// session is available for userID
			// for phase -2
			// SessionForToken session = SessionUtilMap.getSession(userId);// checked
			// session is available for userID
			SessionForToken session = getSessionFromCacheService(userId);
			if (session.getSessionId() == 0) {// if session is null (session is not present for userID)
				// Db userid and password should be match
				if (DbuserId.equals(userId) && password.equals(pass)) {
					String token = jwtUtils.generateToken(userId);// generating JWT token for userID
					objForToken.setToken(token);
					objForToken.setUserId(userId);
					objForToken.setDeviceString(device);
					objForToken.setSessionId(generateSessionID());
					addSessinToCacheService(objForToken);
					loginResponce.setSessionId(objForToken.getSessionId());
					loginResponce.setName(userbyuserID.getName());
					ResponseData responseData = ResponseData.create(200, loginResponce);
					count = loginAttempts.put(userId, 0);// reset the counter
					loginAttempts.remove(userId);
					return ResponseEntity.ok(responseData);
				} else if (!password.equals(pass) && userId.equals(userId)) {// pass is not valid
					ResponseData responseData = ResponseData.create(202);
					return ResponseEntity.ok(responseData);
				}

			} else if (!(session.getToken().isEmpty()) && device.equalsIgnoreCase(session.getDeviceString())) {
				ResponseData responseData = ResponseData.create(204);
				return ResponseEntity.ok(responseData);
			}
		}
		return ResponseEntity.ok().build();
	}

	public ResponseEntity<ResponseData> userForgetPass(User user) throws InterruptedException {
		UserOtp otp = new UserOtp();
		String email = user.getEmail();
		User userByEmailId = getUserByEmailId(email);
		if (userByEmailId == null) {
			ResponseData responseData = ResponseData.create(199);
			return ResponseEntity.ok(responseData);
		} else if ((userByEmailId.getEmail()).equals(email)) {
			String generateOTP = generateOTP(6);
			otp.setUserId(email);
			otp.setOTP(generateOTP);
			addOTPToCache(otp);
			KafkaEventPublisher(userByEmailId, generateOTP, "PENDING");
			ResponseData responseData = ResponseData.create(200);
			return ResponseEntity.ok(responseData);
		} else {
			ResponseData responseData = ResponseData.create(199);
			return ResponseEntity.ok(responseData);
		}
	}

	public ResponseEntity<ResponseData> validateOTPforForgetPassword(String user)
			throws InterruptedException, JsonMappingException, JsonProcessingException {
		JsonNode json = new ObjectMapper().readTree(user);
		UserOtp otp2 = new UserOtp();
		otp2.setUserId(json.get("email").asText());
		otp2.setOTP(json.get("OTP").asText());
		boolean isOtpCorrect = false;// validateOtpAgainstUser(email, otp2.getOTP());
		OTPResponse otpResponse = validateOTPFromCache(otp2);
		System.out.println(isOtpCorrect);
		if (otpResponse.isMaxAttempt()) {
			ResponseData responseData = ResponseData.create(301);
			return ResponseEntity.ok(responseData);
		}
		if (otpResponse.isOTPMatch()) {
			ResponseData responseData = ResponseData.create(200);
			return ResponseEntity.ok(responseData);
		} else {
			ResponseData responseData = ResponseData.create(199);
			return ResponseEntity.ok(responseData);
		}
	}

	public ResponseEntity<ResponseData> changePassword(User UserObj) throws InterruptedException {
		User user = getUserByEmailId(UserObj.getEmail());
		user.setPassword(UserObj.getPassword());
		String updateUser = updateUser(user, user.getId());
		if (updateUser.equals("done")) {
			ResponseData responseData = ResponseData.create(200);
			return ResponseEntity.ok(responseData);
		} else {
			ResponseData responseData = ResponseData.create(199);
			return ResponseEntity.ok(responseData);
		}
	}

	public ResponseEntity<ResponseData> logout(SessionForToken login) throws InterruptedException {
		//SessionForToken session = SessionUtilMap.getSession(login.getUserId());
		SessionForToken session = getSessionFromCacheService(login.getUserId());
		if (login.getSessionId() == session.getSessionId()) {
			//SessionUtilMap.removeSession(login.getUserId());
			removeSessionFromCache(login.getUserId());
			ResponseData responseData = ResponseData.create(200);
			return ResponseEntity.ok(responseData);
		}
		ResponseData responseData = ResponseData.create(0);
		return ResponseEntity.ok(responseData);
	}

}
