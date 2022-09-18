package com.luv2code.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.entity.Account;


@Aspect
@Component
@Order(1)
public class DemoLoggingAspect {
	@Before("com.luv2code.aopdemo.aspect.DemoAopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccount(JoinPoint joinPoint) {
		System.out.println("=====>>>> @Before advice add Account");
		
		MethodSignature methodSig = (MethodSignature)joinPoint.getSignature();
		
		System.out.println(methodSig);
		
		Object[] args = joinPoint.getArgs();
		
		for(Object arg: args) {
			if(arg instanceof Account) {
				System.out.println("=> " + ((Account) arg).getName());
				continue;
			}
			System.out.println(arg);
		}
	}
	
	@AfterReturning(
		pointcut="execution(* com.luv2code.aopdemo.dao.AccountDAO.findAll(..))",
		returning="result"
	)
	public void afterReturningFindAllAccountAdvice(JoinPoint jp, List<Account> result) {
		System.out.println("In the aspect");
		System.out.println(result);
	}
}
