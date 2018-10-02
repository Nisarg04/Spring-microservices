package com.currencyproject.microservices.limitsservice;

public class LimitConfig {

	private int minimum;
	private int maximum;

	public LimitConfig() {}
	
	public LimitConfig(int i, int j) {
		minimum=i;
		maximum=j;
	}

	public int getMinimum() {
		return minimum;
	}

	public void setMinimum(int minimum) {
		this.minimum = minimum;
	}

	public int getMaximum() {
		return maximum;
	}

	public void setMaximum(int maximum) {
		this.maximum = maximum;
	}
	
	
}