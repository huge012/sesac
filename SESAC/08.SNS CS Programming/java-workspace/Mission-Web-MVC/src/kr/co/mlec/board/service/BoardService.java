package kr.co.mlec.board.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.co.mlec.board.dao.BoardDAO;
import kr.co.mlec.board.vo.BoardFileVO;
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
	 * 1. 파라미터로 날아온 번호에 맞는 게시글 조회
	 * 2. 파라미터에 해당하는 첨부파일 조회
	 */
	public Map<String, Object> selectBoardNo(int no) {
		// 1.
		BoardVO board = boardDao.selectBoardByNo(no);
		// 2.
		List<BoardFileVO> files = boardDao.selectFileByNo(no);
		
		
		// 1) 오브젝트 배열에 넣어서 넘겨줌
		Object[] arr = {board, files};
		// 2) Map에 넣어서 넘겨줌
		Map<String, Object> data = new HashMap<>();
		data.put("board", board);
		data.put("fileList", files);
		
		return data;
		
		//return arr;
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
	
	/**
	 * 게시물 등록 (첨부파일 포함) 서비스
	 */
	public void insertBoard(BoardVO board, List<BoardFileVO> fileList) {
		// 게시물 번호(seq_tbl_board_no) 추출하여 저장
		int boardNo = boardDao.selectBoardNo();
		
		// tbl_board 저장
		board.setNo(boardNo);
		boardDao.insertBoard(board);
		
		// tbl_board_file 저장
		for (BoardFileVO fileVO : fileList) {
			fileVO.setBoardNo(boardNo);
			boardDao.insertFile(fileVO);
		}
		
	}
}
