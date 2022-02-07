package com.sac.di5;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class AppConfig {
	
	@Bean
	public Car carBean() {
		return new Car("A모델", 1000);
	}
}
