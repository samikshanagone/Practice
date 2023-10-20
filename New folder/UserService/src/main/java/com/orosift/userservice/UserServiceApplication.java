package com.orosift.userservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.orosift.userservice.websocket.WebSocketService;

import io.vertx.core.Vertx;

@SpringBootApplication
public class UserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
//		Vertx vertx = Vertx.vertx();
//		vertx.deployVerticle(new WebSocketService());
	}

}
