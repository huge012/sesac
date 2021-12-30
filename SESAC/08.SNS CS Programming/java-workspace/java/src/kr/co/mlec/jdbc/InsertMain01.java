package kr.co.mlec.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/*
 * 1. JDBC 드라이버 로딩
 * 2. SQL 데이터베이스와 연결
 * 3. SQL 실행할 객체 얻어와서 쿼리 작성하기
 * 4. 쿼리 실행 및 결과 얻어오기
 * 5. DB 접속 종료
 * 
 */
public class InsertMain01 {

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		
		// 1. JDBC 드라이버 로딩
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); // checked Exception - 컴파일시점의 예외처리, 예외처리 필수로 해줘야 함
			
			// 2. DB 접속 및 connection 객체 얻어옴
			String url = "jdbc:oracle:thin:@localhost:1521:xe"; // url 구성 = jdbc:oracle:thin:@IP주소:포트:SID
			conn = DriverManager.getConnection(url, "hr", "hr");
			System.out.println(conn);
			
			// 3. SQL 실행할 객체(statement) 얻어오기 (new로 생성하는게 아니라 받아오는 것) + 쿼리 작성하기
			
			stmt = conn.createStatement();
			
			String sql = "insert into t_test(id, name) values('park', '박길동')"; // 쿼리 입력, jdbc로 쿼리 만들 땐 마지막에 세미콜론(;) 생략
			
			// 4. 쿼리 실행 및 결과 얻어오기
			
			int cnt = stmt.executeUpdate(sql); // DB를 업데이트하는 것이기 때문에(행 삽입) executeUpdate, int형(insert한 행의 개수) 반환
			System.out.println("총 "+cnt+"개 행이 삽입되었습니다.");
			
		} catch (Exception e) {
			e.printStackTrace(); // 에러 따라가면서 알려줌
		} finally {
			// 5. DB 접속 종료
			// statement 종료
			try {
				stmt.close(); // stmt의 경우 try 지역변수로 선언하면 안됨
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			// connection 종료
			try {
				conn.close(); // conn의 경우 try 지역변수로 선언하면 안됨
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
		}
		
		
	}

}
