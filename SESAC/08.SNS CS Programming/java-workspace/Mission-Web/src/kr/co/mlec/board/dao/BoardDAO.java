package kr.co.mlec.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.co.mlec.board.vo.BoardVO;
import kr.co.mlec.util.ConnectionFactory;
import kr.co.mlec.util.JDBCClose;


/*
 * 게시판 DB(tbl_board) CRUD
 * 
 */
public class BoardDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	
	public BoardDAO () {
		conn = null;
		pstmt = null;
	}
	
	/* 전체 게시글 조회 */
	public List<BoardVO> selectAllBoard(int page) {
		
		int endNum = page*10;
		//int startNum = page*10-9;
		int startNum = endNum-9;
		List<BoardVO> list = new ArrayList<>(); 
		
		try {
			conn = new ConnectionFactory().getConnection();
			
			StringBuilder sql = new StringBuilder();
			sql.append("select no, title, writer, to_char(reg_date, 'yyyy-mm-dd') as reg_date ");
			sql.append(" from ( ");
			sql.append(" 		select * from ( ");
			sql.append(" 			select ROW_NUMBER() over(order by no desc) row_num, tbl_board.* from tbl_board ");
			sql.append(" 		) where row_num >= ? ");
			sql.append(" ) where row_num <= ? ");
				
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, startNum);
			pstmt.setInt(2, endNum);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int no = rs.getInt("no");
				String title = rs.getString("title");
				String writer = rs.getString("writer");
				String regDate = rs.getString("reg_date");
				BoardVO board = new BoardVO(no, title, writer, regDate);
				// System.out.println(board);	
				list.add(board);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(pstmt, conn);
		}
		return list;
	}
	
	/* 새 글 등록 */
	public int insertBoard(BoardVO board) {

		int result = 0;
		
		try {
			conn = new ConnectionFactory().getConnection();
		 	StringBuilder sql = new StringBuilder();
		 	sql.append(" insert into tbl_board(no, title, writer, content) ");
		 	sql.append(" values(seq_tbl_board_no.nextval, ?, ?, ?) ");
		 	
		 	pstmt = conn.prepareStatement(sql.toString());
		 	pstmt.setString(1, board.getTitle());
		 	pstmt.setString(2, board.getWriter());
		 	pstmt.setString(3, board.getContent());
		 	
		 	result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(pstmt, conn);
		}
		
		return result;
	}
	
	public BoardVO selectBoardByNo(int boardNo) {
		
		BoardVO board = null;
		
		try {
			Connection conn = new ConnectionFactory().getConnection();
			
			StringBuilder sql = new StringBuilder();
			sql.append("select no, title, writer, content, view_cnt ");
			sql.append(" , to_char(reg_date, 'yyyy-mm-dd') reg_date ");
			sql.append(" from tbl_board ");
			sql.append(" where no = ? ");
			
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, boardNo);
			
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				int no = rs.getInt("no");
				String title = rs.getString("title");
				String writer = rs.getString("writer");
				String content = rs.getString("content");
				int viewCnt = rs.getInt("view_cnt");
				String regDate = rs.getString("reg_date");
				board = new BoardVO(no, title, writer, content, viewCnt, regDate);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(pstmt, conn);
		}
		return board;
	}
	
	// 글 번호, 제목, 작성자, 내용 날아옴
	public void updateBoard(BoardVO board) {
		
		try {
			conn = new ConnectionFactory().getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("update tbl_board ");
			sql.append(" set title = ?, writer = ?, content = ? ");
			sql.append(" where no = ? ");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getWriter());
			pstmt.setString(3, board.getContent());
			pstmt.setInt(4, board.getNo());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(pstmt, conn);
		}
	}
	
	public void addViewCnt(int boardNo)
	{
		StringBuilder sql = new StringBuilder();
		sql.append(" update tbl_board ");
		sql.append(" set view_cnt = view_cnt+1 ");
		sql.append(" where no = ? ");
		
		try(
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		) {
			pstmt.setInt(1, boardNo);
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/* 전체 게시글 수 세는 메소드 */
	public int countAll()
	{
		int result = 0;
		
		StringBuilder sql = new StringBuilder();
		sql.append(" select count(*) as count ");
		sql.append(" from tbl_board ");
		
		try(
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		) {
				ResultSet rs = pstmt.executeQuery();
				if(rs.next())
					result = rs.getInt("count");
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
}
