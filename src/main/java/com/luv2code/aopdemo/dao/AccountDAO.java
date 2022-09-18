package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class AccountDAO {
	
	private String name;
	
	public void addAccount() {
		System.out.println(getClass() + " ADDING ACCOUNT");
	}

	public String getName() {
		System.out.println("AccountDAO.getName is called");
		return name;
	}

	public void setName(String name) {
		System.out.println("AccountDAO.setName is called");
		this.name = name;
	}
}
