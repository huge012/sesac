package com.sac.di2;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class TVUser {

	public static void main(String[] args) {

		System.out.println("==== Spring 이용한 TV ====");
		m1();
		System.out.println("==== applicationContext ====");
		m2();
	}

	private static void m1() {
		Resource resource = new ClassPathResource("di2.xml");
		BeanFactory factory = new XmlBeanFactory(resource);
		ITV tv1 = (ITV)factory.getBean("samsung1"); // object 타입으로 넘어옴
		ITV tv2 = factory.getBean("samsung2", ITV.class); 
		ITV tv3 = (LgTV)factory.getBean("lg"); 
		
//		tv1.powerOn();	
//		tv1.powerOff();
//		tv2.powerOn();
//		tv2.powerOff();
//		tv3.powerOn();
//		tv3.powerOff();
	}
	
	private static void m2() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("di2.xml");
//		ITV tv1 = (ITV)ctx.getBean("samsung1"); // object 타입으로 넘어옴
//		ITV tv2 = ctx.getBean("samsung2", ITV.class); 
//		ITV tv3 = (LgTV)ctx.getBean("lg"); 
		
//		tv1.powerOn();	
//		tv1.powerOff();
//		tv2.powerOn();
//		tv2.powerOff();
//		tv3.powerOn();
//		tv3.powerOff();
	}
}