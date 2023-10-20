package com.orosift.userservice.websocket;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.orosift.userservice.model.UserData;
import com.orosift.userservice.service.SessionUtilMap;

import io.vertx.core.Handler;
import io.vertx.core.MultiMap;
import io.vertx.core.http.ServerWebSocket;

@Service
public class WebSocketHandlerService implements Handler<ServerWebSocket> {
	
	
//for userId and webSocket
	private Map<String, ServerWebSocket> activeUserInfo = new HashMap<>();

//for userId-device and device
	private static Map<String, UserData> beatTrackStore = new HashMap<>();

	@Override
	public void handle(ServerWebSocket webSocket) {

		MultiMap map = webSocket.headers();
		String headerString = map.get("Sec-WebSocket-Protocol");
		System.out.println(headerString);
		String[] data = headerString.split(",");
		System.out.println("data from front end "+data);
		String userId = data[1].trim();
		int sessionId = Integer.parseInt(data[2].trim());
		String device = data[3].trim();
		System.out.println("user id from front end "+device);
		System.out.println(userId);
		boolean res = SessionUtilMap.isUserActive(userId,device,sessionId);
		System.out.println(res);
		if (!res) {
			System.out.println(" User isn't logged in");
			webSocket.close((short) 500);
			return;
		}
		activeUserInfo.put(userId, webSocket);
		webSocket.textMessageHandler(message -> {
			webSocket.writeTextMessage(message);
			System.out.println("msg "+message);
			// Update the last heartbeat time when a message is received
			beatTrackStore.put(userId + "-" + device, new UserData(System.currentTimeMillis(), true));
			System.out.println("map "+beatTrackStore);
		});
		webSocket.closeHandler(close -> {
			handleWebSocketClose(userId);
		});
	}

	public void checkPingInterval(long timerId) {
		System.out.println("inside checkPing");
		System.out.println("map check "+beatTrackStore);
		System.out.println("Size of HeartBeat Map " + beatTrackStore.size());
		long currentTime = System.currentTimeMillis();
		Iterator<Map.Entry<String, UserData>> iterator = beatTrackStore.entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry<String, UserData> entry = iterator.next();
			String key = entry.getKey();
			System.out.println("Key " + key);
			String[] parts = key.split("-");
			if (parts.length == 2) {
				String userId = parts[0];
				//String device = parts[1];
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
						SessionUtilMap.removeSession(userId);
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
}
