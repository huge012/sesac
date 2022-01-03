package kr.co.mlec.library.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import kr.co.mlec.library.util.ConnectionFactory;
import kr.co.mlec.library.util.JDBCClose;
import kr.co.mlec.library.vo.MemberVO;



public class LoginDAO {
	// 회원가입
	public int signUp(MemberVO user)
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		int result = 0;
		
		try {
			conn = new ConnectionFactory().getConnection();
			
			
			StringBuilder sql = new StringBuilder();
			sql.append(" insert into t_user(id, password, name, phone, is_manager ) ");
			sql.append(" values(?, ?, ?, ?, ?) ");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, user.getId());
			pstmt.setString(2, user.getPw());
			pstmt.setString(3,  user.getName());
			pstmt.setInt(4, user.getPhone());
			pstmt.setInt(5, user.getIsAdmin());
			
			result = pstmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(pstmt, conn);
		}
		
		return result;
	}
	
	// 로그인
	public boolean signIn(MemberVO user)
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean result = false;
		
		try {
			
			conn = new ConnectionFactory().getConnection();
			
			StringBuilder sql = new StringBuilder();
			sql.append(" select id, password, is_manager ");
			sql.append(" from t_user ");
			sql.append(" where id = ? and password = ? and is_manager = ? ");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, user.getId());
			pstmt.setString(2, user.getPw());
			pstmt.setInt(3, user.getIsAdmin());
			
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
