package kr.co.mlec.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.co.mlec.user.vo.UserVO;
import kr.co.mlec.util.ConnectionFactory;
import kr.co.mlec.util.JDBCClose;

public class UserDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	
	public UserDAO() {
		conn = null;
		pstmt = null;
	}
	
	public List<UserVO> selectAllUser(){
		List<UserVO> users = new ArrayList<>();
		
		try {
			conn = new ConnectionFactory().getConnection();
			pstmt = null;
			
			StringBuilder sql = new StringBuilder();
			sql.append(" select id, name, email_id, email_domain, tel1, tel2, tel3, basic_addr ");
			sql.append(" from tbl_member ");
			
			pstmt = conn.prepareStatement(sql.toString());
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next())
			{
				String id = rs.getString("id");
				String name = rs.getString("name");
				String emailId = rs.getString("email_id");
				String emailDomain = rs.getString("email_domain");
				String tel1 = rs.getString("tel1");
				String tel2 = rs.getString("tel2");
				String tel3 = rs.getString("tel3");
				String basicAddr = rs.getString("basic_addr");
				UserVO user = new UserVO(id, name, emailId, emailDomain, tel1, tel2, tel3, basicAddr);
				users.add(user);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(pstmt, conn);
		}
		
		return users;
	}

	public int insertUser(UserVO user) {
		int rs = 0;
		
		try {
			conn = new ConnectionFactory().getConnection();
			pstmt = null;
			
			StringBuilder sql = new StringBuilder();
			sql.append(" insert into tbl_member(name, id, password, email_id, email_domain, tel1, tel2, tel3, post, basic_addr, detail_addr) ");
			sql.append(" values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, user.getName());
			pstmt.setString(2, user.getId());
			pstmt.setString(3, user.getPassword());
			pstmt.setString(4, user.getEmailId());
			pstmt.setString(5, user.getemailDomain());
			pstmt.setString(6, user.getTel1());
			pstmt.setString(7, user.getTel2());
			pstmt.setString(8, user.getTel3());
			pstmt.setString(9, user.getPost());
			pstmt.setString(10, user.getBasicAddr());
			pstmt.setString(11, user.getDetailAddr());
			
			rs = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(pstmt, conn);
		}
		
		return rs;
	}
	
}
