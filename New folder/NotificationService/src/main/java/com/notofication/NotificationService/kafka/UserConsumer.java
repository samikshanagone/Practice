package com.notofication.NotificationService.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.notofication.NotificationService.service.NotificationService;
import com.orosoft.kafkabase.kafkadomain.dto.KafkaUserEvent;

@Service
public class UserConsumer {

	@Autowired
	private NotificationService notificationService;

	private static final Logger LOGGER = LoggerFactory.getLogger(UserConsumer.class);

	@KafkaListener(topics = "${spring.kafka.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
	public void consume(KafkaUserEvent event) {
		if (event.getUser().getUserId().isBlank()) {
			notificationService.sendWelcomeMail(event.getUser().getEmailId());
		}
		LOGGER.info(String.format("received succesfully", event.toString()));
		notificationService.sendMail(event.getUser().getEmailId(), event.getUser().getUserId(),
				event.getUser().getOtp());
	}
}
