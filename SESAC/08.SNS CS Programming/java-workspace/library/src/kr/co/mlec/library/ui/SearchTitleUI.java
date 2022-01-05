package kr.co.mlec.library.ui;

import java.util.List;

import kr.co.mlec.library.dao.BookInfoDAO;
import kr.co.mlec.library.vo.BookVO;

public class SearchTitleUI extends BaseUI {

	public void execute()
	{
		String str = scanStr("조회할 제목을 입력하세요 : ");
		
		BookInfoDAO dao = new BookInfoDAO();
		List<BookVO> list = dao.selectTitle(str);
		
		if (list == null || list.isEmpty())
		{
			System.out.println("\'"+ str + "\' 을 포함한 도서가 없습니다.");
		}
		else
		{
			System.out.println("=====================================");
			System.out.println("책 코드\t\t제목\t\t저자\t\t출판사");
			System.out.println("=====================================");
			
			//foreach문 사용하여 출력
			for(BookVO book : list) {
				System.out.println(book.getBookCode()+"\t"
						+book.getTitle()+"\t "
						+book.getWriter()+"\t "
						+book.getPublisher());
			}

			System.out.println("=====================================\n\n");
		}
		
	}
	
}
