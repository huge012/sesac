package kr.co.sesac.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SesacController {
	
	@RequestMapping("/hello2.do")
	@ResponseBody // forward가 아닌 문자열 자체를 반환
	public String hello2() {
		
		return "hello2";
	}
}
