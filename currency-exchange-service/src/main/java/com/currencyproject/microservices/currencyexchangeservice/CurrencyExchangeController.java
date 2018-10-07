package com.currencyproject.microservices.currencyexchangeservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.currencyproject.microservices.currencyexchangeservice.bean.ExchangeValue;
import com.currencyproject.microservices.currencyexchangeservice.dao.CurrencyExchangeRepository;

@RestController
public class CurrencyExchangeController {

	@Autowired
	Environment env;
	
	@Autowired
	CurrencyExchangeRepository dao;
		
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public ExchangeValue getExchange(@PathVariable String from, @PathVariable String to) {
		ExchangeValue exchangeValue = dao.findByFromAndTo(from, to);
		exchangeValue.setPort(Integer.parseInt(env.getProperty("local.server.port")));
		return exchangeValue;
	}
	
}
 