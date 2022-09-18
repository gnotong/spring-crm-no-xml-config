package com.luv2code.aopdemo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(-1)
public class DemoLogToCloudAspect {
	
	private Logger logger = Logger.getLogger(getClass().getName());
	
	@Before("com.luv2code.aopdemo.aspect.DemoAopExpressions.forDaoPackageNoGetterSetter()")
	public void logToCloud() {
		logger.info("=====>>>> Loging to cloud");
	}
}
