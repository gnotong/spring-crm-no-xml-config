package com.luv2code.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.entity.Account;

@Component
public class AccountDAO {
	
	private Logger logger = Logger.getLogger(getClass().getName());
	
	private String name;
	
	public void addAccount(Account account, boolean isAdded) {
		logger.info(getClass() + " ADDING ACCOUNT");
		logger.info(account + " is added=" + isAdded);
	}
	
	public List<Account> findAll() {
		List<Account> accounts = new ArrayList<>();

		accounts.add(new Account("Yann"));
		accounts.add(new Account("nahema"));
		accounts.add(new Account("Maya"));
		
		return accounts;
	}
	
	public List<Account> findAllDelay() {
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		List<Account> accounts = new ArrayList<>();

		accounts.add(new Account("Yann"));
		accounts.add(new Account("nahema"));
		accounts.add(new Account("Maya"));
		
		return accounts;
	}

	public String getName() {
		logger.info("AccountDAO.getName is called");
		return name;
	}

	public void setName(String name) {
		logger.info("AccountDAO.setName is called");
		this.name = name;
	}
}
