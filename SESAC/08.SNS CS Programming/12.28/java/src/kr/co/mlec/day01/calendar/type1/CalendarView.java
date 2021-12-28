package kr.co.mlec.day01.calendar.type1;

import java.util.Scanner;

// 화면에 텍스트 출력, 키 입력받는 class

public class CalendarView {
	
	// private Scanner sc = new Scanner(System.in);
	private Scanner sc;
	
	public CalendarView()
	{
		sc = new Scanner(System.in);
		
	}
	
	public void process()
	{
		CalendarUtil util = new CalendarUtil();
		int year = 0, month = 0;
		
		while (true) // loop: while(true) ... : while문에 별칭 달아줌
		{
			System.out.print("항목을 선택하세요(1.특정년도  2.특정월  3.종료) : ");
			int type = sc.nextInt();

			switch (type) // switch : 정수형, 문자, 문자형(jdk1.0이후)
			{
			case 1:
				System.out.print("연도를 입력하세요 : ");
				year = sc.nextInt();
				util.showByYear(year);
				break;
			case 2:
				System.out.print("연도를 입력하세요 : ");
				year = sc.nextInt();
				System.out.print("월을 입력하세요 : ");
				month = sc.nextInt();
				util.showByMonth(year, month);
				break;
			case 3:
				System.out.println("================");
				System.out.println("프로그램을 종료합니다.");
				System.out.println("================");
				System.exit(0); // break loop; ... : loop 반복문을 break
			default:
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			}
		}
	}
	
}
