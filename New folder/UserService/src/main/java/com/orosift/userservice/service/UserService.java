package com.orosift.userservice.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.orosift.userservice.Util.ResponseData;
import com.orosift.userservice.model.Login;
import com.orosift.userservice.model.SessionForToken;
import com.orosift.userservice.model.User;

public interface UserService {

	public String updateUser(User user, Long id);

	public User getUserByEmailId(String emailId);


	public void addDataToCacheService(User user);

	public User getDataFromCacheService(String userId);

	public User getUserbyuserID(String userId);
	
	public void removeDataFromCacheService(String userId);

	public ResponseEntity<ResponseData> signUp(String user1)
			throws InterruptedException, JsonMappingException, JsonProcessingException;

	public ResponseEntity<ResponseData> validateotp(String user) throws JsonMappingException, JsonProcessingException, InterruptedException;

	public ResponseEntity<ResponseData> storeUser(User us) throws InterruptedException;

	public ResponseEntity<ResponseData> loginUser(Login login) throws InterruptedException;

	public ResponseEntity<ResponseData> userForgetPass(User us) throws InterruptedException;

	public ResponseEntity<ResponseData> validateOTPforForgetPassword(String us)
			throws InterruptedException, JsonMappingException, JsonProcessingException;
	
	public ResponseEntity<ResponseData> changePassword(User us) throws InterruptedException;
	
	public ResponseEntity<ResponseData> logout(SessionForToken login) throws InterruptedException;
}
