package kr.co.mlec.board.ui;

import java.util.Scanner;

/*
 * ui들만 모아두는 패키지로 분리해서 생성
 * 모든 입력, 출력 시스템 - 사용자와의 모든 커뮤니케이션을 보여줄 목적으로 생성!
 */

public class BoardUI extends BaseUI {

	private String menu()
	{
		System.out.println("   <<게시판 관리 프로그램>>");
		System.out.println("-------------------------------");
		System.out.println("\t1. 전체 게시글 조회");
		System.out.println("\t2. 글번호 조회");
		System.out.println("\t3. 새 글 등록");
		System.out.println("\t4. 글 수정");
		System.out.println("\t5. 글 삭제");
		System.out.println("\t6. 로그아웃");
		System.out.println("\t0. 종료");
		System.out.println("-------------------------------");
		
		//상속 받았으므로 바로 사용 가능 - 편하다!
		String type = scanStr(">> 항목을 선택하세요  : ");
		return type;
		
	}
	
	@Override
	public void execute() {
		while (true) {
			IBoardUI ui = null;
			String type = menu();
			
			/*
			 * 메뉴 하나마다 실행할 메서드를 만들어주기
			 * 이때, 이름이 각각 다르면 실행할 때 모를 수 있으므로 execute로 표준화를 시킬 것임
			 * 		-> 인터페이스 이용
			 */
			switch(type) {
			case "1":
				ui = new SearchAllUI();
				break;
			case "2":
				ui = new SearchByNoUI();
				break;
			case "3":
				ui = new AddUI();
				break;
			case "4":
				ui = new UpdateUI();
				break;
			case "5":
				ui = new DeleteUI();
				break;
			case "6":
				return;
			case "0":
				ui = new ExitUI();
				break;				
			}
			
			if(ui != null)
				ui.execute();
			else
				System.out.println(">> 잘못 입력하셨습니다. 다시 입력해주세요.");
		}

		/*
		 * 1,2,3,4,5,0 실행 할때마다 각각의 객체를 생성해서 execute() 메서드를 실행하는 것이 반복된다
		 * <기존 코드>
		 * AddUI add = new AddUI();
		 * add.execute();
		 * <새로운 코드>
		 * IBoardUI ui = null;
		 * ui = neww AddUI(); <<묵시적 형변환
		 * ui.execute();
		 * 
		 * ===>맨 처음 IBoardUI 객체를 생성하여 형변환시켜줄 수 있다.
		 * 		--> 객체를 생성하고 맨 switch를 빠져나와서 모두가 execute()메서드를 실행하면 됨 (단, null이 아닐 경우에만!)
		 */
		
	}

}
