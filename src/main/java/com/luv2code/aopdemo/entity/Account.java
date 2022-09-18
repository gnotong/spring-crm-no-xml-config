package com.luv2code.aopdemo.entity;

import java.util.logging.Logger;

public class Account {
	
	private Logger logger = Logger.getLogger(getClass().getName());
	
	private String name;
	
	public Account(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		logger.info("Account.getName is called");
		return name;
	}

	public void setName(String name) {
		logger.info("Account.setName is called");
		this.name = name;
	}

	@Override
	public String toString() {
		return "Account [name=" + name + "]";
	}
}
