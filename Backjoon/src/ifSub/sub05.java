package ifSub;

import java.util.Scanner;

/*
 * 2021-12-22
 * 
 * if 05. 알람 시계
 * 
 * https://www.acmicpc.net/problem/2884
 * 
 */

public class sub05 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int hour = sc.nextInt();
		int min = sc.nextInt();
		
		if (min < 45)
		{
			hour -= 1;
			min += 60;
			if(hour<0)
				hour+=24;
		}
		min -= 45;
		System.out.printf("%d %d", hour, min);

	}

}
