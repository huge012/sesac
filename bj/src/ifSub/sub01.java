package ifSub;

/*
 * 2021-12-22
 * 
 * if 01. 두 수 비교하기
 * 
 * https://www.acmicpc.net/problem/1330
 * 
 */

import java.util.Scanner;

public class sub01 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		if (a > b)
			System.out.print(">");
		else if (a < b)
			System.out.print("<");
		else
			System.out.print("==");

	}

}
