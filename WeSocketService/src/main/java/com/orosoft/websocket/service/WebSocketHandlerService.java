package com.orosoft.websocket.service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.orosoft.grpc.CachingServiceGrpc;
import com.orosoft.grpc.RemoveSessionRequest;
import com.orosoft.grpc.RemoveSessionResponse;
import com.orosoft.grpc.UserSession;
import com.orosoft.grpc.UserSessionRequest;
import com.orosoft.websocket.model.UserDataWeb;

import io.vertx.core.Handler;
import io.vertx.core.MultiMap;
import io.vertx.core.http.ServerWebSocket;
import net.devh.boot.grpc.client.inject.GrpcClient;

@Service
public class WebSocketHandlerService implements Handler<ServerWebSocket> {

	@GrpcClient("CachingService")
	private static CachingServiceGrpc.CachingServiceBlockingStub cacheStub;

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
		boolean res = isUserActive(userId,device,sessionId);
		//boolean res = true;
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
			System.out.println("MT " + mt);
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
						removeSessionFromCache(userId);
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

	public boolean isUserActive(String userId, String device, int sessionId) {
		UserSessionRequest build = UserSessionRequest.newBuilder().setUserId(userId).build();
		UserSession userSession = cacheStub.getUserSession(build);
		if (ObjectUtils.isEmpty(userSession)) {// if sessionForToken is null or empty return true
			return false;
		} else if (!device.equalsIgnoreCase(userSession.getDeviceString())) {
			return false;

		} else if (sessionId != userSession.getSessionId()) {
			return false;

		} else {
			return true;
		}
	}
	
	public void removeSessionFromCache(String userId) {
		RemoveSessionRequest build = RemoveSessionRequest.newBuilder().setUserId(userId).build();
		RemoveSessionResponse removeUserSession = cacheStub.removeUserSession(build);
		System.out.println("Remove session "+removeUserSession);
	}
}
