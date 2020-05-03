package com.rk.example.kafka.controller;

import org.hibernate.validator.constraints.pl.REGON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rk.example.kafka.service.KafkaService;

@RestController
@RequestMapping("/kafka")
public class KafkaController {
	
	@Autowired
	KafkaService kafkaService;
	
	@GetMapping
	@RequestMapping("/produce")
	public String postMsg(@RequestParam("message") String message) {
		
		kafkaService.pushMessage(message);
		
		return "Message posted";
		
	}
	
}
