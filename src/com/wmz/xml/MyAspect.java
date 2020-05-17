package com.wmz.xml;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class MyAspect {
	
	//前置通知
	public void before(JoinPoint jp) { //jp切入点表达式
		System.out.println("前置通知方法 jp = " + jp);
	}
	
	//后置通知,可以获取目标方法返回值
	public void afterReturning(JoinPoint jp, Object result) {
		System.out.println("后置通知方法 jp = " + jp);
	}
	
	//环绕通知
	public Object around(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("环绕通知方法 ，目标方法执行之前");	
		Object result = pjp.proceed();
		System.out.println("环绕通知方法 ，目标方法执行之后");
		return ((String)result).toUpperCase();
	}
	
	//异常通知
	public void afterThrowing(Exception ex) {
		System.out.println("异常通知方法 " + 3/0);
		System.out.println("ex = " + ex.getMessage());
	}
	
	//最终通知

	public void after() {
		System.out.println("最终通知方法 ");
	}
	
	//定义切入点
	public void doFourthPointcut() {}
	
}