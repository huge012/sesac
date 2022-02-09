package com.sesac.education.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
	
	@Autowired
	private LoginDAO dao;
	
	public LoginVO login(LoginVO loginVO) {
		
		return dao.login(loginVO);
	}
}
