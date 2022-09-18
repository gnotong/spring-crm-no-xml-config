package com.luv2code.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.config.DemoAOPConfig;
import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;
import com.luv2code.aopdemo.entity.Account;

public class MainDemoAopApp {

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
			System.out.println("===>>>> accountDao.findAll in MainDemoAopApp");
			System.out.println(accounts);
			System.out.println("===>>>> accountDao.findAllDelay in MainDemoAopApp");
			System.out.println(delayedAccounts);
		} catch (Exception e) {
			System.out.println(e);
		}

		MembershipDAO membershipDao = context.getBean("membershipDAO", MembershipDAO.class);
		membershipDao.addAccount();

		context.close();
	}
}
