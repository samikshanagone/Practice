package com.orosift.userservice.model;

import lombok.Data;

@Data
public class OTPResponse {
	
	boolean OTPMatch;
	boolean MaxAttempt;
	boolean usedIdValid;

}
