package com.sesac.education.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sesac.education.util.JDBCClose;

@Repository
public class MemberDAO_mybatis {
	
	@Autowired
	SqlSession session;
	
	final String namespace = "com.sesac.member.";
	
	/**
	 * 회원 전체 조회
	 * @return
	 */
	public List<LoginVO> selectAll(){
		List<LoginVO> ulist = session.selectList(namespace+"selectAll");
		return ulist;
	}
	
	/**
	 * 로그인
	 * @param id
	 * @return
	 */
	public LoginVO login(LoginVO member) {
		System.out.println("로그인 시도 : "+member.getId()+", "+member.getPassword());
		return session.selectOne(namespace+"login", member);
	}
	
	/**
	 * 특정 회원 조회
	 * @param id
	 * @return
	 */
	public LoginVO selectById(String id) {
		return session.selectOne(namespace+"selectById", id);
	}
	
	/**
	 * 회원가입
	 * @param member
	 */
	public int singUp(LoginVO member) {
		return session.insert(namespace+"insert", member);
	}
	
	/**
	 * 회원 정보 수정
	 * @param member
	 * @return
	 */
	public int update(LoginVO member) {
		return session.update(namespace+"update", member);
	}
	
	/**
	 * 회원 탈퇴
	 * @param id
	 * @return
	 */
	public int delete(String id) {
		return session.delete(namespace+"delete", id);
	}
}
