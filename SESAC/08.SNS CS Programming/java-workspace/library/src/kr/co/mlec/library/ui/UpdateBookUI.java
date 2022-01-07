package kr.co.mlec.library.ui;

import kr.co.mlec.library.dao.BookInfoDAO;
import kr.co.mlec.library.vo.BookVO;

public class UpdateBookUI extends BaseUI {

	// 책 코드, 제목, 저자, 출판사 수정
	public void execute()
	{
		BookInfoDAO dao = new BookInfoDAO();
		System.out.println("책 내용을 수정합니다.");
		BookVO book = new BookVO();
		
		book.setBookCode(scanInt("수정할 책 코드를 입력하세요: "));
		book.setTitle(scanStr("책 제목을 입력하세요 : "));
		book.setWriter(scanStr("저자를 입력하세요 : "));
		book.setPublisher(scanStr("출판사를 입력하세요 : "));
		
		int result = dao.updateBook(book);
		if(result != 0)
		{
			System.out.println("성공적으로 정보를 수정했습니다.");
		}
		else {
			System.out.println("정보 수정을 실패했습니다. 책 코드를 확인 후 다시 시도해주세요.");
		}
		
	}
}
