package com.currencyproject.microservices.currencyexchangeservice;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.currencyproject.microservices.currencyexchangeservice.bean.ExchangeValue;
import com.currencyproject.microservices.currencyexchangeservice.exception.NoConversionException;

@RestController
public class CurrencyExchangeController {

	@Autowired
	CurrencyExchangeService service;

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public ResponseEntity<ExchangeValue> getExchange(@PathVariable String from, @PathVariable String to)
			throws NoConversionException {

		Optional<ExchangeValue> exchangeValue = service.getExchangeValue(from, to);

		if(!exchangeValue.isPresent())
			throw new NoConversionException(from + " -> " + to);
		return new ResponseEntity<ExchangeValue>(exchangeValue.get(), HttpStatus.ACCEPTED);
	}

	/*@ExceptionHandler({Exception.class})
	public String handleException() {
		return "from handleException() of Controller";
	}*/

}
