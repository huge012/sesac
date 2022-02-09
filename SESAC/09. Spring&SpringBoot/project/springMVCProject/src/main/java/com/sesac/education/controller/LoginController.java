package com.sesac.education.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sesac.education.model.LoginService;
import com.sesac.education.model.LoginVO;

@Controller
public class LoginController {

	@Autowired
	LoginService lService;
	
	@RequestMapping(value="/login/login.do", method = RequestMethod.GET)
	public String loginFormView() {
		return "login/loginForm";
	}
	
	@RequestMapping(value="/login/login.do", method = RequestMethod.POST)
	public String loginProcess(LoginVO loginVO, RedirectAttributes attr) {
		LoginVO user = lService.login(loginVO);
		if (user != null)
		{
			attr.addFlashAttribute("msg", "로그인 성공");
			attr.addFlashAttribute("user", user);
		}
		else
		{
			attr.addFlashAttribute("msg", "로그인 실패");
		}
		return "redirect:/board/list.do";
	}
}
