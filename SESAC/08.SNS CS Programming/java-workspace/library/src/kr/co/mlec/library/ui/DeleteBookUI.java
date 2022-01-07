package kr.co.mlec.library.ui;

import kr.co.mlec.library.dao.BookInfoDAO;
import kr.co.mlec.library.dao.RentBookDAO;
import kr.co.mlec.library.vo.BookVO;

public class DeleteBookUI extends BaseUI {

	public void execute()
	{
		//	2권 이상 있을 경우 권수--
		//	1권만 있을 경우 빌린 정보 있는지 확인 후 빌려준 책 없으면 delete
		BookInfoDAO dao = new BookInfoDAO();
		int rs = 0;
		int book_code = scanInt("삭제할 책 코드를 입력하세요 : ");
		
		rs = dao.deleteBookCheck(book_code);
			
		if (rs > 0)
		{
			System.out.println("코드 번호 ["+book_code+"] 책을 폐기했습니다.");
		}
		else
		{
			System.out.println("책을 삭제할 수 없습니다. 다시 확인해주세요.");
		}
	}
}
