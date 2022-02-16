package com.sesac.springBootMVCProject.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.sesac.springBootMVCProject.vo.BoardVO;

// BoardVO : entity, Long : PK
//public interface BoardRepository extends CrudRepository<BoardVO, Long> {
// CrudRepository <=== PagingAndSortingRepository
public interface BoardRepository extends PagingAndSortingRepository<BoardVO, Long> {
	
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
	List<BoardVO> findByContentContainingAndBnoGreaterThanOrderByBnoDesc(String content, Long bno);
	
	// paging 추가
	List<BoardVO> findByContentContaining(String content, Pageable paging);
	
	// paging 처리 + page 정보 (페이징에 대한 정보와 현재 페이지에 담겨있는 데이터)
	Page<BoardVO> findByBnoGreaterThan(Long bno, Pageable paging);
	
	
	
	
	/* JPQL (JPA Query Language) .... JPA로 자동 생성되는 함수로는 한계가 있음, JPQL를 이용해서 해결 */
	// 테이블명 대신 VO명, * 대신 객체 b, 변수 넣을 땐 앞에 ?n
	@Query("select b from BoardVO b where b.title like %?1% and b.bno > ?2 order by b.bno desc")
	List<BoardVO> findByTitle2(String title, Long bno);
	
	// 객체 변수명 쓰고싶을 땐 @Param 지정
	@Query("select b from BoardVO b where b.title like %:title% and b.bno > :bno2 order by b.bno desc")
	List<BoardVO> findByTitle3(@Param("title") String title, @Param("bno2") Long bno);
	
	// VO명 가변적으로 받을 수 있음
	@Query("select b from #{#entityName} b where b.title like %:title% and b.bno > :bno2 order by b.bno desc")
	List<BoardVO> findByTitle4(@Param("title") String title, @Param("bno2") Long bno);
	
	// sql 쿼리 실제 사용하기 위해선 nativeQuery=true
	@Query(value="select * from tbl2_boards where title like %?1% and bno > ?2 order by bno desc", nativeQuery = true)
	List<BoardVO> findByTitle5(@Param("title") String title, @Param("bno2") Long bno);
	
	
}
