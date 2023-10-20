package com.orosift.userservice.model;

import lombok.Data;

@Data
public class UserOtp {
	
	private String userId;
	private String OTP;
	private String email;
}
