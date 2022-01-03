package kr.co.mlec.library.ui;

import kr.co.mlec.library.vo.MemberVO;

public class AdminMenuUI extends BaseUI implements IMenuUI {

	public AdminMenuUI(MemberVO user)
	{
		super(user);
	}
	
	@Override
	public String menu() {
		System.out.println("\t<< 메인 메뉴 - 관리자용>>");
		System.out.println("----------------------------------");
		System.out.println("1. 도서 관리");
		System.out.println("2. 회원 관리");
		System.out.println("3. 로그아웃");
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
				ui = new BookInfoMenuAdminUI(user);
				break;
			case "2": 
				ui = new MemberInfoMenuUI();
				미구현
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
