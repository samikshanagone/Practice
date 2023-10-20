package com.orosift.userservice.model;

import java.util.Random;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SessionForToken {
	

	@Id
	private int sessionId;
	private String userId;
	private String token;
	private String deviceString;

	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getDeviceString() {
		return deviceString;
	}

	public void setDeviceString(String deviceString) {
		this.deviceString = deviceString;
	}

	public int getSessionId() {
		return sessionId;
	}

	public void setSessionId(int sessionId) {
		this.sessionId = sessionId;
	}
	
	@Override
	public String toString() {
		return "SessionForToken [sessionId=" + sessionId + ", userId=" + userId + ", token=" + token + ", deviceString="
				+ deviceString + "]";
	}
	
}
