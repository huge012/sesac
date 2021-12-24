package ArraySub;

/*
 * 2021-12-24
 * 
 * Array 05. 평균
 * 
 * https://www.acmicpc.net/problem/1546
 * 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sub05 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] nums = new int[n];
		int max = 0;
		
		for (int i = 0; i < n; i++)
		{
			nums[i] = Integer.parseInt(st.nextToken());
			if (nums[i] > max)
				max = nums[i];
		}
		
		float sum = 0.0f;
		for (int i = 0; i < n; i++)
			sum += (float)nums[i]/max*100;
		System.out.println(sum/n);
		
	}

}
