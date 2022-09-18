package com.luv2code.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.entity.Account;

@Component
public class AccountDAO {
	
	private String name;
	
	public void addAccount(Account account, boolean isAdded) {
		System.out.println(getClass() + " ADDING ACCOUNT");
		System.out.println(account + " is added=" + isAdded);
	}
	
	public List<Account> findAll() {
		List<Account> accounts = new ArrayList<>();

		accounts.add(new Account("Yann"));
		accounts.add(new Account("nahema"));
		accounts.add(new Account("Maya"));
		
		return accounts;
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
