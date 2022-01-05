package kr.co.mlec.library.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import kr.co.mlec.library.util.ConnectionFactory;
import kr.co.mlec.library.util.JDBCClose;
import kr.co.mlec.library.vo.MemberVO;

public class UpdateUserInfoDAO {
	
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
	
}


