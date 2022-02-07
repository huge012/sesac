package com.sac.di4;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

// VO (Value Object)
// DTO (Data Transfer Object)
// Bean (Object)

// <bean id="car" class="com.sac.di4.Car"></bean>
// @Component
@Component("cc") // 객체 이름 cc
public class Car {
	
	@Value("ABC")
	private String model;
	private int price;
	
	public Car() {
		System.out.println("default 생성자");
	}
	
	public Car(String model, int price) {
		System.out.println("Car arg2 생성자");
		this.model = model;
		this.price = price;
	}

	// getter setter
	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Car [model=" + model + ", price=" + price + "]";
	}
	
}
