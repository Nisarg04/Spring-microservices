package com.currencyproject.microservices.currencyexchangeservice;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.currencyproject.microservices.currencyexchangeservice.bean.ExchangeValue;
import com.currencyproject.microservices.currencyexchangeservice.dao.CurrencyExchangeRepository;

@Service
public class CurrencyExchangeService {
	
	@Autowired
	Environment env;
	
	@Autowired
	CurrencyExchangeRepository dao;
	
	public Optional<ExchangeValue> getExchangeValue(String from, String to) {
		Optional<ExchangeValue> exchangeValue = dao.findByFromAndTo(from, to);
		
		if(exchangeValue.isPresent())
			exchangeValue.get().setPort(Integer.parseInt(env.getProperty("local.server.port")));
		return exchangeValue;
	}
	
}
