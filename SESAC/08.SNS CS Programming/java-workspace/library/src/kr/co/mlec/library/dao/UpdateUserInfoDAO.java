package kr.co.mlec.library.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import kr.co.mlec.library.util.ConnectionFactory;
import kr.co.mlec.library.util.JDBCClose;
import kr.co.mlec.library.vo.MemberVO;

public class UpdateUserInfoDAO {
	
	// 회원/관리자가 개인정보 수정 - 비번/핸드폰번호만 수정
	public int updateInfo(MemberVO user) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		int rs = 0;
		
		try {
			conn = new ConnectionFactory().getConnection();
			
			StringBuilder sql = new StringBuilder();
			sql.append(" update t_user ");
			sql.append(" set password = ?, phone = ? ");
			sql.append(" where id = ? ");
			
			pstmt = conn.prepareStatement(sql.toString());
			
			pstmt.setString(1, user.getPw());
			pstmt.setInt(2, user.getPhone());
			pstmt.setString(3, user.getId());
			
			rs = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(pstmt, conn);
		}
		
		return rs;
	}
	
	// 관리자가 회원 정보 삭제
	public int deleteMemberInfo(MemberVO user) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		int rs = 0;
		
		try {
			conn = new ConnectionFactory().getConnection();
			
			StringBuilder sql = new StringBuilder();
			sql.append(" delete t_user ");
			sql.append(" where id = ? and password = ?");
			
			pstmt = conn.prepareStatement(sql.toString());
			
			pstmt.setString(1, user.getId());
			pstmt.setString(2,
					user.getPw());
			
			rs = pstmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(pstmt, conn);
		}
		
		return rs;

	}
	
	// 회원을 관리자로 등록
	public int setupManager(MemberVO user) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		int rs = 0;
		try {
			conn = new ConnectionFactory().getConnection();
			
			StringBuilder sql = new StringBuilder();
			sql.append("update t_user " );
			sql.append(" set is_manager = 1 " );
			sql.append(" where id = ?" );
			
			pstmt = conn.prepareStatement(sql.toString());
			
			pstmt.setString(1, user.getId()); //관리자가 입력해주는 회원id잖아..
			
			rs = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(pstmt, conn);
		}
		
		return rs;
		
	}
	
}


