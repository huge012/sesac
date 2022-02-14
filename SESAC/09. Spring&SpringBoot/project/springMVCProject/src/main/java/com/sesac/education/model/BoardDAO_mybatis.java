package com.sesac.education.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sesac.education.util.JDBCClose;

/**
 * 게시판 DB(tbl_board) CRUD - mybatis 적용
 * @author user
 *
 */

@Repository
public class BoardDAO_mybatis {
	
	
	@Autowired
	SqlSession session; // session : sql 문장을 실행하는 단위, action-dataSource.xml에 설정
	
	final String namespace = "com.sesac.board.";
	
	/**
	 * 전체게시글 조회
	 */
	public List<BoardVO> selectAllBoard(String keyword, String contents) {
		/* boardMapper.xml에 주었던 namespace + select id
		 * sql로 받는 변수값이 많으므로 selectList
		 * namespace는 변동가능성 있으므로 위에 변수로 지정해주기
		return session.selectList("com.sesac.board.selectAll");
		*/
		
		// sql문 파라미터는 하나만 줄 수 있음, Map으로 넣으면 됨
		Map<String, String> mymap = new HashMap<>();
		mymap.put("keyword", keyword);
		mymap.put("contents", "%"+contents+"%");
		List<BoardVO> blist = session.selectList(namespace+"selectAll", mymap);

		return blist;
	}
	
	/**
	 * 게시물번호 추출(seq_tbl_board_no)
	 */
	public int selectBoardNo() {
		// 1건만 있으므로 selectOne
		return session.selectOne(namespace+"selectBoardNo");
	}
	
	/**
	 * 새글등록
	 */
	public int insertBoard(BoardVO board) {
		// 뒤에 들어가는 매개변수는 파라미터
		return session.insert(namespace+"insertBoard", board);
	}
	
	/**
	 * 조회수 증가
	 */
	public int viewCnt(int boardNo) {
		return session.update(namespace+"viewCnt", boardNo);
	}
	
	/**
	 * 게시글 상세 보기
	 * @param boardNo
	 * @return
	 */
	public BoardVO selectBoardByNo(int boardNo) {
		return session.selectOne(namespace+"selectBoardByNo", boardNo);
	}
	
	/**
	 * 게시물 수정 (제목, 작성, 내용)
	 */
	public int updateBoard(BoardVO board) {
		return session.update(namespace+"updateBoard", board);
	}
	
	public int boardCnt() {
		return session.selectOne(namespace+"boardCnt");
	}
	
	/**
	 * 페이징
	 */
	/*
	public int boardCnt() {
		StringBuilder sql = new StringBuilder();
		sql.append("select count(no) as no from tbl_board ");
		int boardCnt = 0;
		try (
			Connection conn = ds.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		){
			
			ResultSet rs = pstmt.executeQuery();
			
			rs.next();
			boardCnt = rs.getInt("no");
		}catch(Exception e) {
			e.printStackTrace();
		}
		return boardCnt;
	}
	*/
	
	/**
	 * 게시글 삭제
	 * @param boardNo 게시글 번호
	 * @return 게시글 삭제 여부
	 */
	public int deleteBoardByNo(int boardNo) {
		return session.delete(namespace+"deleteBoardByNo", boardNo);
	}
	
	
	/**
	 * 첨부파일 CRUD
	 */
	public int insertFile(BoardFileVO fileVO) {
		return session.insert(namespace+"insertFile", fileVO);
	}
	
	public List<BoardFileVO> selectFileByNo(int boardNo) {
		return session.selectList("selectFileByNo", boardNo);
	}
}
