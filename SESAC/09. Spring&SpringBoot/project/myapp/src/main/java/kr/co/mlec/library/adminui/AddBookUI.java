package kr.co.mlec.library.adminui;

import kr.co.mlec.library.dao.AdminDAO;
import kr.co.mlec.library.loginui.BaseUI;
import kr.co.mlec.library.vo.BookVO;

public class AddBookUI extends BaseUI {

	@Override
	   public void execute() {
	      String title = scanStr("책 제목을 입력하세요 : ");
	      String author = scanStr("글쓴이를 입력하세요 : ");
	      String pub = scanStr("출판사를 입력하세요 : ");
	      String pubDate = scanStr("출판일을 입력하세요 : ");

	      BookVO library = new BookVO();
	      
	      library.setTitle(title);
	      library.setAuthor(author);
	      library.setPub(pub);
	      library.setPubDate(pubDate);

	      AdminDAO dao = new AdminDAO();
	      
	      int success = dao.addBook(library);
	      
	      if(success>0) 
	         System.out.println("도서 등록 완료 !");
	      else
	         System.out.println("도서 등록 실패");

	   }
	
	
	
}
