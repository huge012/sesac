package kr.co.mlec.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

/*
 * 검색할 ID를 입력하세요 : hong
 * 수정할 이름을 입력하세요 : 홍개똥
 * 
 * 총 1개의 행이 수정되었습니다.
 * 
 */

public class UpdateMain01 {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "hr";
			String password = "hr";
			conn = DriverManager.getConnection(url, user, password);
			
			Scanner sc = new Scanner(System.in);
			System.out.print("검색할 ID를 입력하세요 : ");
			String id = sc.nextLine();
			System.out.print("수정할 이름을 입력하세요 : ");
			String name = sc.nextLine();
			
			String sql = " update t_test ";
			sql += " set name = ? ";
			sql += " where id = ? ";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, id);
			
			int cnt = pstmt.executeUpdate();
			System.out.println("총 "+cnt+"개의 행이 수정되었습니다.");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			if (pstmt != null)
			{
				try {
					pstmt.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			if (conn != null)
			{
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		}
	}

}
