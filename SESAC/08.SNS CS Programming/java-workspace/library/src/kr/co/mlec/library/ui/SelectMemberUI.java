package kr.co.mlec.library.ui;

import kr.co.mlec.library.vo.MemberVO;

public class SelectMemberUI extends BaseUI implements IMenuUI {

	public static MemberVO user; 
	
	@Override
	public String menu() {
		System.out.println("\t<<도서관리 시스템>>");
		System.out.println("-------------------------------");
		System.out.println("\t1. 회원 ");
		System.out.println("\t2. 관리자");
		System.out.println("\t0. 종료");
		System.out.println("-------------------------------");
		
		String type = scanStr(">> 항목을 선택하세요 : ");
		return type;
	}
	
	public void execute()
	{
		BaseUI ui = null;
		String type = menu();
		user = new MemberVO();
		
		switch(type)
		{
		case "1":
			user.setIsAdmin(0);
			ui = new MemberLoginUI();
			break;
		case "2":
			user.setIsAdmin(1);
			ui = new AdminLoginUI();
			break;
		case "0":
			break;
		}
		
		if (ui != null)
			ui.execute();
		else
			System.out.println(">> 잘못 입력하셨습니다. 다시 입력해주세요.");
	}
	
}
