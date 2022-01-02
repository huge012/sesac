package kr.co.mlec.login.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import kr.co.mlec.util.ConnectionFactory;
import kr.co.mlec.util.JDBCClose;
import kr.co.mlec.login.vo.LoginVO;

/*
 * 1. JDBC 드라이버 로딩
 * 2. DB 접속하여 연결객체를 얻어오기
 * 3. SQL 쿼리 생성
 * 4. 쿼리 실행 및 결과 얻어오기
 * 5. DB 접속 종료
 * 
 */

public class LoginDAO {
	
	// 회원가입
	public int signUp(LoginVO user)
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		int result = 0;
		
		try {
			conn = new ConnectionFactory().getConnection();
			
			
			StringBuilder sql = new StringBuilder();
			sql.append(" insert into t_user(id, pass) ");
			sql.append(" values(?, ?) ");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, user.getId());
			pstmt.setString(2, user.getPass());
			
			result = pstmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(pstmt, conn);
		}
		
		return result;
	}
	
	// 로그인
	public boolean signIn(LoginVO user)
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean result = false;
		
		try {
			
			conn = new ConnectionFactory().getConnection();
			
			StringBuilder sql = new StringBuilder();
			sql.append(" select id, pass ");
			sql.append(" from t_user ");
			sql.append(" where id = ? and pass = ? ");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, user.getId());
			pstmt.setString(2, user.getPass());
			
			ResultSet rs = pstmt.executeQuery();
			result = rs.next();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(pstmt, conn);
		}
		
		return result;
	}
}
