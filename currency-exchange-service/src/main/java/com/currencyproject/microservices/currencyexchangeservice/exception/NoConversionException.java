package com.currencyproject.microservices.currencyexchangeservice.exception;

public class NoConversionException extends RuntimeException {
	
	String msg;
	
	public NoConversionException(String msg) {
		super(msg);		
		this.msg=msg;
	}
	
	public String toString() {
		return "Exception : " + this.msg;
	}
}
