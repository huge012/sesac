package kr.co.mlec.library.ui;

public class MemberInfoMenuUI extends BaseUI implements IMenuUI {

	@Override
	public String menu() {
		
		System.out.println("\t<< 회원 관리 메뉴 - 관리자용 >>");
		System.out.println("----------------------------------");
		System.out.println("1. 회원 정보 수정");
		System.out.println("2. 관리자 설정");
		System.out.println("3. 회원 삭제");
		System.out.println("4. 이전 메뉴");
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
				ui = new UpdateMemberInfoUI();
				break;
			case "2": 
				 ui = new SetAdminUI();
				break;
			case "3":
				 ui = new DeleteMemberUI();
				break;
			case "4":
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
