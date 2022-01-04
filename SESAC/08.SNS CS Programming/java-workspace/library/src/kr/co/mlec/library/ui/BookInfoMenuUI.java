package kr.co.mlec.library.ui;

import kr.co.mlec.library.vo.MemberVO;

public class BookInfoMenuUI extends BaseUI implements IMenuUI {
	
	@Override
	public String menu() {
		System.out.println("\t<< 도서 관련 - 회원용 >>");
		System.out.println("----------------------------------");
		System.out.println("1. 전체 도서 조회");
		System.out.println("2. 도서 제목 검색");
		System.out.println("3. 도서 대출");
		System.out.println("4. 도서 반납");
		System.out.println("5. 이전 메뉴");
		System.out.println("0. 종료");
		System.out.println("----------------------------------");
		
		String type = scanStr(">> 메뉴 입력 : ");
		return type;
	}

	public void execute()
	{
		while (true)
		{
			BaseUI ui = null;
			String type = menu();
			
			switch(type)
			{
			case "1":
				ui = new SearchAllUI();
				break;
			case "2": 
				ui = new SearchTitleUI();
				break;
			case "3":
				ui = new RentBookUI();
				break;
			case "4":
				ui = new ReturnBookUI();
				break;
			case "5":
				System.out.println("이전 메뉴로 돌아갑니다.");
				return;
			case "0":
				ui = new ExitUI();
				break;
			}
			
			if (ui != null)
				ui.execute();
			else
				System.out.println(">> 잘못 입력하셨습니다. 다시 입력해주세요.");
		}
	}
}
