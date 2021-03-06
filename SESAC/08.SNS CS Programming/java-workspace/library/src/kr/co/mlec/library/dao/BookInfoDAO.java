package kr.co.mlec.library.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.co.mlec.library.util.ConnectionFactory;
import kr.co.mlec.library.util.JDBCClose;
import kr.co.mlec.library.vo.BookVO;
import kr.co.mlec.library.vo.ManageVO;

public class BookInfoDAO {

	// 도서 전체 조회
	public List<BookVO> selectAll()
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		List<BookVO> bookList = null;
		
		try {
			conn = new ConnectionFactory().getConnection();
			bookList = new ArrayList<>();
			
			StringBuilder sql = new StringBuilder();
			sql.append(" select book_code, title, writer, publisher, available_book ");
			sql.append(" from t_books ");
			
			pstmt = conn.prepareStatement(sql.toString());
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next())
			{
				int bookCode = rs.getInt("book_code");
				String title = rs.getString("title");
				String writer = rs.getString("writer");
				String pub = rs.getString("publisher");
				int available = rs.getInt("available_book");
				BookVO book = new BookVO(bookCode, title, writer, pub, available);
				
				bookList.add(book);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(pstmt, conn);
		}
		
		return bookList;
	}
	
	// 도서 제목 조회
	public List<BookVO> selectTitle(String str)
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		List<BookVO> bookList = null;
		
		try {
			conn = new ConnectionFactory().getConnection();
			bookList = new ArrayList<>();
			
			StringBuilder sql = new StringBuilder();
			sql.append(" select book_code, title, writer, publisher, available_book ");
			sql.append(" from t_books ");
			sql.append(" where title like ? ");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, '%'+str+'%');
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next())
			{
				int bookCode = rs.getInt("book_code");
				String title = rs.getString("title");
				String writer = rs.getString("writer");
				String pub = rs.getString("publisher");
				int available = rs.getInt("available_book");
				BookVO book = new BookVO(bookCode, title, writer, pub, available);
				
				bookList.add(book);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(pstmt, conn);
		}
		
		return bookList;
	}
	
	// 도서 정보 조회 (제목, 저자, 출판사)
	public int selectBook(BookVO book)
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			conn = new ConnectionFactory().getConnection();
			
			StringBuilder sql = new StringBuilder();
			sql.append(" select book_code, title, writer, publisher, available_book ");
			sql.append(" from t_books ");
			sql.append(" where title = ? and writer = ? and publisher = ? ");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, book.getTitle());
			pstmt.setString(2, book.getWriter());
			pstmt.setString(3, book.getPublisher());
			
			ResultSet rs = pstmt.executeQuery();
			
			if (rs.next())
				result = rs.getInt("book_code");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(pstmt, conn);
		}
		
		return result;
	}
	
	// 도서 추가
	public int addBook(BookVO book)
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			conn = new ConnectionFactory().getConnection();
			conn.setAutoCommit(false);
			
			// 이미 있는 책
			result = selectBook(book);
			if (result != 0)
			{
				// RentBookDAO에 있는 UpdateavailableBook 사용해서 권수 조정
				RentBookDAO bookdao = new RentBookDAO();
				result = bookdao.UpdateavailableBook(conn, result, 1);
			}
			
			// 새로 insert
			else
			{
				// 기존에 없던 책 추가하는 sql 쿼리
				StringBuilder sql = new StringBuilder();
				sql.append( " insert into t_books(book_code, title, writer, publisher) " );
				sql.append( " values(?, ?, ?, ?) " );
				
				pstmt = conn.prepareStatement(sql.toString());
				
				pstmt.setInt(1, book.getBookCode());
				pstmt.setString(2, book.getTitle());
				pstmt.setString(3, book.getWriter());
				pstmt.setString(4, book.getPublisher());
				
				result = pstmt.executeUpdate();
				
			}
			
			if (result != 0)
				conn.commit();
			else
				conn.rollback();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(pstmt, conn);
		}
		
		return result;
	}
	
	// 책 정보 수정 - BookInfoDAO 클래스 안
	public int updateBook(BookVO book)
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			conn = new ConnectionFactory().getConnection();

			StringBuilder sql = new StringBuilder();
			sql.append(" update t_books ");
			sql.append(" set title = ?, writer = ?, publisher = ? ");
			sql.append(" where book_code = ? ");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, book.getTitle());
			pstmt.setString(2, book.getWriter());
			pstmt.setString(3, book.getPublisher());
			pstmt.setInt(4, book.getBookCode());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(pstmt, conn);
		}
		
		return result;
	}
	
	public int selectNumOfBooks(int book_code) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			conn = new ConnectionFactory().getConnection();

			StringBuilder sql = new StringBuilder();
			sql.append(" select available_book ");
			sql.append(" from t_books ");
			sql.append(" where book_code = ? ");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, book_code);
			
			ResultSet rs = pstmt.executeQuery();

			if (rs.next())
				result = rs.getInt("available_book");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(pstmt, conn);
		}
		
		return result;
	}
	
	// 책 delete 코드
	public int deleteBookInfo(Connection conn, int book_code)
	{
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			StringBuilder sql = new StringBuilder();
			sql.append(" delete t_books ");
			sql.append(" where book_code = ? ");
			
			pstmt = conn.prepareStatement(sql.toString());
			
			pstmt.setInt(1, book_code);
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.stmtClose(pstmt);
		}
		
		return result;
	}
	
	// 책 삭제 종합 dao 코드
	public int deleteBookCheck(int book_code) {
		RentBookDAO rentdao = new RentBookDAO();
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			conn = new ConnectionFactory().getConnection();
			conn.setAutoCommit(false);
			
			int numOfBooks = selectNumOfBooks(book_code);
			boolean isrent = rentdao.isRentingBook(book_code);
			
			// 누가 빌리고 있음 : 책 1권 이상이면 -1, 0권이면 삭제불가
			if (isrent) {
				if (numOfBooks > 0)
				{
					result = rentdao.UpdateavailableBook(conn, book_code, -1);
				}
				else
				{
					result = 0;
				}
			}
			
			// 아무도 빌리지 않음 : 책 2권 이상 -1, 1권이면 삭제
			else {
				if (numOfBooks > 1)
				{
					result = rentdao.UpdateavailableBook(conn, book_code, -1);
				}
				else {
					result = deleteBookInfo(conn, book_code);
				}
			}
			
			if (result > 0)
				conn.commit();
			else
				conn.rollback();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.connClose(conn);
		}

		return result;
	}
	
}
