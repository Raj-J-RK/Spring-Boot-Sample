package com.rk.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@RestController
public class MainController {
	
	@RequestMapping("/main")
	public String welcomeUser(@RequestParam String user) {
		return "Welcome " + user;
	}

}
