package com.rk.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rk.example.demo.domain.Products;
import com.rk.example.demo.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@RequestMapping("/getProducts")
	public List<Products> getProducts() {
		return productService.fetchProducts();
	}

}
