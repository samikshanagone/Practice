package com.orosift.userservice.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.util.ObjectUtils;

import com.orosift.userservice.model.SessionForToken;

public class SessionUtilMap {

	
	static Map<String, SessionForToken> utilMap = new HashMap<>();

	private SessionUtilMap() {
		// should not create the object
	}

	public static void saveSession(SessionForToken session) {
		utilMap.put(session.getUserId(), session);
		System.out.println("Session Map :" + session.toString());
	}

	public static SessionForToken getSession(String username) {
		SessionForToken sessionForToken = utilMap.get(username);
		return sessionForToken;
	}

	public static void removeSession(String sessionId) {
		System.out.println("Session Removed");
		utilMap.remove(sessionId);
	}

	public static boolean isUserActive(String userId, String device, int sessionId) {
		SessionForToken sessionForToken = utilMap.get(userId);

		System.out.println(sessionForToken.getUserId());
		if (ObjectUtils.isEmpty(sessionForToken)) {//if sessionForToken is null or empty return true
			return false;
		} else if (!device.equalsIgnoreCase(sessionForToken.getDeviceString())) {
			return false;

		} else if (sessionId != sessionForToken.getSessionId()) {
			return false;

		} else {
			return true;
		}
	}
}
