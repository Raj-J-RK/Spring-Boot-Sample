package com.rk.example.demo.service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.rk.example.demo.domain.User;

@Service
public class UserServiceImpl implements UserService{
	
	@Override
	public List<User> fetchUser() {
		List<User> users = new ArrayList<User>();
		Gson gson = new Gson();
		try {
			users = gson.fromJson(new FileReader("C:\\Users\\HP\\Documents\\Spring-Boot-Sample\\Simple-Spring-Boot-Web-App\\src\\main\\resources\\user.json"), ArrayList.class);
		} catch (JsonSyntaxException | JsonIOException | FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return users;
	}
	

}
