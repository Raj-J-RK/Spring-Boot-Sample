package com.rk.example.demo.domain;

public class Exchange {
	
	private String symbol;
	private String name;
	private String currency;
	private String stockExchange;
	
	@Override
	public String toString() {
		return "Exchange [symbol=" + symbol + ", name=" + name + ", currency=" + currency + ", stockExchange="
				+ stockExchange + ", exchangeShortName=" + exchangeShortName + "]";
	}
	private String exchangeShortName;
	
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getStockExchange() {
		return stockExchange;
	}
	public void setStockExchange(String stockExchange) {
		this.stockExchange = stockExchange;
	}
	public String getExchangeShortName() {
		return exchangeShortName;
	}
	public void setExchangeShortName(String exchangeShortName) {
		this.exchangeShortName = exchangeShortName;
	}
	
	

}
