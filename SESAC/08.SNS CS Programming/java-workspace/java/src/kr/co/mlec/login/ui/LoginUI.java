package kr.co.mlec.login.ui;

public class LoginUI extends BaseUI {

	private String menu()
	{
		System.out.println("\t<<게시판 관리 프로그램>>");
		System.out.println("----------------------------------");
		System.out.println("1. 로그인");
		System.out.println("2. 회원가입");
		System.out.println("0. 종료");
		System.out.println("----------------------------------");
		String type = scanStr(">> 메뉴 입력 : ");
		
		return type;
	}
	
	@Override
	public void execute() {
	
		while (true)
		{
			ILoginUI ui = null;
			String type = menu();
			
			switch(type)
			{
			case "1":
				ui = new SignInUI(); // 로그인
				break;
			case "2": 
				ui = new SignUpUI(); // 회원가입
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
