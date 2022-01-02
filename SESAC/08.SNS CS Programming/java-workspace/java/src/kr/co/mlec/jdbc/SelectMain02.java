package kr.co.mlec.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import kr.co.mlec.util.ConnectionFactory;
import kr.co.mlec.util.JDBCClose;

/*
 * 과제
 * 
 * 급여(salary)가 주어진 금액 이상인 직원들에 대해, 직무(job_title)별 평균 급여를 출력하는 프로그램
 * 이때, 평균 급여가 큰 순서로 출력(PrnEmpSalary.java)
 * 
 */

public class SelectMain02 {

	public static void main(String[] args) {
	
		PreparedStatement pstmt = null;
		Connection conn = null;

		try {
			
			conn = new ConnectionFactory().getConnection();
			
			Scanner sc = new Scanner(System.in);
			System.out.print("급여를 입력하세요 : ");
			int sal = sc.nextInt();
			
			String sql = "select job_title, avg(salary)"
					+ "from ( "
					+ "		  select e.emplotee_id, e.first_name, e.salary, j.job_title "
					+ "		  from emplotees e, jobs j "
					+ "		  where salsry >= ? and e.job_id = j.job_id) "
					+ " 	  group by job_title "
					+ " 	  order by 2 desc ";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,  sal);
			
			ResultSet rs = pstmt.executeQuery();
			int cnt = 0;
			
			System.out.println();
			System.out.println("--------------[직무]별 평균 급여----------------");
			while (rs.next()) {
				String job = rs.getString("job_title");
				int salary = rs.getInt(2);
				System.out.printf("[%s] %d\n", job, salary);
				cnt++;
			}
			System.out.println();
			// rownum으로 행번호 입력할 수 있지만 서브쿼리 늘어나는것보단 cnt가 간단
			System.out.println("\t총["+cnt+"]명이 검색되었습니다.");
			
		} catch (Exception e)
		{
			e.printStackTrace();
		} finally {
			JDBCClose.close(pstmt, conn);
		}
		
	}

}
