package com.currencyproject.microservices.limitsservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsController {
	
	@Autowired
	private ValueConfiguration config;
	
	@GetMapping("/limits")
	public LimitConfig rerieveLimitsFromConfigClass() {
		return new LimitConfig(config.getMinimum(), config.getMaximum());
	}
}
