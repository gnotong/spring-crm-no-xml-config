package com.luv2code.aopdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;

@Configuration
@ComponentScan("com.luv2code.aopdemo")
@EnableAspectJAutoProxy
public class DemoAOPConfig {
	@Bean
	public AccountDAO getAccountDao() {
		return new AccountDAO();
	}
	
	@Bean
	public MembershipDAO getMembershipDao() {
		return new MembershipDAO();
	}
}









