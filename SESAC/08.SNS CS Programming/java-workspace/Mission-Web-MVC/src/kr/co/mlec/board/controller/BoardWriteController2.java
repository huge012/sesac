package kr.co.mlec.board.controller;

import java.io.File;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

import kr.co.mlec.board.service.BoardService;
import kr.co.mlec.board.vo.BoardFileVO;
import kr.co.mlec.board.vo.BoardVO;
import kr.co.mlec.controller.Controller;
import kr.co.mlec.util.SesacFileNamePolicy;

public class BoardWriteController2 implements Controller {

	
	
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
		//service.insertBoard(board);
		
		/* 
		multi.getFile("attachfile1");
		multi.getFile("attachfile2");
		*/
		
		// 첨부파일 추출(file_ori_name, file_save_name, file_size) => tbl_board_file에 저장
		Enumeration<String> files = multi.getFileNames();
		while (files.hasMoreElements()) {
			String fileName = files.nextElement();
			File file = multi.getFile(fileName); // 넘어온 파일이 없을 땐 null
			
			if (file != null) {
				String fileOriName = multi.getOriginalFileName(fileName);
				String fileSaveName = multi.getFilesystemName(fileName);
				int fileSize = (int)file.length();
				
				BoardFileVO fileVO = new BoardFileVO();
				fileVO.setFileOriName(fileOriName);
				fileVO.setFileSaveName(fileSaveName);
				fileVO.setFileSize(fileSize);
			}
			
		}
		return "redirect:/board/list.do?page=1";
	}

}
