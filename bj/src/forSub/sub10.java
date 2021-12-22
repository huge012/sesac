package forSub;

import java.util.Scanner;

/*
 * 2021-12-22
 * 
 * for 10. 별 찍기 -2
 * 
 * https://www.acmicpc.net/problem/2439
 * 
 */

public class sub10 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		for (int i = 1; i <= n; i++)
		{
			for (int j = i; j < n; j++)
				System.out.print(" ");
			for (int j = (n-i); j < n; j++)
				System.out.print("*");
			System.out.println();
		}
	}

}
