package kr.co.mlec.library.ui;

public class AdminLoginUI extends BaseUI implements IMenuUI {

	@Override
	public String menu() {

		System.out.println("\t<<로그인 화면 - 관리자용>>");
		System.out.println("----------------------------------");
		System.out.println("1. 로그인");
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
			user.setIsAdmin(1);
			
			switch(type)
			{
			case "1":
				ui = new SignInUI(user); // 로그인
				break;
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
