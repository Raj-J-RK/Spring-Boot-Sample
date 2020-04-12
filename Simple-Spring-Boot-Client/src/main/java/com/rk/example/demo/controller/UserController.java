package com.rk.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.rk.example.demo.domain.User;

@RestController
public class UserController {
	
	@Retryable(maxAttempts=5, backoff=@Backoff (delay=500l), value= {RuntimeException.class})
	@RequestMapping("/callUserService")
	public List<User> fetchUsers() {
		RestTemplate restTemplate = new RestTemplate();
		List<User> users =  restTemplate.getForObject("http://localhost:8081/getUserList", ArrayList.class);
		return users;
	}

}
