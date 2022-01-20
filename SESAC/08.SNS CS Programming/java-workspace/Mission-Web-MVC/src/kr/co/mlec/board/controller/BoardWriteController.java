package kr.co.mlec.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

import kr.co.mlec.board.service.BoardService;
import kr.co.mlec.board.vo.BoardVO;
import kr.co.mlec.controller.Controller;
import kr.co.mlec.util.SesacFileNamePolicy;

public class BoardWriteController implements Controller {

	
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

		request.setCharacterEncoding("utf-8");
		
		// String title = request.getParameter("title");
		
		String saveFolder = "C:\\Users\\user\\Documents\\sesac\\SESAC\\08.SNS CS Programming\\java-workspace\\Mission-Web-MVC\\WebContent\\upload";
		
		// request, 저장공간, 파일크기(최대 3mb 설정), 인코딩, 파일명
		MultipartRequest multi = new MultipartRequest(request, saveFolder, 1024*1024*3, "utf-8", new SesacFileNamePolicy());
		
		// 제목, 작성자, 내용 추출
		String title = multi.getParameter("title");
		String writer = multi.getParameter("writer");
		String content = multi.getParameter("content");
		
		BoardVO board = new BoardVO();
		board.setTitle(title);
		board.setWriter(writer);
		board.setContent(content);
		
		BoardService service = new BoardService();
		service.insertBoard(board);
		
		return "redirect:/board/list.do?page=1";
	}

}
