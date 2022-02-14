package com.sesac.education.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.sesac.education.model.BoardService;
import com.sesac.education.model.BoardVO;

@Controller
public class BoardController {
	
	@Autowired
	BoardService bService;
	
	@RequestMapping("/board/list.do")
	//@ResponseBody = 응답 문서에 데이터 보내기
	public String boardList(Model model, HttpServletRequest request, @RequestParam(value="keyword", required=false) String keyword, @RequestParam(value="contents", required=false) String contents) {
		
		// list.do를 호출할 때 넘어온 데이터 있는지 확인
		Map<String, ?> map = RequestContextUtils.getInputFlashMap(request);
		if(map != null) {
			// 데이터가 있을 경우 list.jsp로 넘겨줌
			model.addAttribute("msg", map.get("msg"));
		}
		model.addAttribute("list", bService.selectAllBoard(keyword, contents));
		model.addAttribute("boardCnt", bService.boardCnt());
		
		System.out.println(keyword+"------->"+contents);
		if(keyword==null) return "board/list";
		return "board/list_table";
	}
	
	@RequestMapping("/board/detail.do")
	public String detail(int no, Model model) {
		bService.viewCnt(no);
		model.addAttribute("board", bService.selectBoardByNo(no));
		model.addAttribute("fileList", bService.selectFileByNo(no));
		return "board/detail";
	}
	
	@RequestMapping("/board/writeForm.do")
	public String formView(Model model) {
		//model.addAttribute("userVO", model);
		return "board/writeForm";
	}
	
	
	@RequestMapping(value="/board/write.do", method = RequestMethod.POST)
	public String insert(BoardVO board, RedirectAttributes attr) {
		int result = bService.insertBoard(board);
		attr.addFlashAttribute("msg", result > 0 ? "입력성공" : "입력실패");
		
		return "redirect:/board/list.do";
	}
	
	/* 수정 창 보여줌 */
	@RequestMapping(value="/board/update.do", method = RequestMethod.GET)
	public String updateFormView(int no, Model model) {
		model.addAttribute("board", bService.selectBoardByNo(no));
		return "board/update";
	}
	
	/* 실제 수정 */
	@RequestMapping(value="/board/update.do", method = RequestMethod.POST)
	public String update(BoardVO board, RedirectAttributes attr) {
		int result = bService.updateBoard(board);
		attr.addFlashAttribute("msg", result > 0 ? "수정성공" : "수정실패");
		
		return "redirect:/board/list.do";
	}
	
	
	@RequestMapping(value="/board/delete.do")
	public String delete(int no, RedirectAttributes attr) {
		int result = bService.deleteBoardByNo(no);
		attr.addFlashAttribute("msg", result > 0 ? "삭제성공" : "삭제실패");
		
		return "redirect:/board/list.do";
	}
	
}
