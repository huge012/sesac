package com.sesac.springBootMVCProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sesac.springBootMVCProject.repository.FreeBoardRepository;
import com.sesac.springBootMVCProject.vo.FreeBoard;
import com.sesac.springBootMVCProject.vo.PageMaker;
import com.sesac.springBootMVCProject.vo.PageVO;

@Controller
public class WebBoardController {
	
	@Autowired
	FreeBoardRepository bRepo;
	
	@RequestMapping("/webboard/list")
	public String boardList(PageVO pageVO, Model model) {
		
		// pasing 없이 조회
		// List<FreeBoard> blist = (List<FreeBoard>)bRepo.findAll();
		if(pageVO == null) {
			pageVO = new PageVO();
		}
		Pageable pageable = PageRequest.of(pageVO.getPage(), pageVO.getSize(), Sort.by("bno").descending());
		Page<FreeBoard> result = bRepo.findAll(pageable);
		model.addAttribute("blist", new PageMaker<>(result));
		
		return "board/list"; // 매핑주소와 같으므로 생략가능
	}
	
	@GetMapping("/webboard/detail")
	public String boardDetail(Long bno, Model model) {
		model.addAttribute("board", bRepo.findById(bno).get());
		return "board/detail";
	}
	
	@PostMapping("/webboard/update")
	public String boardDetailUpdate(FreeBoard board) {
		bRepo.findById(board.getBno()).ifPresent(b->{
			b.setTitle(board.getTitle());
			b.setWriter(board.getWriter());
			b.setContent(board.getContent());
			bRepo.save(b);
		});
		return "redirect:list";
	}
	
	@GetMapping("/webboard/delete")
	public String boardDelete(Long bno) {
		bRepo.deleteById(bno);
		return "redirect:list";
	}
	
	@GetMapping("/webboard/insert")
	public String boardInsert() {
		return "board/insertForm";
	}
	
	@PostMapping("/webboard/insert")
	public String boardInsert(FreeBoard board) {
		bRepo.save(board);
		return "redirect:list";
	}
}
