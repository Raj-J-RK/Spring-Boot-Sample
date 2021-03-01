package com.rk.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.rk.example.demo.domain.Products;
import com.rk.example.demo.service.ProductService;

import springfox.documentation.swagger2.annotations.EnableSwagger2;


@EnableSwagger2
@RestController
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	//Returning 401 for testing custom retry handler in client application
	@RequestMapping("/getProducts")
	@ResponseStatus(code = HttpStatus.UNAUTHORIZED)
	public List<Products> getProducts() {
		return productService.fetchProducts();
	}

}
