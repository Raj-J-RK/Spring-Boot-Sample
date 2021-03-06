package com.rk.example.swagger.service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.rk.example.swagger.domain.Products;

@Service
public class ProductServiceImpl  implements ProductService{
	
	@Override
	public List<Products> fetchProducts() {
		List<Products> productslist = new ArrayList<Products>();
		Gson gson = new Gson();
		try {
			productslist = gson.fromJson(new FileReader("C:\\Users\\HP\\Documents\\Spring-Boot-Sample\\Spring-Boot-swagger\\src\\main\\resources\\products.json"), ArrayList.class);
		} catch (JsonSyntaxException | JsonIOException | FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return productslist;
	}

}
