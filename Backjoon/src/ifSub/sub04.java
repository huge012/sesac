package ifSub;

import java.util.Scanner;

/*
 * 2021-12-22
 * 
 * if 04. 사분면 고르기
 * 
 * https://www.acmicpc.net/problem/14681
 * 
 */

public class sub04 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int x = sc.nextInt();
		int y = sc.nextInt();
		
		if (x>=0 && y>=0)
			System.out.print("1");
		else if (x>=0 && y<0)
			System.out.print("4");
		else if (x<0 && y>=0)
			System.out.println("2");
		else
			System.out.println("3");

	}

}
