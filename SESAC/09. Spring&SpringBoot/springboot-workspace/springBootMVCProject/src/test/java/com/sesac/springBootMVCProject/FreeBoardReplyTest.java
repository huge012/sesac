package com.sesac.springBootMVCProject;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.sesac.springBootMVCProject.repository.FreeBoardReplyRepository;
import com.sesac.springBootMVCProject.repository.FreeBoardRepository;
import com.sesac.springBootMVCProject.vo.FreeBoard;
import com.sesac.springBootMVCProject.vo.FreeBoardReply;

@SpringBootTest
public class FreeBoardReplyTest {
	@Autowired
	FreeBoardRepository bRepo;
	
	@Autowired
	FreeBoardReplyRepository rRepo;
	
	// @Test
	public void test1() {
		IntStream.rangeClosed(1, 10).forEach(i->{
			
			
			FreeBoard board = FreeBoard.builder()
					.title("제목"+i)
					.writer("새싹"+(i%3))
					.content("내용입니다.")
					.build();
			List<FreeBoardReply> list = new ArrayList<>();
			IntStream.rangeClosed(1, 3).forEach(j->{
				list.add(FreeBoardReply.builder().reply(i+"의 댓글"+j).replyer("user"+j).board(board).build());
			});
			board.setReplies(list);
			bRepo.save(board);
		});
	}
	
	//@Test
	public void test2() {
		// board만 추가
		IntStream.rangeClosed(1, 5).forEach(i->{
			FreeBoard board = FreeBoard.builder()
					.title("목요일"+i)
					.writer("삭")
					.content("내용입니다.")
					.build();
			bRepo.save(board);
		});
	}
	
	//@Test
	public void test3() {
		// board 조회
		bRepo.findAll().forEach(b->{
			System.out.println(b);
		});
	}
	
	//@Test
	public void test4() {
		// board 조회
		bRepo.findByTitleContaining("목요일").forEach(b->{
			System.out.println(b);
		});
	}
	
	//@Test
	public void test5() {
		// board reply 추가
		IntStream.rangeClosed(10, 30).forEach(i->{
		FreeBoard board = bRepo.findById(403L).get();
		FreeBoardReply reply = FreeBoardReply.builder()
					.replyer("댓글")
					.reply("댓글내용입니다"+i)
					.board(board)
					.build();
		rRepo.save(reply);
		});
	}
	
	//@Test
	public void test6() {
		// board reply 조회
		FreeBoard board = bRepo.findById(421L).get();
		rRepo.findByBoard(board).forEach(b->{
			System.out.println(b.getBoard().getWriter()+" 작성자의 댓글 정보 ---> "+b);
		});
	}
	
	//@Test
	public void test7() {
		// board 정보와 댓글의 건수를 가져오기
		FreeBoard board = bRepo.findById(421L).get();
		System.out.println(board);
		System.out.println("총 댓글 수 : "+board.getReplies().size());
		board.getReplies().forEach(reply->{
			System.out.println(reply);
		});
	}
	
	//@Test
	public void test8() {
		Pageable paging = PageRequest.of(0, 5, Sort.by("bno").descending());
		Page<FreeBoard> result = bRepo.findByWriter("삭", paging);
		System.out.println("size : "+result.getSize());
		System.out.println("TotalElements : "+result.getTotalElements());
		System.out.println("TotalPages : "+result.getTotalPages());
		System.out.println("next Page : "+result.nextPageable());

		List<FreeBoard> blist = result.getContent();
		blist.forEach(b->{ System.out.println(b); });
	}
	
	//@Test
	public void test9() {
		// board 조회
		bRepo.findByTitleContaining("목요일").forEach(b->{
			System.out.println(b);
		});
	}
}
