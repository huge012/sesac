package forSub;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
 * 2021-12-22
 * 
 * for 11. X보다 작은 수
 * 
 * https://www.acmicpc.net/problem/10871
 * 
 */

public class sub11 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < a; i++)
		{
			int value = Integer.parseInt(st.nextToken());
			if (value < b)
				bw.write(value+" ");
		}
		br.close();
		bw.flush();
		bw.close();
	}

}

/* Scanner 이용 - 속도 훨씬 느림

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int idx = sc.nextInt();
		int num = sc.nextInt();
		int[] nums = new int[idx];
		int cnt = 0;
		
		for (int i = 0; i < idx; i++)
		{
			int n = sc.nextInt();
			if (n < num)
				nums[cnt++] = n;
		}

		for (int i = 0; i < cnt; i++)
		{
			System.out.print(nums[i]);
			if (i+1 != cnt)
				System.out.print(" ");
		}
	}
}

 */