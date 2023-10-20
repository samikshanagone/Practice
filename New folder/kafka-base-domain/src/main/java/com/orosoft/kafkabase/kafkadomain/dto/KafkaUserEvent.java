package com.orosoft.kafkabase.kafkadomain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class KafkaUserEvent {
	
	private KafkaUser User;
	private String status;
	

}
