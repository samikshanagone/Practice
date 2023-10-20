package com.orosift.userservice.service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orosift.userservice.model.User;
import com.orosift.userservice.repository.UserRepository;
import com.orosoft.grpc.CachingServiceGrpc;
import com.orosoft.grpc.RemoveUserRequest;
import com.orosoft.grpc.RemoveUserResponse;
import com.orosoft.grpc.StoreUserResponse;
import com.orosoft.grpc.UserData;
import com.orosoft.grpc.UserRequest;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.client.inject.GrpcClient;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User saveDetails(User user) {
		return userRepository.save(user);
	}

	@GrpcClient("CachingService")
	private CachingServiceGrpc.CachingServiceStub cacheStub;

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
	public List<User> getAllUser() {
		List<User> findAll = userRepository.findAll();
		return findAll;
	}

	@Override
	public void deleteUser(Long id) {
		userRepository.deleteById(id);

	}

	@Override
	public User getUserByEmailId(String emailId) {
		User user = userRepository.getUserByEmialId(emailId);
		return user;
	}

	public String getEmailByEmailId(String emailId) {
		String emailByEmialId = userRepository.getEmailByEmialId(emailId);
		return emailByEmialId;
	}

	public void addDataToCacheService(User user) {
		UserData build = UserData.newBuilder().setContact(user.getContact()).setDob(user.getDOB())
				.setEmail(user.getEmail()).setName(user.getName()).setUserId(user.getUserId()).build();
		cacheStub.storeUser(build, new StreamObserver<StoreUserResponse>() {
			@Override
			public void onNext(StoreUserResponse reply) {
				System.out.println("Received: ");
			}

			@Override
			public void onError(Throwable t) {
				t.printStackTrace();
			}

			@Override
			public void onCompleted() {
				System.out.println("Stream completed");
			}
		});
	}

	public User getDataFromCacheService(String userId) {
		UserRequest build = UserRequest.newBuilder().setUserId(userId).build();
		User user = new User();
		cacheStub.getUser(build, new StreamObserver<UserData>() {
			@Override
			public void onNext(UserData data) {
				System.out.println("Received: " + data.getEmail());
				user.setDOB(data.getDob());
				user.setEmail(data.getEmail());
				user.setName(data.getName());
				user.setContact(data.getContact());
				user.setUserId(data.getUserId());
			}

			@Override
			public void onError(Throwable t) {
				t.printStackTrace();
			}

			@Override
			public void onCompleted() {
				System.out.println("Stream completed");
			}
		});
		return user;
	}
	
	public void removeDataFromCacheService(String userId) {
		RemoveUserRequest build = RemoveUserRequest.newBuilder().setUserId(userId).build();
		cacheStub.removeUser(build, new StreamObserver<RemoveUserResponse>() {
			@Override
			public void onNext(RemoveUserResponse reply) {
			}

			@Override
			public void onError(Throwable t) {
				t.printStackTrace();
			}

			@Override
			public void onCompleted() {
			}
		});
	}

	public String generateOTP(int length) {
		String numbers = "123456789";
		Random rndm_method = new Random();
		char[] otp = new char[length];
		for (int i = 0; i < length; i++) {
			otp[i] = numbers.charAt(rndm_method.nextInt(numbers.length()));
		}
		return new String(otp);
	}

	@Override
	public User getUserbyuserID(String userId) {
		User userbyUserID = userRepository.getUserbyUserID(userId);
		return userbyUserID;
	}

}
