package com.sesac.education.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sesac.education.util.ConnectionFactory;
import com.sesac.education.util.JDBCClose;

/**
 * 게시판 DB(tbl_board) CRUD
 * @author user
 *
 */

@Service
public class BoardService {
	
	@Autowired
	BoardDAO dao;
	
	/**
	 * 전체게시글 조회
	 */
	public List<BoardVO> selectAllBoard() {
		
		return dao.selectAllBoard();
	}
	
	/**
	 * 게시물번호 추출(seq_tbl_board_no)
	 */
	public int selectBoardNo() {
		return dao.selectBoardNo();
	}
	
	/**
	 * 새글등록
	 */
	public int insertBoard(BoardVO board) {
		return dao.insertBoard(board);
	}
	
	/**
	 * 조회수 증가
	 */
	public int viewCnt(int boardNo) {
		return dao.viewCnt(boardNo);
	}
	
	/**
	 * 게시글 상세 보기
	 * @param boardNo
	 * @return
	 */
	public BoardVO selectBoardByNo(int boardNo) {
		return dao.selectBoardByNo(boardNo);
	}
	
	/**
	 * 게시물 수정 (제목, 작성, 내용)
	 */
	public int updateBoard(BoardVO board) {
		return dao.updateBoard(board);
	}
	
	/**
	 * 페이징
	 */
	public int boardCnt() {
		return dao.boardCnt();
	}
	
	public int deleteBoardByNo(int boardNo) {
		return dao.deleteBoardByNo(boardNo);
	}
	
	/**
	 * 첨부파일 CRUD
	 */
	public int insertFile(BoardFileVO fileVO) {
		return dao.insertFile(fileVO);
		
	}
	
	public List<BoardFileVO> selectFileByNo(int boardNo) {
		return dao.selectFileByNo(boardNo);
	}
}
