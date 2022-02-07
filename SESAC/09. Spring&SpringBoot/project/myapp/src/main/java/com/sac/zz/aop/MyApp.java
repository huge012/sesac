package com.sac.zz.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.co.mlec.library.dao.LoginService;
import kr.co.mlec.library.vo.LoginVO;

public class MyApp {

	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("aop.xml");
		Calculator cal = ctx.getBean("proxyCal", Calculator.class);
		
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
