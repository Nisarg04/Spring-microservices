package com.currencyproject.microservices.currencyexchangeservice;

import java.math.BigDecimal;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringRunner;

import com.currencyproject.microservices.currencyexchangeservice.bean.ExchangeValue;
import com.currencyproject.microservices.currencyexchangeservice.dao.CurrencyExchangeRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CurrencyExchangeServiceTest {
	
	//mocked object that is used somewhere from actual class
	@MockBean
	Environment env;
	
	//mocked object that is used somewhere from actual class
	@MockBean
	CurrencyExchangeRepository dao;
	
	//need actual object to call the method
	@Autowired
	CurrencyExchangeService service;
	
	@Test
	public void getExchangeValueTest() {
		ExchangeValue mockValue = new ExchangeValue(1001L, "USD", "INR", new BigDecimal(66), 8000);
		Mockito.when(dao.findByFromAndTo(Mockito.anyString(), Mockito.anyString())).thenReturn(Optional.of(mockValue));
		Mockito.when(env.getProperty(Mockito.anyString())).thenReturn("8080");
		
		service.getExchangeValue("USD", "INR");
	}
}
