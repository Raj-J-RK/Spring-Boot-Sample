package com.rk.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan("com.rk.example.demo.domain.*")
@EnableJpaRepositories("com.rk.example.demo.domain.*")
@EntityScan("com.rk.example.demo.domain.*")
@SpringBootApplication
public class MicroServiceItemsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroServiceItemsApplication.class, args);
	}

}
