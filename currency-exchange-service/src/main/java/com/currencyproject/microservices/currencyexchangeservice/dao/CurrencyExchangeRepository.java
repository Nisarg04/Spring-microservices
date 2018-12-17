package com.currencyproject.microservices.currencyexchangeservice.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.currencyproject.microservices.currencyexchangeservice.bean.ExchangeValue;

public interface CurrencyExchangeRepository extends JpaRepository<ExchangeValue, Long> {
	Optional<ExchangeValue> findByFromAndTo(String from, String to);
}
