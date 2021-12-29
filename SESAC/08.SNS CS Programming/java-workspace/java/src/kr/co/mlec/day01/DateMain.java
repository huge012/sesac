package kr.co.mlec.day01;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateMain {

	public static void main(String[] args)
	{
		// 오늘은 2021년 12월 28일입니다.
		
		/*  date 클래스로 구현   */
		/*
		Date d = new Date();
		System.out.println(d); // d 객체의 toString() 호출, toString은 object 클래스에 toString 존재
		
		int year = d.getYear() + 1900;
		int month = d.getMonth() + 1;
		int day = d.getDate();
		System.out.println("오늘은 "+year+"년 "+month+"월 "+day+"일입니다.");
		*/
		
		/*  Calendar 클래스로 구현  */
		Calendar c = Calendar.getInstance();
		// System.out.println(c); // GregorianCalendar가 생김
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH) + 1;
		int date = c.get(Calendar.DATE); // Calendar.DATE == Calendar.DAY_OF_MONTH
		int day = c.get(Calendar.DAY_OF_WEEK); // 1:일요일 ... 7:토요일
		String[] days = {"", "일", "월", "화", "수", "목", "금", "토"};
		
		System.out.println("오늘은 "+year+"년 "+month+"월 "+date+"일("+days[day]+")입니다.");
		int lastday = c.getActualMaximum(Calendar.DAY_OF_MONTH);
		System.out.println(month+"월의 마지막 날은 "+lastday+"입니다.");
		
		int hour = c.get(Calendar.HOUR);
		int min = c.get(Calendar.MINUTE);
		int sec = c.get(Calendar.SECOND);
		System.out.println("현재 시간은 "+hour+"시 "+min+"분 "+sec+"초입니다.");
		
		
		System.out.println("=======");
		
		// 2019년 5월 15일로 날짜 변경
		c.set(2019, 5-1, 15);
		day = c.get(Calendar.DAY_OF_WEEK);
		System.out.println("2019년 5월 15일은 "+days[day]+"요일입니다.");
		
		
		// 현재 시간으로 초기화
		c = Calendar.getInstance(); // 그레고리안 캘린더 새로 생성 (오늘날짜)
		c.setTime(new Date()); // Date 객체 새로 생성 (오늘날짜)
		
		
		System.out.println("=======");
		
		
		// 캘린더 포맷 설정
		String pattern = "yyyy-MM-dd(E) HH:mm:ss";
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		System.out.println(sdf.format(new Date()));
		
		pattern = "오늘은 yyyy년 MM월 dd일(E요일) HH시 mm분 ss초 입니다.";
		sdf = new SimpleDateFormat(pattern);
		System.out.println(sdf.format(new Date()));
		
		
		// 캘린더 날짜 변경 후 조회
		c.set(2019, 5-1, 15);
		String str = sdf.format(c.getTime());
		System.out.println(str);
		
	}
}
