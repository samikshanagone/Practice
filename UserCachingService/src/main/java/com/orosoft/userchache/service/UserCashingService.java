package com.orosoft.userchache.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.hazelcast.config.Config;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;
import com.orosoft.grpc.CachingServiceGrpc;
import com.orosoft.grpc.RemoveOTPRequest;
import com.orosoft.grpc.RemoveOTPResponse;
import com.orosoft.grpc.RemoveSessionRequest;
import com.orosoft.grpc.RemoveSessionResponse;
import com.orosoft.grpc.RemoveUserRequest;
import com.orosoft.grpc.RemoveUserResponse;
import com.orosoft.grpc.StoreOTP;
import com.orosoft.grpc.StoreOTPResponse;
import com.orosoft.grpc.StoreSessionResponse;
import com.orosoft.grpc.StoreUserResponse;
import com.orosoft.grpc.UserData;
import com.orosoft.grpc.UserRequest;
import com.orosoft.grpc.UserSession;
import com.orosoft.grpc.UserSessionRequest;
import com.orosoft.grpc.ValidateOTPRequest;
import com.orosoft.grpc.ValidateOTPResponse;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class UserCashingService extends CachingServiceGrpc.CachingServiceImplBase {

	Config config = new Config();
	HazelcastInstance hazelcastInstance = Hazelcast.newHazelcastInstance(config);
	IMap<String, UserData> cache = hazelcastInstance.getMap("myCache");
	IMap<String, String> OTPcache = hazelcastInstance.getMap("myCacheOTP");
	IMap<String, Integer> counterCache = hazelcastInstance.getMap("counterCache");
	Map<String, UserSession> sessionCache = new HashMap<>();

	@Override
	public void storeUser(UserData userRequest, StreamObserver<StoreUserResponse> streamObserver) {
		cache.put(userRequest.getUserId(), userRequest);
		System.out.println("User in Cache " + cache.get(userRequest.getUserId()));
		streamObserver.onNext(StoreUserResponse.newBuilder().setSuccess(true).build());
		streamObserver.onCompleted();
	}

	@Override
	public void storeOTP(StoreOTP storeOTP, StreamObserver<StoreOTPResponse> streamObserver) {
		OTPcache.put(storeOTP.getUserId(), storeOTP.getOTP());
		counterCache.put(storeOTP.getUserId(), 0);
		System.out.println("OTP in cache " + OTPcache.get(storeOTP.getUserId()));
		streamObserver.onNext(StoreOTPResponse.newBuilder().setSuccess(true).build());
		streamObserver.onCompleted();
	}
	
	@Override
	public void storeUserSession(UserSession userRequest, StreamObserver<StoreSessionResponse> streamObserver) {
		sessionCache.put(userRequest.getUserId(), userRequest);
		System.out.println("Session in cache " + sessionCache.get(userRequest.getUserId()));
		streamObserver.onNext(StoreSessionResponse.newBuilder().setSuccess(true).build());
		streamObserver.onCompleted();
	}

	@Override
	public void validateOTP(ValidateOTPRequest otp, StreamObserver<ValidateOTPResponse> userObserver) {
		Set<String> keySet = OTPcache.keySet();
		if (keySet.contains(otp.getUserId())) {
			String cacheOTP = OTPcache.get(otp.getUserId());
			if (otp.getOtp().equals(cacheOTP)) {
				counterCache.put(otp.getUserId(), 0);
				userObserver.onNext(ValidateOTPResponse.newBuilder().setOptMatched(true).build());
				userObserver.onCompleted();
			} else if (counterCache.get(otp.getUserId()) >= 3) {
				counterCache.put(otp.getUserId(), 0);
				userObserver.onNext(ValidateOTPResponse.newBuilder().setMaxTryReach(true).build());
				userObserver.onCompleted();
			} else if (!(otp.getOtp().equals(cacheOTP))) {
				Integer integer = counterCache.get(otp.getUserId());
				integer++;
				counterCache.put(otp.getUserId(), integer);
				userObserver.onNext(ValidateOTPResponse.newBuilder().setOptMatched(false).build());
				userObserver.onCompleted();
			}
		} else {
			userObserver.onNext(ValidateOTPResponse.newBuilder().setUserIdValid(true).build());
			userObserver.onCompleted();
		}
	}

	@Override
	public void getUser(UserRequest request, StreamObserver<UserData> userObserver) {
		String userId = request.getUserId();
		System.out.println("User data in cache " + cache.get(userId));
		UserData userData = cache.get(userId);
		userObserver.onNext(userData);
		userObserver.onCompleted();
	}
	
	@Override
	public void getUserSession(UserSessionRequest request, StreamObserver<UserSession> userObserver) {
		String userId = request.getUserId();
		System.out.println("User session in cache " + sessionCache.get(userId));
		UserSession userSession = sessionCache.get(userId);
		userObserver.onNext(userSession);
		userObserver.onCompleted();
	}

	@Override
	public void removeUser(RemoveUserRequest key, StreamObserver<RemoveUserResponse> remObserver) {
		System.out.println(cache.remove(key.getUserId()));
		cache.remove(key.getUserId());
		RemoveUserResponse build = RemoveUserResponse.newBuilder().setSuccess(true).build();
		remObserver.onNext(build);
		remObserver.onCompleted();
	}

	@Override
	public void removeUserSession(RemoveSessionRequest key, StreamObserver<RemoveSessionResponse> remObserver) {
//		System.out.println(sessionCache.remove(key));
//		sessionCache.remove(key);
//		RemoveSessionResponse build = RemoveSessionResponse.newBuilder().setSuccess(true).build();
//		remObserver.onNext(build);
//		remObserver.onCompleted();
		 String userId = key.getUserId();
		    UserSession removedSession = sessionCache.remove(userId);
		    if (removedSession != null) {
		        System.out.println("Removed session: " + removedSession);
		        RemoveSessionResponse build = RemoveSessionResponse.newBuilder().setSuccess(true).build();
		        remObserver.onNext(build);
		    } else {
		        // Handle the case where the session doesn't exist
		        System.out.println("Session not found for user: " + userId);
		        RemoveSessionResponse build = RemoveSessionResponse.newBuilder().setSuccess(false).build();
		        remObserver.onNext(build);
		    }
		    remObserver.onCompleted();
	}
	
	@Override
	public void removeOTP(RemoveOTPRequest key, StreamObserver<RemoveOTPResponse> remObserver) {
		System.out.println(OTPcache.remove(key.getUserId()));
		OTPcache.remove(key.getUserId());
		RemoveOTPResponse build = RemoveOTPResponse.newBuilder().setSuccess(true).build();
		remObserver.onNext(build);
		remObserver.onCompleted();
	}
}
