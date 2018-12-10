package com.currencyproject.microservices.limitsservice;

public class LimitConfig {

	private int minimum;
	private int maximum;
	private String profile;

	public LimitConfig() {}
	
	public LimitConfig(int i, int j, String profile) {
		minimum=i;
		maximum=j;
		this.profile=profile;
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
	
	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}
}
