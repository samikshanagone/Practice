package com.orosift.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.orosift.userservice.model.User;

@Repository
public interface UserRepository  extends JpaRepository<User, Long>{
	
	
	@Query(value="select email_id from user_details u where email_id=?1",nativeQuery=true)
	public String getEmailByEmialId(String emailId);
	
	
	@Query(value="select * from user_details u where email_id=?1",nativeQuery=true)
	public User getUserByEmialId(String emailId);
	
	
	@Query(value="select * from user_details u where user_id=?1",nativeQuery=true)
	public User getUserbyUserID(String userId);
	
}
