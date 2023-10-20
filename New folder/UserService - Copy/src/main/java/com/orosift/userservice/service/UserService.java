package com.orosift.userservice.service;

import java.util.List;

import com.orosift.userservice.model.User;

public interface UserService {

	public User saveDetails(User user);

	public String updateUser(User user, Long id);

	public List<User> getAllUser();

	public void deleteUser(Long id);

	public User getUserByEmailId(String emailId);

	public String getEmailByEmailId(String emailId);

	public void addDataToCacheService(User user);

	public User getDataFromCacheService(String userId);
	
	public String generateOTP(int lenth);
	
	public User getUserbyuserID(String userId);
	
	public void removeDataFromCacheService(String userId);
}
