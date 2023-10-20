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
		Vertx vertx = Vertx.vertx();
		vertx.deployVerticle(new WebSocketService());
	}
}
