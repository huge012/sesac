package kr.co.mlec.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.mlec.board.vo.BoardVO;

/*
 *	/board/list.do(전체 리스트 조회) 호출되었을 때
 *  1. 비즈니스 로직 수행(tbl_board에서 전체 게시글 조회)
 *  2. Servlet에게 forward 시킬 jsp 알려줌 
 */
public class boardListController implements Controller {
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		List<BoardVO> list = new ArrayList<>();
		list.add(new BoardVO("aaa", "bbb"));
		list.add(new BoardVO("ccc", "ddd"));
		list.add(new BoardVO("eee", "fff"));
		
		// 받은 데이터를 request 공유영역에 담아야 함
		request.setAttribute("list", list);
		
		// xml, include, forward 의 '/'는 localhost:9999/Mission-Web-MVC를 가리킴
		return "/jsp/board/list.jsp";
	}
}
