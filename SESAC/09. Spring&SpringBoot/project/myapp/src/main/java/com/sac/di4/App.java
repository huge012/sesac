package com.sac.di4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {

		m1();
	}
	
	private static void m1() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("di4.xml");
		Car car = ctx.getBean("cc", Car.class);
		System.out.println(car);
		
		People p = ctx.getBean("people", People.class);
		System.out.println(p);
	}
}
