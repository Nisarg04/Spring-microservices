package com.currencyproject.microservices.currencyexchangeservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.currencyproject.microservices.currencyexchangeservice.bean.ExchangeValue;

public interface CurrencyExchangeRepository extends JpaRepository<ExchangeValue, Long> {
	ExchangeValue findByFromAndTo(String from, String to);
}
