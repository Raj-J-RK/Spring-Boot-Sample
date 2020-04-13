package com.rk.example.demo.service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.rk.example.demo.domain.User;
import com.rk.example.demo.mapper.UserMapper;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserMapper userMapper;

	@Override
	public List<User> fetchUser() {
		List<User> users = new ArrayList<User>();

		Gson gson = new Gson(); 
		try 
		{ 
			users = gson.fromJson(new FileReader("C:\\Users\\HP\\Documents\\Spring-Boot-Sample\\Simple-Spring-Boot-Web-App\\src\\main\\resources\\user.json"), ArrayList.class); 
		} 
		catch (JsonSyntaxException | JsonIOException | FileNotFoundException e) 
		{ 
			e.printStackTrace(); 
		}
		return users;
	}
	
	@Override
	public List<User> fetchUserFromDb() {
		List<User> users = userMapper.getAllUsers();
		return users;
	}


}
