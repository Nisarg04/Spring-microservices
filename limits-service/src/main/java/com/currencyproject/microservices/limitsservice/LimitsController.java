package com.currencyproject.microservices.limitsservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsController {
	
	@Value("${congfig.value.minimum}")
	private int minimum;
	@Value("${congfig.value.miximum}")
	private int maximum;
	
	@Autowired
	private ValueConfiguration config;
	
	@GetMapping("/limits-from-properties")
	public LimitConfig rerieveLimitsFromPropertiesFile() {
		return new LimitConfig(minimum, maximum);
	}
	
	@GetMapping("/limits-from-config-class")
	public LimitConfig rerieveLimitsFromConfigClass() {
		return new LimitConfig(config.getMinimum(), config.getMaximum());
	}
}
