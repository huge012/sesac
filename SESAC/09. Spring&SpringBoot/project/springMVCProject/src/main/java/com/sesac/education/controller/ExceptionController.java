package com.sesac.education.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

/*
 * 404 에러 처리 (전역)
 */

@ControllerAdvice
public class ExceptionController {
	@ExceptionHandler(NoHandlerFoundException.class)
	public String handler404(HttpServletRequest request, Model model) {
		model.addAttribute("msg", "존재하지 않는 페이지");
		model.addAttribute("url", request.getRequestURL());
		return "error/errorPage404";
	}
}
