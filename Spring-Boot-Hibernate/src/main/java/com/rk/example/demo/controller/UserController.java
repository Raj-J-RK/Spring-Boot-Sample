package com.rk.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rk.example.demo.entity.UserEntity;
import com.rk.example.demo.repository.UserRepository;

@RestController
public class UserController {
	
	@Autowired
	UserRepository userRepository;

	@RequestMapping("/getuser")
	public List<UserEntity> fetchUsers() {
		return userRepository.findAll();
	}
}
