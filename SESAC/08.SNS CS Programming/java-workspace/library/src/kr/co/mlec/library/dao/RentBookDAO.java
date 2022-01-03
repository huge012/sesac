package kr.co.mlec.library.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import kr.co.mlec.library.util.ConnectionFactory;
import kr.co.mlec.library.util.JDBCClose;
import kr.co.mlec.library.vo.ManageVO;

public class RentBookDAO {

	public int insertRentInfo(ManageVO rent)
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			
			conn = new ConnectionFactory().getConnection();
			
			
			// 만약 책 넘버 조회했을 때 빌릴 수 있는 권수가 있다면 + 내 아이디 조회해서 빌릴 수 있는 상태라면 빌리기 실행
			
			StringBuilder sql = new StringBuilder();
			
			// 책 빌릴 수 있는지 체크
			sql.append(" select available_book ");
			sql.append(" from t_books ");
			sql.append(" where book_code = ? and available_book > 0 ");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1,  rent.getBookCode());
			
			ResultSet hasBook = pstmt.executeQuery();
			if(pstmt!=null)
				pstmt.close();
			
			// 내가 빌릴 수 있는지 체크
			sql.setLength(0);
			sql.append(" select lending_book_num ");
			sql.append(" from t_user ");
			sql.append(" where id = ? and lending_book_num < 3 ");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1,  rent.getId());
			
			ResultSet canRent = pstmt.executeQuery();
			if(pstmt!=null)
				pstmt.close();
			
			if (hasBook.next() && canRent.next())
			{
				// t_manage에 대출내용 삽입
				sql.setLength(0);
				sql.append(" Insert into t_manage(no, book_code, id) ");
				sql.append(" values (Numbering.nextval, ?, ?) ");
				pstmt = conn.prepareStatement(sql.toString());
				pstmt.setInt(1, rent.getBookCode());
				pstmt.setString(2, rent.getId());
				
				int succ_rent = pstmt.executeUpdate();
				if(pstmt!=null)
					pstmt.close();
				
				// t_books 대출 현황 추가
				sql.setLength(0);
				sql.append(" update t_books ");
				sql.append(" set available_book = available_book - 1 ");
				sql.append(" where book_code = ? ");
				pstmt = conn.prepareStatement(sql.toString());
				pstmt.setInt(1,  rent.getBookCode());
				
				int succ_book_cnt = pstmt.executeUpdate();
				if(pstmt!=null)
					pstmt.close();
				
				// t_user 대출 현황 추가
				sql.setLength(0);
				sql.append(" update t_user ");
				sql.append(" set lending_book_num = lending_book_num + 1 ");
				sql.append(" where id = ? ");
				pstmt = conn.prepareStatement(sql.toString());
				pstmt.setString(1, rent.getId());
				
				int succ_rent_cnt = pstmt.executeUpdate();
				
				if (succ_rent == 1 && succ_book_cnt == 1 && succ_rent_cnt == 1)
					result = 1;
				else
					result = 0;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(pstmt, conn);
		}
		
		return result;
	}
	
	public int ReturnInfo(ManageVO rent)
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			
			 빌린 코드와 id로 조회, return date sysdate로 업데이트
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
