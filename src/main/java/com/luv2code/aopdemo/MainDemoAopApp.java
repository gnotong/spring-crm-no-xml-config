package com.luv2code.aopdemo;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.config.DemoAOPConfig;
import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;
import com.luv2code.aopdemo.entity.Account;

public class MainDemoAopApp {
	
	private static Logger logger = Logger.getLogger(MainDemoAopApp.class.getName());

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoAOPConfig.class);

		AccountDAO accountDao = context.getBean("accountDAO", AccountDAO.class);
		accountDao.addAccount(new Account("Fortuneo"), true);
		accountDao.setName("YOYOO");
		accountDao.getName();

		List<Account> accounts, delayedAccounts;
		try {
			accounts = accountDao.findAll();
			delayedAccounts = accountDao.findAllDelay();
			logger.info("===>>>> accountDao.findAll in MainDemoAopApp");
			logger.info(accounts.toString());
			logger.info("===>>>> accountDao.findAllDelay in MainDemoAopApp");
			logger.info(delayedAccounts.toString());
		} catch (Exception e) {
			logger.info(e.toString());
		}

		MembershipDAO membershipDao = context.getBean("membershipDAO", MembershipDAO.class);
		membershipDao.addAccount();

		context.close();
	}
}
