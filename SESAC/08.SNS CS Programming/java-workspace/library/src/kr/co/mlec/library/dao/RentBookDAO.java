package kr.co.mlec.library.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.co.mlec.library.ui.SelectMemberUI;
import kr.co.mlec.library.util.ConnectionFactory;
import kr.co.mlec.library.util.JDBCClose;
import kr.co.mlec.library.vo.ManageVO;

public class RentBookDAO {

	// 책 빌릴 수 있는지 확인
	private int CheckBook(int bookCode)
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			
			conn = new ConnectionFactory().getConnection();
			
			StringBuilder sql = new StringBuilder();
			sql.append(" select available_book ");
			sql.append(" from t_books ");
			sql.append(" where book_code = ? and available_book > 0 ");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1,  bookCode);
			
			ResultSet rs = pstmt.executeQuery();
			
			if (rs.next())
				result++;
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(pstmt, conn);
		}
		
		return result;
	}
	
	// 내가 빌린 책 수 확인 (빌릴 수 있는지 확인)
	private int CheckRent(String id)
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			
			conn = new ConnectionFactory().getConnection();
			
			StringBuilder sql = new StringBuilder();
			sql.append(" select lending_book_num ");
			sql.append(" from t_user ");
			sql.append(" where id = ? and lending_book_num < 3 ");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1,  id);
			
			ResultSet rs = pstmt.executeQuery();
			
			if (rs.next())
				result++;
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(pstmt, conn);
		}
		
		return result;
	}
	
	// t_manage insert
	private int SetRentInfo(Connection conn, ManageVO rent)
	{
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			StringBuilder sql = new StringBuilder();
			sql.append(" insert into t_manage(no, book_code, id ) ");
			sql.append(" values(Numbering.nextval, ?, ? ) ");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, rent.getBookCode());
			pstmt.setString(2, rent.getId());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.stmtClose(pstmt);
		}
		
		return result;
	}
	
	// t_books 책 수 조정
	public int UpdateavailableBook(Connection conn, int bookcode, int insert)
	{
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			StringBuilder sql = new StringBuilder();
			sql.append(" update t_books ");
			sql.append(" set available_book = available_book + ? ");
			sql.append(" where book_code = ? ");
			
			pstmt = conn.prepareStatement(sql.toString());
			
			pstmt.setInt(1, insert);
			pstmt.setInt(2, bookcode);
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.stmtClose(pstmt);
		}
		
		return result;
	}
	
	// t_user 내가 빌린 책수 조정
	private int updateUserRent(Connection conn, ManageVO rent, int insert)
	{
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {			
			StringBuilder sql = new StringBuilder();
			sql.append(" update t_user ");
			sql.append(" set lending_book_num = lending_book_num + ? ");
			sql.append(" where id = ? ");
			
			pstmt = conn.prepareStatement(sql.toString());
			
			pstmt.setInt(1, insert);
			pstmt.setString(2, rent.getId());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.stmtClose(pstmt);
		}
		
		return result;
	}
	
	public int insertRentInfo(ManageVO rent)
	{
		Connection conn = null;
		int result = 0;
		
		int hasBook = CheckBook(rent.getBookCode());
		int canRent = CheckRent(rent.getId());
		
		if (hasBook == 0)
		{
			System.out.println("빌릴 수 있는 책이 없습니다. 다른 책을 찾아주세요.");
		}
		else if (canRent == 0)
		{
			System.out.println("더이상 책을 빌릴 수 없습니다. 기존 책을 반납 후 다시 시도해주세요.");
		}
		else
		{
			try {
				conn = new ConnectionFactory().getConnection();
				conn.setAutoCommit(false);
				
				result += SetRentInfo(conn, rent); // 책 대출내역 입력 insert
				result += UpdateavailableBook(conn, rent.getBookCode(), -1); // 책코드 이용해서 책수 조정 update
				result += updateUserRent(conn, rent, 1); // 책 수 조정 update
				
				if (result == 3)
				{
					conn.commit();
				}
				else
				{
					conn.rollback();
					result = 0;
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				JDBCClose.connClose(conn);
			}
		}
		
		return result;
	}
	
	public int ReturnInfo(ManageVO rent)
	{
		Connection conn = null;
		int result = 0;
		
		
		try {
			conn = new ConnectionFactory().getConnection();
			
			
//			1. 빌린 코드와 id로 조회, return date sysdate로 업데이트
//			2. t_user id 찾아서 빌린 책 --
//			3. t_books 코드 찾아서 보유 권수 ++
//			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.connClose(conn);
		}
		
		
		return result;
	}
	
	// 대출내역 조회
	public List<ManageVO> SearchMyRent() 
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		List<ManageVO> searchmyrent = null;
		
		try {
			conn = new ConnectionFactory().getConnection();
			searchmyrent = new ArrayList<>();
			
			StringBuilder sql = new StringBuilder();
			sql.append(" select book_code, id, lend_date, deadline from t_manage ");
			sql.append(" where id = ? and return_date is null " );
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, SelectMemberUI.user.getId());
			ResultSet rs = pstmt.executeQuery();
			
			
			while(rs.next())
			{
				int bookCode = rs.getInt("book_code");
				String id = rs.getString("id");
				String lendDate = rs.getString("lend_date");
				String deadLine = rs.getString("deadline");
				
				ManageVO myrent = new ManageVO(bookCode, id, lendDate, deadLine);
				
				searchmyrent.add(myrent);
				
			}
			
		} catch(Exception e) { 
			e.printStackTrace();
		} finally {
			JDBCClose.close(pstmt, conn);
		}
		return searchmyrent;   
		
	}
	
	public boolean isRentingBook(int book_code)
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean result = false;
		
		try {
			
			conn = new ConnectionFactory().getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append(" Select id ");
			sql.append(" from t_manage ");
			sql.append(" where book_code = ? and return_date is null ");

			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, book_code);
			
			ResultSet rs = pstmt.executeQuery();
			
			result = rs.next();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(pstmt, conn);
		}
		
		return result;
	}
	
}
