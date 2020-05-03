package com.rk.example.swagger.service;

import java.util.List;

import com.rk.example.swagger.domain.Products;

public interface ProductService {
	
	List<Products> fetchProducts();

}
