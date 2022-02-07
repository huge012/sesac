package com.sac.zz.aop2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyApp {

	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("aop2.xml");
		Calculator cal = ctx.getBean("calculator", Calculator.class);
		
		System.out.println("==========================================");
		cal.add();
		System.out.println("==========================================");
		cal.add(100);
		System.out.println("==========================================");
		cal.add(100, 200);
		System.out.println("==========================================");
		cal.sub(1,  2);
		System.out.println("==========================================");
		cal.mul(10, 20);
		System.out.println("==========================================");
		cal.div(100, 10);
		System.out.println("==========================================");
	}

}
