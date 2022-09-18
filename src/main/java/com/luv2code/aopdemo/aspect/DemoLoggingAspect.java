package com.luv2code.aopdemo.aspect;

import java.util.List;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
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
	
	private Logger logger = Logger.getLogger(getClass().getName());
	
	@Before("com.luv2code.aopdemo.aspect.DemoAopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccount(JoinPoint joinPoint) {
		logger.info("=====>>>> @Before advice add Account");
		
		MethodSignature methodSig = (MethodSignature)joinPoint.getSignature();
		
		logger.info(methodSig.getName());
		
		Object[] args = joinPoint.getArgs();
		
		logger.info(args.toString());
	}
	
	@AfterReturning(
		pointcut="execution(* com.luv2code.aopdemo.dao.AccountDAO.findAll(..))",
		returning="result"
	)
	public void afterReturningFindAllAccountAdvice(JoinPoint jp, List<Account> result) {
		logger.info("===>>>> In the aspect");

		convertNameToUpperCase(result);
	}
	
	@AfterThrowing(
		pointcut="execution(* com.luv2code.aopdemo.dao.AccountDAO.findAll(..))",
		throwing="exception"
	)
	public void afterThrowingFindAllAccountAdvice(JoinPoint jp, Throwable exception) {
		logger.info("Exception = " + exception.getMessage());
	}
	
	@Around("execution(* com.luv2code.aopdemo.dao.*.findAllDelay(..))")
	public Object aroundFindAllAccountAdvice(ProceedingJoinPoint pjp) throws Throwable {
		
		long begin = System.currentTimeMillis();
		
		Object result = pjp.proceed(); // launches the method findAllDelay
		
		long end = System.currentTimeMillis();
		
		long duration = end - begin;
		
		logger.info("Duration = " + duration + " ms");
		
		return result;
	}

	private void convertNameToUpperCase(List<Account> accounts) {
		if(!accounts.isEmpty()) {
			for(Account a: accounts) {
				a.setName(a.getName().toUpperCase());
			}
		}
	}
}
