package com.sesac.springBootMVCProject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.sesac.springBootMVCProject.vo.FreeBoard;
import com.sesac.springBootMVCProject.vo.FreeBoardReply;

public interface FreeBoardReplyRepository extends CrudRepository<FreeBoardReply, Long> {
	
	
	/* 특정 보드의 댓글 조회 기능 (1, 2 동일기능) */
	// 1. 규칙에 맞는 메소드 정의
	List<FreeBoardReply> findByBoard(FreeBoard board);
	
	// 2. JPQL 이용
	@Query("select r from FreeBoardReply r where r.board=?1 and r.rno >0 order by r.rno asc ")
	public List<FreeBoardReply> getRepliesOfBoard(FreeBoard board);

}
