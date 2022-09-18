package com.luv2code.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.config.DemoAOPConfig;
import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;

public class MainDemoAopApp {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoAOPConfig.class);

		AccountDAO accountDao = context.getBean("accountDAO", AccountDAO.class);		
		accountDao.addAccount();
		accountDao.setName("YOYOO");
		accountDao.getName();
		
		MembershipDAO membershipDao = context.getBean("membershipDAO", MembershipDAO.class);
		membershipDao.addAccount();
		
		context.close();
	}
}
