package com.orosift.userservice.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.orosoft.kafkabase.kafkadomain.dto.KafkaUserEvent;

@Service
public class NotificationProducer {

	private NewTopic newTopic;

	private KafkaTemplate<String, KafkaUserEvent> kafkaTemplate;

	//constructure base dependancy
	public NotificationProducer(NewTopic newTopic, KafkaTemplate<String, KafkaUserEvent> kafkaTemplate) {
		super();
		this.newTopic = newTopic;
		this.kafkaTemplate = kafkaTemplate;
	}

	public void sendMessage(KafkaUserEvent event) {
		System.out.println("Event = " + event);

		Message<KafkaUserEvent> message = MessageBuilder.withPayload(event)
				.setHeader(KafkaHeaders.TOPIC, newTopic.name()).build();

		kafkaTemplate.send(message);
	}
}
