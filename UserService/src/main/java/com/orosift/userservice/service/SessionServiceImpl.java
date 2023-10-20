package com.orosift.userservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.orosift.userservice.model.SessionForToken;
import com.orosift.userservice.repository.SessionRepository;

@Service
public class SessionServiceImpl implements SessionService {

	@Autowired
	private SessionRepository repository;

	public void saveSession(SessionForToken session) {
		repository.save(session);
	}

	public SessionForToken getSession(String username) {
		SessionForToken tokenFromUsername = repository.getTokenFromUsername(username);
		return tokenFromUsername;
	}

	public SessionForToken getSession(String username, int sessionId) {
		SessionForToken tokenFromUsername = repository.getTokenFromUsernameAndSessionId(username, sessionId);
		return tokenFromUsername;
	}

	public void removeSession(SessionForToken session) {
		repository.delete(session);
	}

	public boolean isUserActive(String userId, String device) {
		SessionForToken tokenFromUsernameAndDeviceName = repository.getTokenFromUsernameAndDeviceName(userId, device);
		if (ObjectUtils.isEmpty(tokenFromUsernameAndDeviceName)) {
			return false;
		}
		return true;
	}

}
