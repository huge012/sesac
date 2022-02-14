package com.sesac.education.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
	
	/* JDBC 사용
	@Autowired
	private LoginDAO Ldao;
	@Autowired
	private MemberDAO mDao;
	*/
	
	/* Mybatis 사용 */
	@Autowired
	MemberDAO_mybatis dao;
	
	// 로그인
	public LoginVO login(LoginVO loginVO) {
		
		LoginVO member = dao.login(loginVO);
		System.out.println("로그인 회원 정보 : "+member);
		return member;
	}
	
	// 회원 조회
	public List<LoginVO> selectAll() {
		return dao.selectAll();
	}
	
	// 특정 회원 조회
	public LoginVO selectById(String id) {
		return dao.selectById(id);
	}
	
	// 회원가입
	public int singUp(LoginVO member) {
		return dao.singUp(member);
	}
	
	// 회원 정보 수정
	public int update(LoginVO member) {
		return dao.update(member);
	}
	
	// 회원 탈퇴
	public int delete(String id) {
		return dao.delete(id);
	}
}
