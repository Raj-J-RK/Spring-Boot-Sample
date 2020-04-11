package com.rk.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JspController {

	@RequestMapping ("/jsp_welcome")
	public String jspWelcome() {
		
		return "welcome";
		
	}
}
