package kr.co.mlec.library.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
	private int SetRentInfo(ManageVO rent)
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			
			conn = new ConnectionFactory().getConnection();
			
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
			JDBCClose.close(pstmt, conn);
		}
		
		return result;
	}
	
	// t_books 책 수 조정
	private int UpdateavailableBook(ManageVO rent, int insert)
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			
			conn = new ConnectionFactory().getConnection();
			
			StringBuilder sql = new StringBuilder();
			sql.append(" update t_books ");
			sql.append(" set available_book = available_book + ? ");
			sql.append(" where book_code = ? ");
			
			pstmt = conn.prepareStatement(sql.toString());
			
			pstmt.setInt(1, insert);
			pstmt.setInt(2, rent.getBookCode());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(pstmt, conn);
		}
		
		return result;
	}
	
	// t_user 내가 빌린 책수 조정
	private int updateUserRent(ManageVO rent, int insert)
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {			
			conn = new ConnectionFactory().getConnection();
			
			StringBuilder sql = new StringBuilder();
			sql.append(" update t_user ");
			sql.append(" set lending_book_num = lending_book_num + ? ");
			sql.append(" where id = ? ");
			
			pstmt = conn.prepareStatement(sql.toString());
			
			pstmt.setInt(1, insert);
			pstmt.setString(2, rent.getId());
			
			result = pstmt.executeUpdate();
			pstmt.close();
			
			pstmt = conn.prepareStatement(sql.toString());

			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(pstmt, conn);
		}
		
		return result;
	}
	
	public int insertRentInfo(ManageVO rent)
	{
		int result = 0;
		
		int hasBook = CheckBook(rent.getBookCode());
		int canRent = CheckRent(rent.getId());
		
		if (hasBook == 0 || canRent == 0)
			return 0;
		else
		{
			result = SetRentInfo(rent) + UpdateavailableBook(rent, -1) + updateUserRent(rent, 1);
			
			if (result < 3)
				result = 0;
		}
		
		
		return result;
	}
	
	public int ReturnInfo(ManageVO rent)
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			
			 //빌린 코드와 id로 조회, return date sysdate로 업데이트
			// t_user id 찾아서 빌린 책 --
			// t_books 코드 찾아서 보유 권수 ++
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(pstmt, conn);
		}
		
		
		return result;
	}
	
}
