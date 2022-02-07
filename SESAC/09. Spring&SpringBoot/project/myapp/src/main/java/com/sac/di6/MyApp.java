package com.sac.di6;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.co.mlec.library.dao.LoginService;
import kr.co.mlec.library.vo.LoginVO;

public class MyApp {

	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("di5.xml");
		BoardService service = ctx.getBean("boardService", BoardService.class);
		
		List<BoardVO> blist = service.selectAllBoard();
		for(BoardVO board:blist) {
			System.out.println(board);
		}
		System.out.println("-----------------------------");
		blist.forEach(board->{System.out.println(board);});
	}

}
