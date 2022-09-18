package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class DemoAopExpressions {
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(..))")
	public void forDaoPackage() {}
	
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.get*(..))")
	public void forGetter() {}
	
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.set*(..))")
	public void forSetter() {}
	
	@Pointcut("forDaoPackage() && !(forGetter() || forSetter())")
	public void forDaoPackageNoGetterSetter() {}
}
