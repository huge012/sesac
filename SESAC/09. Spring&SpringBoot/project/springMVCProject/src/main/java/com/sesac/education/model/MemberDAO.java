package com.sesac.education.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sesac.education.util.JDBCClose;

@Repository
public class MemberDAO {
	
	@Autowired
	DataSource ds;
	
	/**
	 * 회원 전체 조회
	 * @return
	 */
	public List<LoginVO> selectAll(){
		Connection conn = null;
		PreparedStatement pstmt = null;
		List<LoginVO> list = new ArrayList<>();
		
		try {
			conn = ds.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select id, name, password, email_id, email_domain, tel1, tel2, tel3, post, ");
			sql.append(" basic_addr, detail_addr, type, to_char(reg_date, 'yyyy-mm-dd') as reg_date from tbl_member");
			pstmt = conn.prepareStatement(sql.toString());
			ResultSet rs = pstmt.executeQuery();
		
			while(rs.next()){
				String id = rs.getString("id");
				String name = rs.getString("name");
				String pw = rs.getString("password");
				String eId = rs.getString("email_id");
				String eDomain = rs.getString("email_domain");
				String tel1 = rs.getString("tel1");
				String tel2 = rs.getString("tel2");
				String tel3 = rs.getString("tel3");
				String post = rs.getString("post");
				String bAddr = rs.getString("basic_addr");
				String dAddr = rs.getString("detail_addr");
				String type = rs.getString("type");
				String regDate = rs.getString("reg_date");

				LoginVO member = new LoginVO(id, name, pw, eId, eDomain, tel1, tel2, tel3, post, bAddr, dAddr, type, regDate);
				list.add(member);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCClose.close(pstmt, conn);
		}
		return list;
	}
	
	/**
	 * 회원가입
	 * @param member
	 */
	public void singUp(LoginVO member) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		try {
			conn = ds.getConnection();
			StringBuilder sql2 = new StringBuilder();
			sql2.append("select * from tbl_member");
			pstmt2 = conn.prepareStatement(sql2.toString());
			pstmt2.executeQuery();
			
			
			StringBuilder sql = new StringBuilder();
			sql.append("insert into tbl_member(id, name, password, email_id, email_domain, tel1, tel2, tel3, ");
			sql.append(" post, basic_addr, detail_addr) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getName());
			pstmt.setString(3, member.getPw());
			pstmt.setString(4, member.geteId());
			pstmt.setString(5, member.geteDomain());
			pstmt.setString(6, member.getTel1());
			pstmt.setString(7, member.getTel2());
			pstmt.setString(8, member.getTel3());
			pstmt.setString(9, member.getPost());
			pstmt.setString(10, member.getbAddr());
			pstmt.setString(11, member.getdAddr());
			
			pstmt.executeUpdate();
		}catch (SQLIntegrityConstraintViolationException s) {
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			JDBCClose.close(pstmt, conn);
		}
	}
}
