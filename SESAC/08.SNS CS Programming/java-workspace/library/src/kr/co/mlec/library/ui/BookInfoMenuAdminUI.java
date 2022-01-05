package kr.co.mlec.library.ui;

import kr.co.mlec.library.vo.MemberVO;

public class BookInfoMenuAdminUI extends BaseUI implements IMenuUI {

	@Override
	public String menu() {
		System.out.println("\t<< 도서 관련 - 괸리자용 >>");
		System.out.println("----------------------------------");
		System.out.println("1. 전체 도서 조회");
		System.out.println("2. 도서 제목 검색");
		System.out.println("3. 도서 추가");
		System.out.println("4. 도서 폐기");
		System.out.println("5. 도서 정보 수정");
		System.out.println("6. 이전 메뉴");
		System.out.println("0. 종료");
		System.out.println("----------------------------------");
		
		String type = scanStr(">> 메뉴 입력 : ");
		return type;
	}
	
	@Override
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
				 ui = new AddBookUI();
				break;
			case "4":
				//도서 폐기
				break;
			case "5":
				// 도서 정보 수정
				break;
			case "6":
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
