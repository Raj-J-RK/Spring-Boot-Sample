package com.rk.example.demo.service;

import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;

import com.rk.example.demo.domain.Item;

public class ItemInitializer implements CommandLineRunner{
	
	private final ItemRepository itemRepository;

	ItemInitializer (ItemRepository itemRepository) {
		this.itemRepository = itemRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		Stream.of("Brand 1","Brand 2","Brand 3","Brand 4","Brand 5","Brand 6").forEach(item -> itemRepository.save(new Item(item)));
		itemRepository.findAll().forEach(item -> System.out.println(item));
	}

}
