package com.wmz.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
//当前类为切面
public class MyAspect {
	
	//前置通知
	@Before(value = "execution(* *..ISomeService.doFirst(..))")
	public void before(JoinPoint jp) { //jp切入点表达式
		System.out.println("前置通知方法 jp = " + jp);
	}
	
	//后置通知,可以获取目标方法返回值
	@AfterReturning(value = "execution(* *..ISomeService.doSecond(..))", returning="result")
	public void afterReturning(JoinPoint jp, Object result) {
		System.out.println("后置通知方法 jp = " + jp);
	}
	
	//环绕通知
	@Around(value = "execution(* *..ISomeService.doThird(..))")
	public Object around(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("环绕通知方法 ，目标方法执行之前");	
		Object result = pjp.proceed();
		System.out.println("环绕通知方法 ，目标方法执行之后");
		return ((String)result).toUpperCase();
	}
	
	//异常通知
	@AfterThrowing(value = "doFourthPointcut()", throwing = "ex")
	public void afterThrowing(Exception ex) {
		System.out.println("异常通知方法 " + 3/0);
		System.out.println("ex = " + ex.getMessage());
	}
	
	//最终(返回)通知
	@After(value = "doFourthPointcut()")
	public void after() {
		System.out.println("最终通知方法 ");
	}
	
	//定义切入点
	@Pointcut(value = "execution(* *..ISomeService.doFourth(..))")
	public void doFourthPointcut() {}
	
}