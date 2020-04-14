package com.rk.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rk.example.demo.domain.Item;
import com.rk.example.demo.mapper.ItemMapper;

@RestController
public class ItemController {
	
	@Autowired
	ItemMapper itemMapper;

	@RequestMapping("/item")
	public List<Item> getItems() {
		return itemMapper.getAllItems();
	}
}
