package kr.co.mlec.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.co.mlec.board.util.ConnectionFactory;
import kr.co.mlec.board.vo.BoardVO;
import kr.co.mlec.board.util.JDBCClose;

/*
 * DAO (Data Access Object)
 * : 
 * 
 */

public class BoardDAO {
/*
 * 1. JDBC 드라이버 로딩
 * 2. DB 접속하여 연결객체를 얻어오기
 * 3. SQL 쿼리 생성
 * 4. 쿼리 실행 및 결과 얻어오기
 * 5. DB 접속 종료
 * 
 */
	// 전체 게시글 조회, List 형태로 리턴받아서 출력하기
	public List<BoardVO> selectAll()
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		List<BoardVO> boardList = null;
		
		
		try {
			conn = new ConnectionFactory().getConnection();
			boardList = new ArrayList<>();
			
			StringBuilder sql = new StringBuilder();
			sql.append(" select no, title, writer, reg_date ");
			sql.append(" from t_board ");
			
			pstmt = conn.prepareStatement(sql.toString());
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next())
			{
				int no = rs.getInt("no");
				String title = rs.getString("title");
				String writer = rs.getString("writer");
				String regDate = rs.getString("reg_date");
				
				BoardVO board = new BoardVO(no, title, writer, regDate);
				
				boardList.add(board);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally
		{
			JDBCClose.close(pstmt, conn);
		}
		return boardList;
	}
	
	
	// 번호로 조회, 번호는 유니크하므로 board로 감쌀 필요 없음
	public BoardVO selectByNo(int boardNo)
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		BoardVO board = null;
		
		try {
			conn = new ConnectionFactory().getConnection();
			
			StringBuilder sql = new StringBuilder();
			sql.append(" select no, title, writer, reg_date ");
			sql.append(" from t_board ");
			sql.append(" where no = ? ");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, boardNo);
			
			ResultSet rs = pstmt.executeQuery();
			// 조회할 게시글은 0~1개뿐. while문 돌 필요 x
			if (rs.next())
			{
				int no = rs.getInt("no");
				String title = rs.getString("title");
				String writer = rs.getString("writer");
				String regDate = rs.getString("reg_date");
				
				board = new BoardVO(no, title, writer, regDate);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(pstmt, conn);
		}
		return board;
	}
	
	// 게시글 입력
	public int insertBoard(BoardVO board)
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			conn = new ConnectionFactory().getConnection();
			
			StringBuilder sql = new StringBuilder();
			sql.append(" insert into t_board(no, title, writer) ");
			sql.append(" values(seq_t_board_no.nextval, ?, ?) ");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getWriter());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(pstmt, conn);
		}
		
		return result;
	}
	
	// 게시글 수정
	public int updateBoard(BoardVO board)
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		int rs = 0;
		
		try {
			
			conn = new ConnectionFactory().getConnection();
			
			StringBuilder sql = new StringBuilder();
			sql.append("update t_board ");
			sql.append(" set title = ?, writer= ? ");
			sql.append(" where no= ? ");
			
			pstmt = conn.prepareStatement(sql.toString());
			
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getWriter());
			pstmt.setInt(3, board.getNo());
			
			rs = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(pstmt, conn);
		}
		
		return rs;
	}
	
	// 게시글 삭제
	public int deleteBoard(int boardNo)
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			
			conn = new ConnectionFactory().getConnection();
			
			StringBuilder sql = new StringBuilder();
			sql.append(" delete t_board ");
			sql.append(" where no= ? ");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, boardNo);
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(pstmt, conn);
		}
		return result;
	}
	
}








