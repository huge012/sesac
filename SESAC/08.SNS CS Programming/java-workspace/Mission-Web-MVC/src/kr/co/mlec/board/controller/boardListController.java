package kr.co.mlec.board.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.mlec.board.service.BoardService;
import kr.co.mlec.board.vo.BoardVO;
import kr.co.mlec.controller.Controller;
import kr.co.mlec.page.vo.PageVO;

/*
 *	/board/list.do(전체 리스트 조회) 호출되었을 때
 *  1. 비즈니스 로직 수행(tbl_board에서 전체 게시글 조회)
 *  2. Servlet에게 forward 시킬 jsp 알려줌 
 */
public class boardListController implements Controller {
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int page = Integer.parseInt(request.getParameter("page"));
		BoardService service = new BoardService();
		
		// 페이지 정보 담기 (현재 페이지, 토탈 페이지 넣어서 pageVO 설정)
		PageVO paging = service.countAllBoard(page);
		
		// 현재 페이지에 떠야 할 board list 넣음
		List<BoardVO> list = service.selectAllBoard(page);
		
		
		// 받은 데이터를 request 공유영역에 담아야 함
		request.setAttribute("list", list);
		request.setAttribute("paging", paging);

		// xml, include, forward 의 '/'는 localhost:9999/Mission-Web-MVC를 가리킴
		return "/jsp/board/list.jsp?page="+page;
	}
}
