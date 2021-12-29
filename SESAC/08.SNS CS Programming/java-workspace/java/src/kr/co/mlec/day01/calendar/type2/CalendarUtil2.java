package kr.co.mlec.day01.calendar.type2;

import java.util.Calendar;

public class CalendarUtil2 {

	public void showByMonth(int year, int month)
	{
		Calendar c = Calendar.getInstance();
		c.set(year, month, 1);
		int day = c.get(Calendar.DAY_OF_WEEK);
		int lastDay = c.getActualMaximum(Calendar.DAY_OF_MONTH);
		
		System.out.println("\t\t<< "+year+"년 "+(month+1)+"월 달력 >>");
		showByDay(day, lastDay);
	}
	
	public void showByDay(int day, int lastDay)
	{
		System.out.println("------------------------------------------------");
		System.out.println("일\t월\t화\t수\t목\t금\t토");
		System.out.println("------------------------------------------------");
		
		for (int i = 1; i < day; i++)
			System.out.print("\t");
		
		for (int i = 1; i <= lastDay; i++)
		{
			System.out.print(i);
			if((i+day-1)%7 == 0)
				System.out.println();
			else
				System.out.print("\t");
		}
		System.out.println();
		System.out.println("---------------------------------------------------");
		System.out.println();
		
	}
	
}
