package kr.co.mlec.library.adminui;

import kr.co.mlec.library.loginui.BaseUI;
import kr.co.mlec.library.loginui.ILibraryUI;

public class AdminLibraryUI extends BaseUI {
	
	private String AdminMenu() {
		System.out.println();
		System.out.println("======================================");
		System.out.println("\t\t   - 관리자 모드 -");
		System.out.println("======================================\n");
		System.out.println("\t    <<도서 관리 프로그램>>");
		System.out.println("--------------------------------------");
		System.out.println("\t\t  1. 회원 조회");
		System.out.println("\t\t  2. 도서 목록");
		System.out.println("\t\t  3. 도서 번호 검색");
		System.out.println("\t\t  4. 신규 도서 등록");
		System.out.println("\t\t  5. 도서 정보 수정");
		System.out.println("\t\t  6. 도서 삭제");
		System.out.println("\t\t  0. 종 료");
		System.out.println("--------------------------------------");
		
		String type = scanStr(">> ");
		return type;
	}

	@Override
	public void execute() {
		while(true) {
			
			ILibraryUI ui = null;
			String type = AdminMenu();
			
			switch(type) {
				case"1":
					ui = new SelectMemberUI();
					break;
				case"2":
					ui = new SelectAllBookUI();
					break;
				case"3":
					ui = new SelectBookUI();
					break;
				case"4":
					ui = new AddBookUI();
					break;
				case"5":
					ui = new UpdateBookUI();
					break;
				case"6":
					ui = new DeleteBookUI();
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
