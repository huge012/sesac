package ArraySub;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * 2021-12-23
 * 
 * Array 03. 숫자의 개수
 * 
 * https://www.acmicpc.net/problem/2577
 * 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class sub03 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] nums = new int[10];
		int result = Integer.parseInt(br.readLine())*Integer.parseInt(br.readLine())*Integer.parseInt(br.readLine());
		
		while (result != 0)
		{
			nums[result%10]++;
			result/=10;
		}
		
		for (int n : nums)
			System.out.println(n);

	}

}
