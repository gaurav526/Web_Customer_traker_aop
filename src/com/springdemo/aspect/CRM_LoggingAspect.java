package com.springdemo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRM_LoggingAspect {

	private Logger myLogger= Logger.getLogger(getClass().getName()); 
	
	@Pointcut("execution(* com.springdemo.controller.*.*(..))")
	public void forControllerPackage() {}
	
	@Pointcut("execution(* com.springdemo.dao.*.*(..))")
	public void forDaoPackage() {}
	
	@Pointcut("execution(* com.springdemo.services.*.*(..))")
	public void forServicesPackage() {}
	
	@Pointcut("forControllerPackage() || forDaoPackage() ||  forServicesPackage()")
	public void forAppFlow() {}
	
	@Before("forAppFlow()")
	public void before(JoinPoint theJoinPoint) {
		
		String theMethod = theJoinPoint.getSignature().toShortString();
		myLogger.info("@Before method signature "+theMethod);
		
		Object [] arge = theJoinPoint.getArgs();
		for (Object object : arge) {
			myLogger.info("@Before method args "+object);
		}
	}
	
	@AfterReturning(pointcut="forAppFlow()",returning="result")
	public void afterReturning(JoinPoint theJoinPoint, Object result) {
		
		String theMethod= theJoinPoint.getSignature().toShortString();
		myLogger.info("@AfterReturn method signature "+theMethod);
		
		myLogger.info("@AfterReturn result "+result);
	}
}
