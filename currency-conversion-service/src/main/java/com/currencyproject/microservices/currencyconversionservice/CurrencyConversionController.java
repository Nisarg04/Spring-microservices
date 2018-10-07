package com.currencyproject.microservices.currencyconversionservice;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.currencyproject.microservices.currencyconversionservice.bean.CurrencyConversionBean;

@RestController
public class CurrencyConversionController {

	@GetMapping("/currency-converter/from/{from}/to/{to}/{quantity}")
	public CurrencyConversionBean calculateCurrency(@PathVariable String from, 
			@PathVariable String to, @PathVariable BigDecimal quantity) {
		
		String url = "http://localhost:8000/currency-exchange/ from/{from}/to/{to}";
		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("from", from);
		uriVariables.put("to", to);
		ResponseEntity<CurrencyConversionBean> responseEntity = 
				new RestTemplate().getForEntity(url, CurrencyConversionBean.class, uriVariables);
		CurrencyConversionBean bean = responseEntity.getBody();
		return new CurrencyConversionBean(bean.getId(), from, to, 
				bean.getConversionMultiple(), quantity, 
				quantity.multiply(bean.getConversionMultiple()),bean.getPort());
	}
}
