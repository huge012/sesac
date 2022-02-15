package com.sesac.education.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sesac.education.model.LoginService;
import com.sesac.education.model.LoginVO;

@Controller
public class LoginController {

	@Autowired
	LoginService lService;
	
	/* 로그인 폼 이동 */
	@RequestMapping(value="/login/login.do", method = RequestMethod.GET)
	public String loginFormView() {
		return "login/loginForm";
	}
	
	/* 실제 로그인 */
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
		return "redirect:/member/list.do";
	}
	
	/* 회원 목록 */
	@RequestMapping(value="/member/list.do")
	public String memberList(Model model) {
		model.addAttribute("list", lService.selectAll());
		return "member/list";
	}
	
	/* 내정보 */
	@RequestMapping(value="/member/detail.do", method = RequestMethod.GET)
	public String selectMember(String id, Model model) {
		model.addAttribute("user", lService.selectById(id));
		return "member/detail";
	}
	
	/* 수정창 이동 */
	@RequestMapping(value="/login/update.do", method = RequestMethod.GET)
	public String updateFormView() {
		return "member/update";
	}
	
	/* 실제 수정 */
	@RequestMapping(value="/login/update.do", method = RequestMethod.POST)
	public String updateMember(LoginVO user, RedirectAttributes attr) {
		int result = lService.update(user);
		attr.addFlashAttribute("msg", result > 0 ? "수정성공" : "수정실패");
		return "redirect:/member/list.do";
	}
}
