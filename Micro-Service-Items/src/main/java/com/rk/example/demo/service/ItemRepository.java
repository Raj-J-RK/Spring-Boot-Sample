package com.rk.example.demo.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.rk.example.demo.domain.Item;

@RepositoryRestResource
public interface ItemRepository extends JpaRepository<Item, Long>{
	
}
