package com.luv2code.aopdemo.entity;

public class Account {
	
	private String name;
	
	public Account(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		System.out.println("Account.getName is called");
		return name;
	}

	public void setName(String name) {
		System.out.println("Account.setName is called");
		this.name = name;
	}

	@Override
	public String toString() {
		return "Account [name=" + name + "]";
	}
}
