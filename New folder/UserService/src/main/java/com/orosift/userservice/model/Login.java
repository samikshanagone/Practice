package com.orosift.userservice.model;

import lombok.Data;

@Data
public class Login {

	private String userId;
	private String password;
	private String loginDevice;
}
