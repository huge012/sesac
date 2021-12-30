package kr.co.mlec.jdbc;
/*
 * 쿼리에 값 입력
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class InsertMain02 {

	public static void main(String[] args) {

		Connection conn = null;
		Statement stmt = null;
		Scanner sc = new Scanner(System.in);
		
		try {
			// JDBC 드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// db 접속 및 connection 객체 얻어옴
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "hr", "hr");
			System.out.println("연결완료 : "+conn);
			
			// ID, 이름 받기
			String id, name;
			System.out.print("아이디를 입력해주세요 : ");
			id = sc.nextLine();
			System.out.print("이름을 입력해주세요 : ");
			name = sc.nextLine();
			
			
			String sql = "insert into t_test(id, name) values(\'";
			sql += id + "\',\'" + name + "\')";
			
			
			// 실행할 객체 얻어와서 쿼리 작성
			stmt = conn.createStatement();
			
			int cnt = stmt.executeUpdate(sql);
			System.out.println("총 "+cnt+"개 행이 삽입되었습니다.");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			// statement 종료
			try {
				stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			// connection 종료
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}
