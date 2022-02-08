package com.sac.myapp2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        m4();
    }

	private static void m1() {
		BookVO book1 = new BookVO();
		BookVO book2 = new BookVO(1, "spring", "홍길동", "새싹", "2022-02-08");
		System.out.println(book1);
		System.out.println(book2);
	}

	private static void m2() {
		//ApplicationContext로 객체 불러오기
		ApplicationContext ctx = new ClassPathXmlApplicationContext("di1.xml");
		BookVO book1 = ctx.getBean("book1", BookVO.class);
		BookVO book2 = ctx.getBean("book2", BookVO.class);
		System.out.println(book1);
		System.out.println(book2);
	}

	private static void m3() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("di2.xml");
		BookVO2 book1 = ctx.getBean("bookVO2", BookVO2.class);
		System.out.println(book1);
	}

	private static void m4() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("aop.xml");
		CoffeeShop coffee = ctx.getBean("coffeeShop", CoffeeShop.class);
		System.out.println("--------------------------------------------");
		coffee.divaaaaa(0, 0);
		System.out.println("--------------------------------------------");
	}
	
}
