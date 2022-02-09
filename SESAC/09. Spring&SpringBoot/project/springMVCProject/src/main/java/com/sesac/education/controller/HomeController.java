package com.sesac.education.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller //Component의 일종
public class HomeController {
	//상속받는 클래스 없음
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 * @throws ClassNotFoundException 
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) throws ClassNotFoundException {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		/* 연산오류
		int a=10/0;
		System.out.println(a);
		*/
		
		/* 기타에러
		 * Class.forName("kr.co.sesac.model.BookVO.class");
		 */
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		model.addAttribute("myname", "serin" );
		
		
		return "home";
	}
	
}
