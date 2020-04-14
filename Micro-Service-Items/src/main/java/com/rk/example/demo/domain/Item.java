package com.rk.example.demo.domain;

import java.math.BigDecimal;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
public class Item {
	
	private String id;
	private String name;
	private String brand;
	private String category;
	private BigDecimal price;
	
	public Item(String item) {
		this.name=item;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", brand=" + brand + ", category=" + category + ", price=" + price
				+ "]";
	}

}
