package com.rk.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.rk.example.demo.domain.*;

@RestController
public class ExchangeController {
	
	@Autowired
	RetryTemplate retryTemplate;
	
	@GetMapping("/getExchanges")
	public List<Exchange> getExchangeDate() {
		RestTemplate restTemplate = new RestTemplate();
		return retryTemplate.execute(args -> {
			List<Exchange> exchangeList = restTemplate.getForObject("https://financialmodelingprep.com/api/v3/search?query=AA&exchange=NASDAQ&apikey=demo", ArrayList.class);
			return exchangeList;
		});
	}

}
