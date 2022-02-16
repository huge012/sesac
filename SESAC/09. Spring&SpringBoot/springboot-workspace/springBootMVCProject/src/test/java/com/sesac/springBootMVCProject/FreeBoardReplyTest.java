package com.sesac.springBootMVCProject;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sesac.springBootMVCProject.repository.FreeBoardRepository;
import com.sesac.springBootMVCProject.vo.FreeBoard;
import com.sesac.springBootMVCProject.vo.FreeBoardReply;

@SpringBootTest
public class FreeBoardReplyTest {
	@Autowired
	FreeBoardRepository bRepo;
	
	@Autowired
	FreeBoardRepository rRepo;
	
	@Test
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
}
