package kr.co.mlec.library.ui;

import kr.co.mlec.library.dao.BookInfoDAO;
import kr.co.mlec.library.vo.BookVO;

public class AddBookUI extends BaseUI {

	public void execute()
	{
		BookInfoDAO dao = new BookInfoDAO();
		System.out.println("책을 등록합니다.");
		BookVO book = new BookVO();
		
		book.setBookCode(scanInt("책 코드를 입력하세요 : "));
		book.setTitle(scanStr("책 제목을 입력하세요 : "));
		book.setWriter(scanStr("저자를 입력하세요 : "));
		book.setPublisher(scanStr("출판사를 입력하세요 : "));
		
		int result = dao.addBook(book);
		
		if (result != 0)
		{
			System.out.println("책을 성공적으로 등록했습니다!");
		}
		else
		{
			System.out.println("책 등록에 실패했습니다. 다시 시도해주세요.");
		}
		
	}
	
}
