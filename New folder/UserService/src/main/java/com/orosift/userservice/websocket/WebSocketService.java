package com.orosift.userservice.websocket;

import org.springframework.stereotype.Component;

import com.orosoft.grpc.CachingServiceGrpc;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerOptions;
import net.devh.boot.grpc.client.inject.GrpcClient;

@Component
public class WebSocketService extends AbstractVerticle {
	
	@GrpcClient("CachingService")
	private CachingServiceGrpc.CachingServiceStub cacheStub;
	
	
	@Override
	public void start() {
//		HttpServerOptions options = new HttpServerOptions().addWebSocketSubProtocol("OSC-WebSocket-Protocol");
//		HttpServer server = vertx.createHttpServer(options);
//		server.webSocketHandler(new WebSocketHandlerService()::handle);
//		server.listen(8888);
//		System.out.println("Websocket Server Start");
//		vertx.setPeriodic(10_000, new WebSocketHandlerService()::checkPingInterval);
//		System.out.println("Check Ping");
	}

}