package kr.co.mlec.day01.calendar.type1;

import java.util.Calendar;

// 달력 출력하는 클래스

public class CalendarUtil {
	
	// 연도 출력
	public void showByYear(int year)
	{
		for (int month = 1; month <= 12; month++)			
			showByMonth(year, month); // this 생략
	}
	
	// 달 출력
	public void showByMonth(int year, int month)
	{		
		// 1. 해당 월의 1일이 무슨 요일인지
		Calendar c = Calendar.getInstance() ;
		c.set(year, month - 1, 1);
		int day = c.get(Calendar.DAY_OF_WEEK);
		
		// 2. 해당 월의 마지막날이 며칠?
		int lastday = c.getActualMaximum(Calendar.DAY_OF_MONTH);
		
		// 달력 출력
		System.out.println("\t\t<< "+year+"년 "+month+"월 >>");
		showByDay(day, lastday);
		
	}

	// 일 출력
	private void showByDay(int week, int lastday)
	{
		System.out.println("---------------------------------------------------");
		System.out.println("일\t월\t화\t수\t목\t금\t토");
		System.out.println("---------------------------------------------------");
		
		/* 
		for (int i = 1; i < week; i++)
			System.out.print("\t");
		
		for (int i = 1; i <= lastday; i++)
		{
			System.out.print(i);
			if((i+week-1)%7 == 0)
				System.out.println();
			else
				System.out.print("\t");
		}
		System.out.println();
		System.out.println("---------------------------------------------------");
		System.out.println();
		*/
		
		int lineCnt = 0;
		
		for (int i = 1; i < week; i++)
		{
			System.out.print("\t");
			lineCnt++;
		}
		
		for (int day = 1; day <= lastday; day++)
		{
			System.out.print(day + "\t");
			lineCnt++;
			if (lineCnt%7 == 0)
				System.out.println();
		}
		System.out.println();
		System.out.println("---------------------------------------------------");
		System.out.println();
	}
}
