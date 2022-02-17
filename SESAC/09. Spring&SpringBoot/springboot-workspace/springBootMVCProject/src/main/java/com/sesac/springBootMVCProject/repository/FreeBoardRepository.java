package com.sesac.springBootMVCProject.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.sesac.springBootMVCProject.vo.FreeBoard;


//public interface FreeBoardRepository extends CrudRepository<FreeBoard, Long> {
// PagingAndSortingRepository에서는 기본으로 findAll(paging), findAll() 제공됨
public interface FreeBoardRepository extends PagingAndSortingRepository<FreeBoard, Long> {
	
	// 특정 키워드를 가진 보드 찾기
	List<FreeBoard> findByTitleContaining(String title);
	
	// 특정 작성자가 작성한 Board 정보를 페이지 정보와 함께 반환
	Page<FreeBoard> findByWriter(String writer, Pageable page);
}
