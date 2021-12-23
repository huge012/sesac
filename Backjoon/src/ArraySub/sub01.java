package ArraySub;

/*
 * 2021-12-23
 * 
 * Array 01. 최소, 최대
 * 
 * https://www.acmicpc.net/problem/10818
 * 
 */

import java.util.Scanner;


public class sub01 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] nums = new int[n];
		
		for (int i = 0; i < n; i++)
			nums[i] = sc.nextInt();
		
		int max = nums[0], min = nums[0];
		
		for (int i = 1; i < n; i++)
		{
			if (nums[i] > max)
				max = nums[i];
			if (nums[i] < min)
				min = nums[i];
		}
		System.out.print(min+" "+max);
		
	}

}
