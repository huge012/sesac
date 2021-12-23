package ArraySub;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 2021-12-23
 * 
 * Array 02. 최댓값
 * 
 * https://www.acmicpc.net/problem/2562
 * 
 */

/* BufferedReader 사용 */
public class sub02 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] nums = new int[9];
		int idx = 0, max = 0;
		
		for (int i = 0; i < 9; i++)
		{
			nums[i] = Integer.parseInt(br.readLine());
			if ( nums[i] > max) {
				max = nums[i];
				idx = i;
			}
		}
		System.out.print(max+"\n"+(idx+1));
		
	}

}


/*  Scanner 사용
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] nums = new int[9];
		int idx = 0;
		
		for (int i = 0; i < 9; i++)
		{
			nums[i] = sc.nextInt();
			if ( nums[i] > nums[idx])
				idx = i;
		}
		System.out.print(nums[idx]+"\n"+(idx+1));
	}
}*/
