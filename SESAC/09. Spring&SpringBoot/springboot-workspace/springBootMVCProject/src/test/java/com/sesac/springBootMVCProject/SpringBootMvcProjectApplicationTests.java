package com.sesac.springBootMVCProject;

import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.sesac.springBootMVCProject.vo.CarVO;

@SpringBootTest
class SpringBootMvcProjectApplicationTests {

	//@Test
	void contextLoads() {
	}

	//@Test
	public void test1() {
		// lombok 연습하기
		
		/*
		// 생성자 테스트
		CarVO car1 = new CarVO();
		CarVO car2 = new CarVO("ABC", 1000);
		System.out.println("No arg constructor test : "+ car1);
		System.out.println("All arg constructor test : "+ car2);
		
		// setter 테스트
		car1.setModel("모델1");
		car2.setPrice(3000);
		System.out.println("setter test : "+car1);
		*/
		
		CarVO car3 = CarVO.builder()
				.model("car3모델")
				.price(2000)
				.build();
		System.out.println("builder test : "+car3);
	}
	
	//@Test
	void test2() {
		// @Builder 테스트 + IntStream
		// 1부터 10까지(10 포함) 반복, i에 숫자 들어감,
		IntStream.rangeClosed(1, 10).forEach(i->{
			System.out.println(i + "-------------------------");
			CarVO car = CarVO.builder()
					.model("자동차"+i)
					.build();
			System.out.println(car.getModel());
		});
	}
	
	@Test
	void test3() {
		/*
		// @RequiredArgsConstructor 테스트
		IntStream.rangeClosed(1, 10).forEach(i->{
			System.out.println(i + "-------------------------");
			CarVO car = new CarVO("aaa" + i);
			System.out.println(car.getModel());
		});
		*/
		
		// @Data 테스트
		CarVO car2 = new CarVO("car2모델", 2000);
		IntStream.rangeClosed(1, 10).forEach(i->{
			System.out.println(i + "-------------------------");
			CarVO car = CarVO.builder().model("car"+i+"모델").price(2000).build();
			System.out.println(car);
			System.out.println(car2.equals(car));
		});
	}
}
