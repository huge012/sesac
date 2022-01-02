package kr.co.mlec.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import kr.co.mlec.util.ConnectionFactory;
import kr.co.mlec.util.JDBCClose;

/*
 * <<과제>>
 * 급여(Salary)가 주어진 금액 이상인 직원들에 대해, 직무(Job_title)별 평균 급여를 출력하는 프로그램 작성. 
 * 이때 평균 급여가 큰 순서로 출력(PrnEmpSalary.java)
 */

public class SelectMain03 {

	public static void main(String[] args) {

		PreparedStatement pstmt = null;
		Connection conn = null;
		
		try {
			conn = new ConnectionFactory().getConnection();
			
			Scanner sc = new Scanner(System.in);
			System.out.print("급여를 입력하세요 : ");
			int sal = sc.nextInt();
			
			StringBuilder sb = new StringBuilder();
			sb.append("select job_title, avg(salary) "); // 형태로 한줄씩 넣어줌
			sb.append(" from ( ");
			sb.append(" 		select e.employee_id, e.first_name, e.salary, j.job_title ");
			sb.append(" 		from employees e, jobs j ");
			sb.append(" 		where salary >= ? ");
			sb.append(" 		and e.job_id = j.job_id) ");
			sb.append(" 	group by job_title ");
			sb.append(" 	order by 2 desc ");
			
			// preparedStatement 매개변수는 String형이므로 toString() 메서드를 통해 변환 필요
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setInt(1,  sal);
			
			ResultSet rs = pstmt.executeQuery();
			int cnt = 0;
			
			System.out.println();
			System.out.println("------------[직무]별  평균급여--------------");
			while(rs.next()) {
				String job = rs.getString("job_title");
				int salary = rs.getInt(2);
				//기존 컬럼명을 정해두지 않은 경우, 2번째 칼럼이라는 의미로 2로 적어줄 수 있다
				//System.out.println("["+job+"] 평균 급여: "+salary);
				System.out.printf("[%s] %d\n",job,salary);
				cnt++;
			}
			
			System.out.println();
			//rownum 으로 행 번호를 입력하여 출력할 수 있지만, 서브쿼리를 한번 더 써야 하므로 cnt가 간단
			System.out.println("\t총["+cnt+"]명이 검색되었습니다.");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(pstmt, conn);
		}
		

	}

}
