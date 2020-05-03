package com.rk.example.kafka.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

	@KafkaListener(topics="testtopic")
	public void listenTopic(String message) {
		System.out.println("Message : " + message);
	}	
}
