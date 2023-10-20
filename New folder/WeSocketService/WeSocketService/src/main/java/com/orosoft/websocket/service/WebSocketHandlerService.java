package com.orosoft.websocket.service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.orosoft.websocket.model.UserDataWeb;

import io.vertx.core.Handler;
import io.vertx.core.MultiMap;
import io.vertx.core.http.ServerWebSocket;

@Service
public class WebSocketHandlerService implements Handler<ServerWebSocket> {

//	@GrpcClient("CachingService")
//	private static CachingServiceGrpc.CachingServiceStub cacheStub;

//for userId and webSocket
	private Map<String, ServerWebSocket> activeUserInfo = new HashMap<>();

//for userId-device and device
	private static Map<String, UserDataWeb> beatTrackStore = new HashMap<>();

	@Override
	public void handle(ServerWebSocket webSocket) {
		MultiMap map = webSocket.headers();
		String headerString = map.get("Sec-WebSocket-Protocol");
		System.out.println(headerString);
		String[] data = headerString.split(",");
		System.out.println("data from front end " + data);
		String userId = data[1].trim();
		int sessionId = Integer.parseInt(data[2].trim());
		String device = data[3].trim();
		System.out.println("user id from front end " + device);
		System.out.println(userId);
		//getDataFromCacheService("user3811");
		System.out.println("grpc ");
		// boolean res = SessionUtilMap.isUserActive(userId,device,sessionId);
		boolean res = true;
		System.out.println(res);
		if (!res) {
			System.out.println(" User isn't logged in");
			webSocket.close((short) 500);
			return;
		}
		activeUserInfo.put(userId, webSocket);
		webSocket.textMessageHandler(message -> {
			webSocket.writeTextMessage(message);
			System.out.println("msg " + message);
			String[] split = message.split(":");
			String mt = split[1];
			System.out.println("MT "+mt);
			// Update the last heartbeat time when a message is received
			beatTrackStore.put(userId + "-" + device, new UserDataWeb(System.currentTimeMillis(), true));
			System.out.println("map " + beatTrackStore);
		});
		webSocket.closeHandler(close -> {
			handleWebSocketClose(userId);
		});
	}

	public void checkPingInterval(long timerId) {
		System.out.println("inside checkPing");
		System.out.println("map check " + beatTrackStore);
		System.out.println("Size of HeartBeat Map " + beatTrackStore.size());
		long currentTime = System.currentTimeMillis();
		Iterator<Map.Entry<String, UserDataWeb>> iterator = beatTrackStore.entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry<String, UserDataWeb> entry = iterator.next();
			String key = entry.getKey();
			System.out.println("Key " + key);
			String[] parts = key.split("-");
			if (parts.length == 2) {
				String userId = parts[0];
				// String device = parts[1];
				Long lastHeartbeatTime = entry.getValue().getTime();
				long idleTime = currentTime - lastHeartbeatTime;
				System.out.println("Status : " + entry.getValue().isStatus());
				if (idleTime > 30000) {
					if (entry.getValue().isStatus()) {
						handleWebSocketClose(userId);
						entry.getValue().setStatus(false);
					}
					if (idleTime > 120000) {
						iterator.remove();
						System.out.println("## before forecefull logout ##");
						// SessionUtilMap.removeSession(userId);
					}
				}
			}
		}
	}

	private void handleWebSocketClose(String userId) {
		ServerWebSocket webSocket = activeUserInfo.remove(userId);
		if (webSocket != null) {
			try {
				webSocket.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

//	public void getDataFromCacheService(String userId) {
//		StoreOTP build = StoreOTP.newBuilder().setUserId("use").setOTP("222556").build();
//		cacheStub.storeOTP(build, new StreamObserver<StoreOTPResponse>() {
//			@Override
//			public void onNext(StoreOTPResponse data) {
//				System.out.println("Received: web socket");
//			}
//
//			@Override
//			public void onError(Throwable t) {
//				t.printStackTrace();
//			}
//
//			@Override
//			public void onCompleted() {
//				System.out.println("Stream completed for adding otp");
//			}
//		});
//	}
}
