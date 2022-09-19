package com.luv2code.springdemo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class CRMLoggingAspect {
	private Logger logger = Logger.getLogger(getClass().getName());

	@Pointcut("execution(* com.luv2code.springdemo.controller.*.*(..))")
	private void forControllerPackage() {};
	
	@Pointcut("execution(* com.luv2code.springdemo.service.*.*(..))")
	private void forServicePackage() {};
	
	@Pointcut("execution(* com.luv2code.springdemo.dao.*.*(..))")
	private void forDaoPackage() {};
	
	@Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
	private void forAppFlow() {};
	
	
	@Before("forAppFlow()")
	public void before(JoinPoint joinPoint) {
	
		String method = joinPoint.getSignature().toShortString();

		logger.info("@Before ==>> " + method);
		
		// we can also get methods arguments using the JoinPoint
	}	
	
	@AfterReturning(pointcut = "forAppFlow()", returning = "result")
	public void after(JoinPoint joinPoint, Object result) {
	
		String method = joinPoint.getSignature().toShortString();

		logger.info("@AfterReturning ==>> " + method);
		
		// we display the returned data
		logger.info(result.toString());
	}
	
}
