package com.orosift.userservice.websocket;

//@Component
//public class WebSocketService extends AbstractVerticle {
//	
//	
//	@Override
//	public void start() {
//		HttpServerOptions options = new HttpServerOptions().addWebSocketSubProtocol("OSC-WebSocket-Protocol");
//		HttpServer server = vertx.createHttpServer(options);
//		server.webSocketHandler(new WebSocketHandlerService()::handle);
//		server.listen(8888);
//		System.out.println("Websocket Server Start");
//		vertx.setPeriodic(10_000, new WebSocketHandlerService()::checkPingInterval);
//		System.out.println("Check Ping");
//	}
//
//}