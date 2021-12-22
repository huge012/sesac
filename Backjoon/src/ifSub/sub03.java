package ifSub;

import java.util.Scanner;

/*
 * 2021-12-22
 * 
 * if 03. 윤년
 * 
 * https://www.acmicpc.net/problem/2753
 * 
 */

public class sub03 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int year = sc.nextInt();
		
		if (year % 400 == 0 || (year%100!=0 && year%4==0))
			System.out.print("1");
		else
			System.out.println("0");
	}

}
