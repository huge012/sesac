package kr.co.mlec.library.memberui;

import java.util.List;

import kr.co.mlec.library.dao.MemberDAO;
import kr.co.mlec.library.loginui.BaseUI;
import kr.co.mlec.library.vo.BookVO;

public class SelectByTitleUI extends BaseUI {

	@Override
	public void execute() {
		// TODO Auto-generated method stub

		String bTitle = scanStr("조회할 책 제목을 입력하세요 : ");

		MemberDAO dao = new MemberDAO();
		List<BookVO> list = dao.selectByTitleBook(bTitle);

		if (list.isEmpty()) {
			System.out.println("조회할 책이 없습니다.\n\n");
		} else {
			System.out.println("\n\n");
			System.out.println("\t\t\t\t--도서 목록--");
			System.out.println("============================================================================");
			System.out.println("번호\t제목\t\t저자\t\t출판사\t\t출판일");
			System.out.println("============================================================================");
			// 도서 등록할 때, 무조건 한글로만 등록하기! -> 영,한 섞이면 정렬 꼬임

			// foreach문 사용하여 출력
			for (BookVO book : list) {
				System.out.printf("%-6s\t%-10s\t%-8s\t%-8s\t%-10s\n", book.getBno(), book.getTitle(), book.getAuthor(),
						book.getPub(), book.getPubDate());

			}
			System.out.println("============================================================================\n\n");
		}
	}

}
