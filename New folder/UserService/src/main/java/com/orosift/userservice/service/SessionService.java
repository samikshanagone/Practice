package com.orosift.userservice.service;

import com.orosift.userservice.model.SessionForToken;

public interface SessionService {

	public void saveSession(SessionForToken session);
	
	public SessionForToken getSession(String username);
	
	public SessionForToken getSession(String username,int sessionId);
	
	public void removeSession(SessionForToken session);
	
	public boolean isUserActive(String userId, String device);
}
