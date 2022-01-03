package kr.co.mlec.library.ui;

public class MyInfoMenuUI extends BaseUI implements IMenuUI {

	@Override
	public String menu() {
		System.out.println("\t<< 내 정보 수정 - 회원용>>");
		System.out.println("----------------------------------");
		System.out.println("1. 내 정보 수정");
		System.out.println("2. 대출 정보 조회");
		System.out.println("3. 이전 메뉴");
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
				//ui = new UpdateInfoUI();
				break;
			case "2": 
				//ui = new SearchMyRentUI();
				break;
			case "3":
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
