package com.sesac.springBootMVCProject.repository;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.sesac.springBootMVCProject.vo.BoardVO;

// BoardVO : entity, Long : PK
public interface BoardRepository extends CrudRepository<BoardVO, Long> {
	
	// CrudRepository의 기본 제공 메소드 : findAll(), findById(), save(), delete(), count()
	
	/* 규칙에 맞게 메소드 추가 */
	
	// 타이틀에 따라 검색
	List<BoardVO> findByTitle(String title);
	
	// 글쓴이에 따라 검색
	List<BoardVO> findByWriter(String writer);
	
	// 내용에 따라 검색
	List<BoardVO> findByContent(String content);
	
	// title & writer에 따라 검색
	List<BoardVO> findByTitleAndWriter(String title, String writer);
	
	// Between Bno
	List<BoardVO> findByBnoBetween(Long start, Long end);
	
	// like - 포함된 걸 찾으려면 %% 써야함
	List<BoardVO> findByContentLike(String content);
	
	// containing - %% 안써도 됨
	List<BoardVO> findByContentContaining(String content);
	
	// count 조건
	long countByWriter(String writer);
	
	// greater than
	List<BoardVO> findByContentContainingAndBnoGreaterThan(String content, Long bno);
	
	// 날짜 before - timestamp 형태이므로 timestamp 사용
	List<BoardVO> findByRegDateBefore(Timestamp date);
	
	// writer 검색 and 날짜 between
	List<BoardVO> findByWriterAndRegDateBetween(String writer, Timestamp start, Timestamp end);
	
	// order by
	List<BoardVO> findByTitleOrderByWriter(String title);
}
