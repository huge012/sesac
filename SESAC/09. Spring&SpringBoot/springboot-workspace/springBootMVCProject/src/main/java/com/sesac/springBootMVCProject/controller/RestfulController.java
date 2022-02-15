package com.sesac.springBootMVCProject.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sesac.springBootMVCProject.repository.BoardRepository;
import com.sesac.springBootMVCProject.vo.BoardVO;
import com.sesac.springBootMVCProject.vo.CarVO;

@RestController // @Controller + @ResponseBody
public class RestfulController {
	
	@Autowired
	BoardRepository bRepo; // repository 연결
	
	@RequestMapping("/hello3.do")
	public String test3() {
		// @ResponseBody라고 안적어줘도 문자열로 반환됨
		return "@RestController에서 return되는 문자";
	}
	
	@RequestMapping("/hello4.do")
	public CarVO test4() {
		// JSON 값 넘겨주기
		CarVO car = CarVO.builder().model("그랜져abc").price(5000).build();
		return car;
	}

	@RequestMapping("/hello5.do")
	public List<CarVO> test5() {
		// JSON 값 넘겨주기
		List<CarVO> list = new ArrayList<>();
		CarVO car1 = CarVO.builder().model("그랜져aa").price(5000).build();
		CarVO car2 = CarVO.builder().model("그랜져bb").price(2000).build();
		CarVO car3 = CarVO.builder().model("그랜져cc").price(3000).build();
		list.add(car1);
		list.add(car2);
		list.add(car3);
		list.add(new CarVO("bbb", 1000));
		return list;
	}
	
	@RequestMapping("/board/list.do")
	public Iterable<BoardVO> selectAll(){
		return bRepo.findAll();
	}
	
	@RequestMapping("/board/list2.do")
	public Iterable<BoardVO> selectByWriter(String writer){
		return bRepo.findByWriter(writer);
	}
	
	@RequestMapping("/board/listByDate.do")
	public Iterable<BoardVO> findByRegDateBefore(String date){
		//Timestamp date = Timestamp.valueOf("2021-02-16 00:00:00");
		date = date+" 00:00:00";
		Timestamp day = Timestamp.valueOf(date);
		return bRepo.findByRegDateBefore(day);
	}
	
	
}
