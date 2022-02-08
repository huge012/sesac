package com.sesac.education.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
	 public String bookInsertPost(@RequestParam("bno")int bookNo, @RequestParam String title, String author, String pub, String pubDate, int status, @ModelAttribute("book") BookVO book, Model model) { 
		// ->BookVO 형태로 넣자
		 System.out.println("bno : "+bookNo);
		 System.out.println("title : "+title);
		 System.out.println("author : "+author);
		 System.out.println("pub : "+pub);
		 System.out.println("pubDate : "+pubDate);
		 System.out.println("status : "+status);
		 System.out.println("bookVO 받기 : "+book);
		 model.addAttribute("myname", "jin");
		 model.addAttribute("book2", book);
		 return "book/bookResult"; 
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
	public String bookList(Model model) {
		model.addAttribute("bookList", blist);
		return "book/bookList";
	}
	
	
	@RequestMapping("/detail")
	public String detailBook(int bno, Model model) {
		for(BookVO b : blist) {
			if (b.getBno() == bno)
			{
				model.addAttribute("book", b);
				break;
			}
		}
		return "book/bookResult";
	}
	
	@RequestMapping("/delete")
	public String deleteBook(int bno, Model model) {
		for(BookVO b : blist) {
			if (b.getBno() == bno)
			{
				blist.remove(b);
				model.addAttribute("bookList", blist);
				break;
			}
		}
		return "book/bookList";
	}

	@RequestMapping("/update")
	public String update(BookVO book, Model model) {
		for(BookVO b: blist) {
			if(b.getBno() == book.getBno()) {
				b.setAuthor(book.getAuthor());
				b.setPub(book.getPub());
				b.setPubDate(book.getPubDate());
				b.setTitle(book.getTitle());
				break;
			}
		}
		model.addAttribute("message", "수정성공");
		return "book/bookResult";

	}
}
