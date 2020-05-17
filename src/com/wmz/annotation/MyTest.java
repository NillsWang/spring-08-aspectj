package com.wmz.annotation;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class MyTest {
	
	@Test
	public void test01() {
		//从类路径中找xml文件，这里的配置文件存放在src下
		//加载spring配置文件，创建spring容器对象
		String resource = "/com/wmz/annotation/applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(resource);
		ISomeService service = (ISomeService) ac.getBean("someService");
		service.doFirst();
		System.out.println("-------------------");
		String result = service.doSecond();
		System.out.println(result);
		System.out.println("-------------------");
		String result1 = service.doThird();
		System.out.println(result1);
		System.out.println("-------------------");
		service.doFourth();
			
	}
	
}
