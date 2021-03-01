package com.rk.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rk.example.demo.domain.User;
import com.rk.example.demo.service.UserService;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@RestController
public class UserController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping("/getUserList")
	public List<User> getUsers() {
		List<User> userList = new ArrayList<User>();
		userList = userService.fetchUser();
		return userList;
	}
	
	@RequestMapping("/getUserListFromDb")
	public List<User> getUsersFromDb() {
		List<User> userList = new ArrayList<User>();
		userList = userService.fetchUserFromDb();
		return userList;
	}

}
