package forSub;

import java.util.Scanner;

/*
 * 2021-12-22
 * 
 * for 01. 구구단
 * 
 * https://www.acmicpc.net/problem/2739
 * 
 */

public class sub01 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		for (int i = 1; i <= 9; i++)
			System.out.println(n+" * "+i+" = "+n*i );
	}

}
