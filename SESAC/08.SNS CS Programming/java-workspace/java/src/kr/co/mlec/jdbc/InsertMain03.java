package kr.co.mlec.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;
/*
 * preparedStatement 
 *  - Statement 객체를 상속받음
 *  - 미리 쿼리를 준비해둔 뒤, 변수가 들어가야 할 자리를 채울 수 있음
 *  - 변수 없이 쓰는 쿼리도 preparedStatement로 사용할 순 있음
 *  - 
 */
public class InsertMain03 {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			// 1. JDBC 드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// 2. DB 접속 및 connection 객체 얻어옴
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "hr";
			String pass = "hr";
			conn = DriverManager.getConnection(url, user, pass);
			
			Scanner sc = new Scanner(System.in);
			System.out.print("아이디 입력 : ");
			String id = sc.nextLine();
			System.out.print("이름 입력 : ");
			String name = sc.nextLine();
			
			// 3. 쿼리 작성 및 실행객체 얻기
			String sql = "insert into t_test(id, name) ";
			sql += " values(?, ?) ";  // ? 자리에 변수 들어올 것,
			
			pstmt = conn.prepareStatement(sql);  // 미리 준비한 쿼리를 넣어주어 객체 생성
			pstmt.setString(1, id);  // setString은 자동으로 변수 앞뒤에 ' 넣어줌
			pstmt.setString(2, name);
			
			int cnt = pstmt.executeUpdate();  // 이미 앞서 sql을 넣어줬기때문에 매개변수 x
			System.out.println("총 "+cnt+"개 행이 삽입되었습니다.");
			
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
