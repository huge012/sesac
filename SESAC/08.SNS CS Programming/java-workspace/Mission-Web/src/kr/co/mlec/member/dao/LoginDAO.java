package kr.co.mlec.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import kr.co.mlec.member.vo.LoginVO;
import kr.co.mlec.util.ConnectionFactory;

public class LoginDAO {
	
	/**
	 * 로그인 서비스
	 * @param	loginVO (사용자가 입력한 id, password 저장)
	 * @return	loginVO (id, password로 조회된 회원 정보 포함)
	 * 			조회된 정보가 없다면 null 반환
	 */
	public LoginVO login(LoginVO loginVO) {
		
		StringBuilder sql = new StringBuilder();
		sql.append("select id, password, type ");
		sql.append(" from tbl_member ");
		sql.append(" where id = ? and password = ? ");
		
		try(
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		) {
			pstmt.setString(1, loginVO.getId());
			pstmt.setString(2, loginVO.getPassword());
			
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				loginVO.setType(rs.getString("type"));
			}
			else {
				loginVO = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return loginVO;
	}
	
}
