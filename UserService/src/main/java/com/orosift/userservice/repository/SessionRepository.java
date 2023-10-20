package com.orosift.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.orosift.userservice.model.SessionForToken;

@Repository
public interface SessionRepository extends JpaRepository<SessionForToken, String> {
	
	@Query(value="select * from session_for_token u where user_id=?1",nativeQuery=true)
	public SessionForToken getTokenFromUsername(String user_id);
	
	
	@Query(value="select * from session_for_token u where user_id=?1 and session_id=?2",nativeQuery=true)
	public SessionForToken getTokenFromUsernameAndSessionId(String user_id,int session_id);
	
	@Query(value="select * from session_for_token u where user_id=?1 and device_string=?2",nativeQuery=true)
	public SessionForToken getTokenFromUsernameAndDeviceName(String user_id,String device_string);

}
