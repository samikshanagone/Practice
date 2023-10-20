package com.orosoft.userchache.service;

import com.hazelcast.config.Config;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;
import com.orosoft.grpc.CachingServiceGrpc;
import com.orosoft.grpc.RemoveUserRequest;
import com.orosoft.grpc.RemoveUserResponse;
import com.orosoft.grpc.StoreUserResponse;
import com.orosoft.grpc.UserData;
import com.orosoft.grpc.UserRequest;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class UserCashingService extends CachingServiceGrpc.CachingServiceImplBase {
	
	Config config = new Config();
	HazelcastInstance hazelcastInstance = Hazelcast.newHazelcastInstance(config);
	IMap<String, UserData> cache = hazelcastInstance.getMap("myCache");


	@Override
	public void  storeUser(UserData userRequest,StreamObserver<StoreUserResponse> streamObserver) {
		cache.put(userRequest.getUserId(), userRequest);
		System.out.println("Samiksha "+cache.get(userRequest.getUserId()));
		streamObserver.onNext(StoreUserResponse.newBuilder().setSuccess(true).build());
		streamObserver.onCompleted();
	}

//	public void storeUser(UserData data, StreamObserver<StoreUserResponse> observer) {
//		String userId = data.getUserId();
//		UserData build = UserData.newBuilder().setUserId(userId).setName(data.getName()).setContact(data.getContact())
//				.setEmail(data.getEmail()).setDob(data.getDob()).build();
//		UserCashingService serviceObj = new UserCashingService();
//		serviceObj.addToCache(userId, build);
//	}

	@Override
	public void getUser(UserRequest request,StreamObserver<UserData> userObserver) {
		String userId = request.getUserId();
		System.out.println(cache.get(userId));
		UserData userData = cache.get(userId);
		userObserver.onNext(userData);
		userObserver.onCompleted();
	}

	@Override
	public void removeUser(RemoveUserRequest key ,StreamObserver<RemoveUserResponse> remObserver) {
		System.out.println(cache.remove(key));
		cache.remove(key);
		RemoveUserResponse build = RemoveUserResponse.newBuilder().setSuccess(true).build();
		remObserver.onNext(build);
		remObserver.onCompleted();
	}
}
