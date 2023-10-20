package com.orosoft.websocket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.orosoft.grpc.CachingServiceGrpc;
import com.orosoft.grpc.StoreOTP;
import com.orosoft.websocket.service.WebSocketService;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.vertx.core.Vertx;

@SpringBootApplication
public class WeSocketServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeSocketServiceApplication.class, args);
		ManagedChannel build = ManagedChannelBuilder.forAddress("localhost", 7575)
        .usePlaintext() // Use plaintext for simplicity; consider using TLS in production
        .build();
		CachingServiceGrpc.CachingServiceBlockingStub blockingStub = CachingServiceGrpc.newBlockingStub(build);
		StoreOTP buildotp = StoreOTP.newBuilder().setUserId("use").setOTP("222556").build();
		blockingStub.storeOTP(buildotp);
		Vertx vertx = Vertx.vertx();
		vertx.deployVerticle(new WebSocketService());
	}

}
