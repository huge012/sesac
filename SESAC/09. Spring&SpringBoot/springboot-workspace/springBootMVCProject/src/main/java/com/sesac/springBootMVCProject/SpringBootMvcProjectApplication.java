package com.sesac.springBootMVCProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@SpringBootApplication
//@Component @Repository @Service @Controller 스캔
@ComponentScan(basePackages = {"com", "kr"}) // com으로 시작되는 패키지와 kr로 시작되는 패키지 둘 다 인식해라
@EntityScan(basePackages = {"com", "kr"}) // Entity를 스캔해주는 어노테이션
public class SpringBootMvcProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMvcProjectApplication.class, args);
		
	}

}
