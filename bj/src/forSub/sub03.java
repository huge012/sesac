package forSub;

import java.util.Scanner;

/*
 * 2021-12-22
 * 
 * for 03. 합
 * 
 * https://www.acmicpc.net/problem/8393
 * 
 */

public class sub03 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int sum = 0;
		for (int i = 1; i <= n; i++)
			sum += i;
		System.out.print(sum);

	}

}
