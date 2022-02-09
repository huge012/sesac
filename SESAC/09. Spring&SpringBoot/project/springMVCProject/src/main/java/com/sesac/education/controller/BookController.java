package com.sesac.education.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import kr.co.sesac.model.BookVO;

@Controller
@RequestMapping("/book")
public class BookController {

	List<BookVO> blist;
	
	public BookController() {
		blist = new ArrayList<>();
		blist.add(new BookVO(1, "java", "이현지", "sac", "2022-01-01", 1));
		blist.add(new BookVO(2, "eclipse", "원윤서", "sac", "2022-01-02", 1));
		blist.add(new BookVO(3, "spring", "유규원", "sac", "2022-01-03", 1));
		blist.add(new BookVO(4, "sql", "이미나", "sac", "2022-01-04", 1));
		blist.add(new BookVO(5, "python", "양서영", "sac", "2022-01-05", 1));
		blist.add(new BookVO(6, "c++", "김세린", "sac", "2022-01-06", 1));
		blist.add(new BookVO(7, "c", "유지연", "sac", "2022-01-07", 1));
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	// 405에러 – 허용되지 않는 메소드
	public String bookInsert() {

		return "book/bookInsertForm";
	}

	/*
	 * @RequestParam : int bookNO = Integer.parseInt(request.getParameter("bno"))
	 * @RequestParam은 변수이름과 파라미터 이름이 같을 경우 생략할 수 있음
	 * 
	 * @ModelAttribute("book") : 파라미터로 받은 값을 View로 전달
	 * 
	 */
	
	@RequestMapping(value="/insert", method = RequestMethod.POST) 
	public String bookInsertPost(@RequestParam("bno")int bookNo, @RequestParam String title, String author, String pub, String pubDate, int status, @ModelAttribute("book") BookVO book, Model model, RedirectAttributes redi) { 
		// ->BookVO 형태로 넣자
		/*
		System.out.println("bno : "+bookNo);
		System.out.println("title : "+title);
		System.out.println("author : "+author);
		System.out.println("pub : "+pub);
		System.out.println("pubDate : "+pubDate);
		System.out.println("status : "+status);
		System.out.println("bookVO 받기 : "+book);
		model.addAttribute("myname", "jin");
		model.addAttribute("book2", book);
		*/
		blist.add(book);
		redi.addFlashAttribute("msg", "책 등록 성공!");
		return "redirect:/book/list"; 
	 } //함수의 경우 파라미터가 보이지 않음!
	 

	/*
	 * @RequestMapping(value="/insert2", method = RequestMethod.GET) public String
	 * bookInsertPost() { return "book/bookResult"; }
	 */
	// http://localhost:9999/education/book/insert2?bno=sdsdf&title=d&author=d&pub=d&pubDate=d&status=d
	// 형태로 보여줄 수 있음
	/*
	@RequestMapping(value="/insert", method = RequestMethod.POST) 
	 public String bookInsertPost(BookVO book, Model model) { 
		 System.out.println(book);
		 model.addAttribute("book", book);
		 return "book/bookResult"; 
	 }
	*/
	
	@RequestMapping("/list")
	public String bookList(Model model, HttpServletRequest request) {
		Map<String, ?> flashMap = RequestContextUtils.getInputFlashMap(request);
		if (flashMap != null) {
			String msg = (String)flashMap.get("msg");
			System.out.println(msg);
			model.addAttribute("msg", msg);
		}
		model.addAttribute("bookList", blist);
		return "book/bookList";
	}
	
	
	@RequestMapping("/detail")
	public String detailBook(int no, Model model) {
		for(BookVO b : blist) {
			if (b.getBno() == no)
			{
				model.addAttribute("book", b);
				break;
			}
		}
		return "book/bookResult";
	}
	
	@RequestMapping("/delete")
	public String deleteBook(int bno, Model model, RedirectAttributes redi) {
		for(BookVO b : blist) {
			if (b.getBno() == bno)
			{
				blist.remove(b);
				break;
			}
		}
		redi.addFlashAttribute("msg", "책 삭제 성공!");
		return "redirect:/book/list";
	}

	@RequestMapping(value="/update", method = RequestMethod.POST)
	public String update(BookVO book, RedirectAttributes redi) {
		System.out.println("수정된 Book : "+book);
		for(BookVO b: blist) {
			if(b.getBno() == book.getBno()) {
				b.setAuthor(book.getAuthor());
				b.setPub(book.getPub());
				b.setPubDate(book.getPubDate());
				b.setTitle(book.getTitle());
				break;
			}
		}
		redi.addFlashAttribute("msg", "책 수정 성공!");
		return "redirect:/book/list"; // 새로운 요청

	}
	
	/* 하나의 controller에서의 Exception 처리
	
	@ExceptionHandler(Exception.class)
	public String processException(Exception ex) {
		ex.printStackTrace();
		System.out.println("오류 발생 : "+ex.getMessage());
		
		return "error/errorPage500";
	}
	*/
}
