package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DemoLoggingAspect {
	
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(..))")
	private void forDaoPackage() {}
	
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.get*(..))")
	private void forGetter() {}
	
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.set*(..))")
	private void forSetter() {}
	
	@Pointcut("forDaoPackage() && !(forGetter() || forSetter())")
	private void forDaoPackageNotGetterAndSetter() {}

	@Before("forDaoPackageNotGetterAndSetter()")
	public void beforeAddAccountAdvice() {
		System.out.println("=====>>>> Executing @Before advice on method");
	}

	@Before("forDaoPackageNotGetterAndSetter()")
	public void performApiAnalytics() {
		System.out.println("=====>>>> Making some api analytics");
	}
}
