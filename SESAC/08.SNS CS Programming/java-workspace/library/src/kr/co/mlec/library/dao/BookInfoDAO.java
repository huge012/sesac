package kr.co.mlec.library.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.co.mlec.library.util.ConnectionFactory;
import kr.co.mlec.library.util.JDBCClose;
import kr.co.mlec.library.vo.BookVO;

public class BookInfoDAO {

	
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
}
