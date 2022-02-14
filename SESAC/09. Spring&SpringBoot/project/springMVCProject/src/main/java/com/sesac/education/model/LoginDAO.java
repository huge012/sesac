package com.sesac.education.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository // @Component + DB
public class LoginDAO {
	
	@Autowired // type이 같으면 injection(넣어줌)
	DataSource dataSource;
	
	/**
	 * 로그인 서비스
	 * @param loginVO (사용자가 입력한 id, password 저장)
	 * @return userVO (id,password로 조회된 회원정보)
	 * 		   조회된 정보가 없다면 null 반환
	 */
	
	public LoginVO login(LoginVO loginVO) {
		// 1.7 try : AutoCloseable 인터페이스를 상속받은 클래스 객체만 사용 가능
		// () 안에 넣은 변수들은 자동으로 close 호출됨
		// query는 try문 밖에 있어야함
		
		LoginVO userVO = null; 
		
		StringBuilder sql = new StringBuilder();
		sql.append("select id, password, type ");
		sql.append(" from tbl_member ");
		sql.append(" where id = ? and password = ? ");
		try(
			//Connection conn = new ConnectionFactory().getConnection();
			Connection conn = dataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		){
			pstmt.setString(1, loginVO.getId());
			pstmt.setString(2, loginVO.getPassword());
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				userVO = new LoginVO();
				userVO.setId(rs.getString("id"));
				userVO.setPassword(rs.getString("password"));
				userVO.setType(rs.getString("type"));
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return userVO;
	}
}
