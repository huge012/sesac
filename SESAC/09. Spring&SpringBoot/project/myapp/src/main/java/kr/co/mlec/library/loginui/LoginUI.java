package kr.co.mlec.library.loginui;

import java.util.Scanner;

import kr.co.mlec.library.vo.LoginVO;

public class LoginUI extends BaseUI {
	
	//public static LoginVO logInfo = new LoginVO();
	
	
	
	private String loginMenu() {
		System.out.println("==========================");
		System.out.println("\t    <새싹 도서관>");
		System.out.println("==========================");
		System.out.println("\t   1.로그인");
		System.out.println("\t   2.아이디 생성");
		System.out.println("\t   0.종료");
		System.out.println("--------------------------");
		
		String type = scanStr(">> ");
		return type;
		}
	
	
		@Override
		public void execute() {
			
			while(true) {
				
				ILibraryUI ui = null;
				String type = loginMenu();
				
				switch(type) {
					case "1":
						ui = new MemberLoginUI();
						break;
					case "2":
						ui = new CreateIDUI();
						break;
					case "0":
						ui = new ExitUI();
						break;
				}
				
				if(ui != null) {
					ui.execute();
					
				} else {
					System.out.println(">> 잘못 입력하였습니다. 다시 입력해 주세요.");
				}
			}
		}
}	
