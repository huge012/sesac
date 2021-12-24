package ArraySub;

/*
 * 2021-12-24
 * 
 * Array 06. OX퀴즈
 * 
 * https://www.acmicpc.net/problem/8958
 * 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class sub06 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tries = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < tries; i++)
		{
			String answer = br.readLine();
			int cnt = 1, sum = 0;
			int len = answer.length();
			for (int j = 0; j < len; j++)
			{
				if (answer.charAt(j) == 'O')
					sum += cnt++;
				else
					cnt = 1;
			}
			System.out.println(sum);
		}
		
	}

}
