package com.rk.example.kafka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaService {
	
	@Autowired
	KafkaTemplate<String, String> kafkaTemplate;
	
	String kafkaTopic = "testtopic1";
	
	public void pushMessage(String message)
	{
		kafkaTemplate.send(kafkaTopic, message);
	}

}
