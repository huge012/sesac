package ifSub;

import java.util.Scanner;

/*
 * 2021-12-22
 * 
 * if 02. 시험 성적
 * 
 * https://www.acmicpc.net/problem/9498
 * 
 */

public class sub02 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		if (a>=90)
			System.out.print("A");
		else if (a>=80)
			System.out.print("B");
		else if (a>=70)
			System.out.print("C");
		else if (a>=60)
			System.out.print("D");
		else
			System.out.print("F");

	}

}
