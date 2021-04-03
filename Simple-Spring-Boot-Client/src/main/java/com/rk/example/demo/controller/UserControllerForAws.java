package com.rk.example.demo.controller;



import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.rk.example.demo.domain.User;

@RestController
public class UserControllerForAws {

	@Retryable(maxAttempts=5, backoff=@Backoff (delay=500l), value= {RuntimeException.class})
	@RequestMapping("/getUsers")
	public List<User> fetchUsers() {
		List<User> users = setUsers();
		return users;
	}
	
	private List<User> setUsers() {
		List<User> users = new ArrayList<User>();
		for(int i = 0; i<50; i++) {
			User u = new User("userId"+i, "userfName"+i, "userlName"+i, 25+i, "city"+i, "country"+i, false, LocalDate.now());
			users.add(u);
		}
		return users;
	}
	
	@Retryable(maxAttempts=5, backoff=@Backoff (delay=500l), value= {RuntimeException.class})
	@RequestMapping("/getUsersfroms3")
	public List<User> fetchUsersFromS3() {
		RestTemplate restTemplate = new RestTemplate();
		List<User> users =  restTemplate.getForObject("https://rk-test-bkt.s3.ap-south-1.amazonaws.com/userData.json", ArrayList.class);
		return users;
	}
}
