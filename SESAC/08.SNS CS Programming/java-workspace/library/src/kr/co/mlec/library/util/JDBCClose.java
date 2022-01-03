package kr.co.mlec.library.util;

import java.sql.Connection;
import java.sql.Statement;

/*
 * JDBC 관련 close() 클래스
 * 
 */

public class JDBCClose {

	// 객체를 생성할 필요 없이 함수 호출만 가능하면 됨, static으로 설정
	static public void close(Statement stmt, Connection conn)
	{
		if (stmt != null)
		{
			try {
				stmt.close();
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
