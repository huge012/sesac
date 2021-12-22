package InputOutputCalcSub;

import java.util.Scanner;

/*
 * 2021-12-21
 * 
 * 입출력과 사칙연산 9. 사칙연산
 * 
 * https://www.acmicpc.net/problem/10869
 *
 */

public class sub09 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		System.out.println(a+b);
		System.out.println(a-b);
		System.out.println(a*b);
		System.out.println(a/b);
		System.out.println(a%b);
	}

}
