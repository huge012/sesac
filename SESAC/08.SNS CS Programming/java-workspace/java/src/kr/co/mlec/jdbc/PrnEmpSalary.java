package kr.co.mlec.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import kr.co.mlec.util.ConnectionFactory;
import kr.co.mlec.util.JDBCClose;

public class PrnEmpSalary {

	public static void main(String[] args) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = new ConnectionFactory().getConnection();
			
			Scanner sc = new Scanner(System.in);
			System.out.print("급여 입력 : ");
			int sal = sc.nextInt();
			String sql = "select job_title, round(avg(salary)) as avg_sal from ( select department_name as job_title, salary from employees e, departments d where e.department_id = d.department_id and salary >= ?) group by job_title order by avg_sal desc ";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, sal);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next())
			{
				String dp_name = rs.getString(1);
				int avgSal = rs.getInt(2);
				System.out.println("["+dp_name+"]   "+avgSal);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(pstmt, conn);
		}

	}

}
