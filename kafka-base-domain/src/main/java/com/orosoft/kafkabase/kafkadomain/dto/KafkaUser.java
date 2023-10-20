package com.orosoft.kafkabase.kafkadomain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class KafkaUser {

	private String emailId;
	private String otp;
	private String userId;

}
