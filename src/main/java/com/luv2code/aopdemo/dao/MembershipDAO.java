package com.luv2code.aopdemo.dao;

import java.util.logging.Logger;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {
	private Logger logger = Logger.getLogger(getClass().getName());
	public void addAccount() {
		logger.info(getClass() + " ADDING MEMBERSHIP");
	}
}
