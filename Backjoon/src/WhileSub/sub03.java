package WhileSub;

/*
 * 2021-12-23
 * 
 * While 03. 더하기 사이클
 * 
 * https://www.acmicpc.net/problem/1110
 * 
 */

import java.util.Scanner;

public class sub03 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int origin = sc.nextInt();
		int circleNum = origin;
		int cnt = 0;
		do 
		{
			circleNum = (circleNum%10)*10 + ((circleNum/10)+(circleNum%10))%10;
			cnt++;
		} while (origin != circleNum);
		System.out.println(cnt);

	}

}
