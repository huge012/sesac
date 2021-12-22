package forSub;

import java.util.Scanner;

/*
 * 2021-12-22
 * 
 * for 09. 별 찍기 -1
 * 
 * https://www.acmicpc.net/problem/2438
 * 
 */

public class sub09 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		
		for (int i = 0; i < n; i++)
		{
			for (int j = 0; j <= i; j++)
				System.out.print("*");
			System.out.println();
		}

	}

}
