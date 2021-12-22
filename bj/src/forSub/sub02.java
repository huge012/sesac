package forSub;

import java.util.Scanner;

/*
 * 2021-12-22
 * 
 * for 02. A+B -3
 * 
 * https://www.acmicpc.net/problem/10950
 * 
 */

public class sub02 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		for (int i = 0; i < n; i++)
		{
			int num1 = sc.nextInt();
			int num2 = sc.nextInt();
			System.out.println(num1+num2);
		}
	}

}
