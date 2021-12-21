package InputOutputCalc;

import java.util.Scanner;

/*
 * 2021-12-21
 * 
 * 입출력과 사칙연산 10. 나머지
 * 
 * https://www.acmicpc.net/problem/10430
 * 
 * 괄호 주의 (그대로 복붙 ok)
 */

public class sub10 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int A = scanner.nextInt();
		int B = scanner.nextInt();
		int C = scanner.nextInt();
		System.out.println((A+B)%C);
		System.out.println(((A%C) + (B%C))%C);
		System.out.println((A*B)%C);
		System.out.println(((A%C) * (B%C))%C);

	}

}
