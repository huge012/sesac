package sub;

import java.util.Scanner;

public class Main {

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