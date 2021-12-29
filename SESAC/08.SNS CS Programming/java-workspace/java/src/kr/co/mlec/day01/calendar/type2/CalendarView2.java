package kr.co.mlec.day01.calendar.type2;

import java.util.Calendar;
import java.util.Scanner;

public class CalendarView2 {

	private int year, month;
	private Scanner sc;
	private Calendar c;
	
	public CalendarView2()
	{
		setCalendar();
		sc = new Scanner(System.in);
	}
	
	public void setCalendar()
	{
		Calendar c = Calendar.getInstance();
		year = c.get(Calendar.YEAR);
		month = c.get(Calendar.MONTH);
	}
	
	public void process()
	{
		CalendarUtil2 util = new CalendarUtil2();
		
		while(true)
		{
			System.out.println("항목을 선택하세요(1.현재달 2.이전달 3.다음달 4.종료)");
			int select = sc.nextInt();
			
			
			switch(select)
			{
			case 1:
				setCalendar();
				util.showByMonth(year, month);
				break;
			case 2:
				month--;
				if(month == -1)
				{
					month = 11;
					year--;
				}
				util.showByMonth(year, month);
				break;
			case 3:
				month++;
				if(month == 12)
				{
					month = 0;
					year++;
				}
				util.showByMonth(year, month);
				break;
			case 4:
				System.out.println("=========");
				System.out.println("프로그램 종료");
				System.out.println("=========");
				System.exit(0);
				break;
			default :
				System.out.println("잘못 입력하셨습니다.");
			
			}
		}
	}
	
}
