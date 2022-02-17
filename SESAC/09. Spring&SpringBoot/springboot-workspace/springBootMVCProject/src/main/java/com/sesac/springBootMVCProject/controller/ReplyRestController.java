package com.sesac.springBootMVCProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sesac.springBootMVCProject.repository.FreeBoardReplyRepository;
import com.sesac.springBootMVCProject.repository.FreeBoardRepository;
import com.sesac.springBootMVCProject.vo.FreeBoard;
import com.sesac.springBootMVCProject.vo.FreeBoardReply;

@RestController
public class ReplyRestController {
	
	@Autowired
	FreeBoardReplyRepository rRepo;
	@Autowired
	FreeBoardRepository bRepo;
	
	// RestController는 겟방식 변수를 주소에서 받음, @PathVariable('변수명')으로 받아옴
	@RequestMapping("/replies/list/{bno}")
	public List<FreeBoardReply> selectAllByBoard(@PathVariable("bno") Long boardNo) {
		
		// 값이 있으면 get() 없으면 null
		FreeBoard board = bRepo.findById(boardNo).orElse(null);
		if (board == null) return null;
		List<FreeBoardReply> replyList = rRepo.findByBoard(board);
		return replyList;
	}
	
	@RequestMapping("/replies/add/{bno}")
	public List<FreeBoardReply> insert(@RequestBody FreeBoardReply reply, @PathVariable("bno") Long boardNo){
		System.out.println(reply);
		System.out.println(boardNo);
		FreeBoard board = bRepo.findById(boardNo).orElse(null);
		reply.setBoard(board);
		rRepo.save(reply);
		// 값이 있으면 get() 없으면 null
		if (board == null) return null;
		List<FreeBoardReply> replyList = rRepo.findByBoard(board);
		return replyList;
	}
	
}
