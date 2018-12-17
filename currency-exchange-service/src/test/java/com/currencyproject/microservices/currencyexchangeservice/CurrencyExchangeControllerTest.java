package com.currencyproject.microservices.currencyexchangeservice;

import java.math.BigDecimal;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.currencyproject.microservices.currencyexchangeservice.bean.ExchangeValue;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CurrencyExchangeController.class)
public class CurrencyExchangeControllerTest {

	//mocked object that is used somewhere from actual class
	@MockBean
	CurrencyExchangeService service;
	
	//need actual object to call the method
	@Autowired
	CurrencyExchangeController controller;

	@Test
	public void getExchangeTest() {
		Optional<ExchangeValue> mockExchangeValue = Optional.of(new ExchangeValue(11L, "USD", "INR", new BigDecimal(65), 8080));
		Mockito.when(service.getExchangeValue(Mockito.anyString(), Mockito.anyString())).thenReturn(mockExchangeValue);
		controller.getExchange("USD", "INR");
	}
}
