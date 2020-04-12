package com.rk.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.rk.example.demo.domain.Products;

@RestController
public class ProductController {
	
	@Autowired
	RetryTemplate retryTemplate;
	
	@RequestMapping("/callProductService")
	public List<Products> fetchUsers() {
		RestTemplate restTemplate = new RestTemplate();
		return retryTemplate.execute(args -> {
			List<Products> products = restTemplate.getForObject("http://localhost:8081/getProducts", ArrayList.class);
			   return products;
			  });
	}

}
