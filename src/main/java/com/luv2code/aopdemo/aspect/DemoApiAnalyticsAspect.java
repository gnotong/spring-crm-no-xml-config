package com.luv2code.aopdemo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(4)
public class DemoApiAnalyticsAspect {
	
	private Logger logger = Logger.getLogger(getClass().getName());
	
	@Before("com.luv2code.aopdemo.aspect.DemoAopExpressions.forDaoPackageNoGetterSetter()")
	public void performApiAnalytics() {
		logger.info("=====>>>> Making some api analytics");
	}
}
