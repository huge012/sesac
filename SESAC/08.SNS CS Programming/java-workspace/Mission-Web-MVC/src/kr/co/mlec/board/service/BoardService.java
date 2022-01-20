package kr.co.mlec.board.service;

import java.util.List;

import kr.co.mlec.board.dao.BoardDAO;
import kr.co.mlec.board.vo.BoardVO;
import kr.co.mlec.page.vo.PageVO;

public class BoardService {
	
	private BoardDAO boardDao;
	
	public BoardService() {
		boardDao = new BoardDAO();
	}
	
	/**
	 * 게시글 조회 서비스
	 */
	public List<BoardVO> selectAllBoard(int page){
		PageVO pageInfo = new PageVO();
		pageInfo.setPage(page);
		pageInfo.setTotalCount(boardDao.countAll());
		List<BoardVO> list = boardDao.selectAllBoard(pageInfo);
		return list;
	}
	
	/**
	 * 보드 갯수 카운트
	 */
	public PageVO countAllBoard(int nowPage) {
		PageVO page = new PageVO();
		page.setPage(nowPage);
		page.setTotalCount(boardDao.countAll());
		return page;
	}
	
	/**
	 * 상세 게시글 조회 서비스
	 */
	public BoardVO selectBoardNo(int no) {
		BoardVO board = null;
		
		board = boardDao.selectBoardByNo(no);
		return board;
	}
	
	/**
	 * 조회수 증가
	 */
	public void addViewCnt(int no) {
		boardDao.addViewCnt(no);
	}
	
	/**
	 * 게시물 등록 서비스
	 */
	public void insertBoard(BoardVO board) {
		boardDao.insertBoard(board);
	}
}
