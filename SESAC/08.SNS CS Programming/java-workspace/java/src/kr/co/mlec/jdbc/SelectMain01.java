package kr.co.mlec.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import kr.co.mlec.util.ConnectionFactory;
import kr.co.mlec.util.JDBCClose;

public class SelectMain01 {

	public static void main(String[] args) {
		
		Connection conn = null;
		PreparedStatement pstmt = null; // 주로 preparedStatement를 사용함
		
		try {
			conn = new ConnectionFactory().getConnection(); // DB 드라이버 연결, Connection
			
			String sql = "select * from t_test order by name desc";
			
			pstmt = conn.prepareStatement(sql);
			
			// select의 경우 데이터베이스 변동없이 데이터 가져오는 것이므로 executeQuery()
			ResultSet rs = pstmt.executeQuery(); 
			
			/* 가져온 데이터 보기
			rs.next(); // row 이동, 첫 줄은 항상 빈 줄이므로 한 줄 넘겨줘야 함
			rs.getString("id"); // String형 "id" 컬럼 뽑아냄
			rs.getString("name"); // String형 "name" 컬럼 뽑아냄
			rs.getString(1); // String형 첫번째 컬럼 뽑아냄
			rs.getString(2);
			*/
			
			while (rs.next()) // 데이터의 끝 = false
			{
				String id = rs.getString("id");
				String name = rs.getString("name");
				System.out.println("id : "+id+", name : "+name);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(pstmt, conn);
		}
	}

}
