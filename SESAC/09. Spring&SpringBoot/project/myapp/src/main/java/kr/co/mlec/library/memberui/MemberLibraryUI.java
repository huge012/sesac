package kr.co.mlec.library.memberui;
import java.util.Scanner;

import kr.co.mlec.library.loginui.BaseUI;
import kr.co.mlec.library.loginui.ILibraryUI;
import kr.co.mlec.library.vo.LoginVO;
public class MemberLibraryUI extends BaseUI {
	
	private String MemberMenu() {
		System.out.println();
		System.out.println("===================================");
		System.out.println("\t\t   - 회원 모드 -");
		System.out.println("===================================\n");
		System.out.println("\t  <<도서 관리 프로그램>>");
		System.out.println("-----------------------------------");
		System.out.println("\t\t 1. 대 출");
		System.out.println("\t\t 2. 반 납");
		System.out.println("\t\t 3. 도서 목록");
		System.out.println("\t\t 4. 도서 검색");
		System.out.println("\t\t 5. 로그 아웃"); 
		System.out.println("\t\t 0. 종 료");
		System.out.println("-----------------------------------");
		
		String type = scanStr("입력 >> ");
		System.out.println("\n");
		return type;
	}

	@Override
	public void execute() {
		
		while(true) {
			
			ILibraryUI ui = null;
			String type = MemberMenu();
			
			switch(type) {
				case"1":
					ui = new RentalBookUI();
					break;
				case"2":
					ui = new ReturnBookUI();
					break;
				case"3":
					ui = new SelectAllUI();
					break;
				case"4":
					ui = new SelectBookUI();
					break;
				case"5":
					ui = new LogoutUI();
					break;
				case"0":
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
