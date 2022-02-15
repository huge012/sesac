package com.sesac.springBootMVCProject;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sesac.springBootMVCProject.repository.BoardRepository;
import com.sesac.springBootMVCProject.vo.BoardVO;

@SpringBootTest
public class BoardTest {
	
	@Autowired
	BoardRepository bRepo;
	
	//@Test
	public void test1() {
		IntStream.rangeClosed(1, 100).forEach(i->{
			BoardVO board = BoardVO.builder()
					.title("새싹"+i)
					.writer("user"+(i%10))
					.content("SpringBoot학습"+(i%10))
					.build();
			// 상속받은 CrudRepository에 save() 메소드 있음, 자동으로 insert문장 만들어줌
			bRepo.save(board);
		});
	}
	
	//@Test
	public void test2() {
		// findAll() -> select문, forEach(객체->{실행할 내용})
		bRepo.findAll().forEach(board->{
			System.out.println(board);
		});
	}
	
	//@Test
	public void test3() {
		// int i = 10;
		Long bno = 101l;
		
		System.out.println("======================================");
		// findById() -> 특정 id로 select
		bRepo.findById(bno).ifPresent(board->{
			System.out.println(board);
		});
		System.out.println("======================================");
		// ifPresentOrElse : 값이 있을 경우 (받을 변수->{행동}), 값이 없을 경우 (()->{행동})
		bRepo.findById(bno).ifPresentOrElse(board->{
			System.out.println("찾은 Board : "+board);
		}, ()->{
			System.out.println(bno+"은/는 존재하지 않는 게시번호입니다.");
		});
		System.out.println("======================================");
	}
	
	//@Test
	public void boardUpdate() {
		Long bno = 10l;
		
		// findById(bno) 해당 번호 게시글 찾아서 -> save(board) 보드 업데이트
		// updateDate의 경우 바로 수정됨
		bRepo.findById(bno).ifPresent(board->{
			board.setTitle("수정");
			board.setWriter("JY");
			board.setContent("튤립닭발......");
			bRepo.save(board); // update set ....
		});
	}
	
	//@Test
	public void boardDelete() {
		Long bno = 11L;
		// bno가 같은 컬럼 삭제
		bRepo.deleteById(bno);
	}
	
	//@Test
	public void boardCnt() {
		long cnt = bRepo.count();
		System.out.println("전체 건수 : "+cnt);
	}
	
	//@Test
	public void findByTitleTest() {
		String title="새싹수정";
		bRepo.findByTitle(title).forEach(board->{
			System.out.println(board);
		});
	}
	
	//@Test
	public void findByWriterTest() {
		String writer="user7";
		bRepo.findByWriter(writer).forEach(board->{
			System.out.println(board);
		});
	}
	
	//@Test
	public void findByContentTest() {
		String content="SpringBoot학습7";
		bRepo.findByContent(content).forEach(board->{
			System.out.println(board);
		});
	}
	
	//@Test
	public void findByTitleAndWriterTest() {
		String title="새싹수정";
		String writer="user4";
		bRepo.findByTitleAndWriter(title, writer).forEach(board->{
			System.out.println(board);
		});
	}
	
	//@Test
	public void findByBnoBetweenTest() {
		Long start = 10L;
		Long end = 15L;
		bRepo.findByBnoBetween(start, end).forEach(board->{
			System.out.println(board);
		});
	}
	
	//@Test
	public void findByContentLike() {
		List<BoardVO> blist = bRepo.findByContentLike("%학습9%");
		for(BoardVO board:blist) {
			System.out.println(board);
		}
	}
	
	//@Test
	public void findByContentContaining() {
		List<BoardVO> blist = bRepo.findByContentContaining("학습9");
		for(BoardVO board:blist) {
			System.out.println(board);
		}
	}
	
	//@Test
	public void countByWriterTest() {
		String writer = "user7";
		long count = bRepo.countByWriter(writer);
		System.out.println(writer+"작성자의 게시글 : "+count);
	}
	
	//@Test
	public void findByContentContainingAndGreaterThanTest() {
		List<BoardVO> blist = bRepo.findByContentContainingAndBnoGreaterThan("학습9", 50L);
		for(BoardVO board:blist) {
			System.out.println(board);
		}
	}
	
	//@Test
	public void findByRegDateBefore() {
		
		/* timestamp.valueOf()로 날짜 지정해야 함, 폼은 yyyy-MM-dd hh:mm:ss 형태 */
		Timestamp time = Timestamp.valueOf("2021-02-16 00:00:00");
		
		System.out.println("====================================");
		bRepo.findByRegDateBefore(time).forEach(board->{
			System.out.println(board);
		});
		System.out.println("====================================");
	}
	
	//@Test
	public void findByTitleOrderByWriterTest() {
		String title = "새싹수정";
		bRepo.findByTitleOrderByWriter(title).forEach(board->{
			System.out.println(board);
		});
	}
	
	@Test
	public void findByWriterAndRegDatBetween() {
		String writer = "user4";
		Timestamp start = Timestamp.valueOf("2021-02-14 00:00:00");
		Timestamp end = Timestamp.valueOf("2021-02-16 00:00:00");
		bRepo.findByWriterAndRegDateBetween(writer, start, end).forEach(board->{
			System.out.println(board);
		});
	}
}
