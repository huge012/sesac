package kr.co.mlec.library.ui;

public class BookInfoMenuUI extends BaseUI implements IMenuUI {

	@Override
	public String menu() {
		System.out.println("\t<< 도서 정보 - 관리자용>>");
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
				System.out.println("2번");
				break;
			case "3":
				System.out.println("3번");
				break;
			case "4":
				System.out.println("4번");
				break;
			case "5":
				System.out.println("5번");
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
