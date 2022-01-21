package kr.co.mlec.board.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.mlec.board.service.BoardService;
import kr.co.mlec.board.vo.BoardFileVO;
import kr.co.mlec.board.vo.BoardVO;
import kr.co.mlec.controller.Controller;

public class DetailBoardController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int no = Integer.parseInt(request.getParameter("no"));
		BoardService service = new BoardService();
		
		// 해당 게시글 + 첨부파일 조회
		/* 기존 보드만 넘기는 방식
		//BoardVO board = service.selectBoardNo(no);
		//request.setAttribute("board", board);
		*/
		
		/* 오브젝트 배열로 접근하는 방식
		Object[] arr = service.selectBoardNo(no);
		
		BoardVO board = (BoardVO)arr[0];
		List<BoardFileVO> fileList = (List<BoardFileVO>)arr[1];
		*/
		
		Map<String, Object> result = service.selectBoardNo(no);
		
		BoardVO board = (BoardVO)result.get("board");
		List<BoardFileVO> fileList = (List<BoardFileVO>)result.get("fileList");
		
		// 공유 영역에 등록
		request.setAttribute("board", board);
		request.setAttribute("fileList", fileList);
		
		return "/jsp/board/detail.jsp?no="+no;
	}

}
