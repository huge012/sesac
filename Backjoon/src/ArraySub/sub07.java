package ArraySub;

/*
 * 2021-12-24
 * 
 * Array 07. 평균은 넘겠지
 * 
 * https://www.acmicpc.net/problem/4344
 * 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sub07 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tries = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < tries; i++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int students = Integer.parseInt(st.nextToken());
			int[] scores = new int[students];
			int sum = 0; 
			double avg;
			
			for (int j = 0; j < students; j++)
			{
				scores[j] = Integer.parseInt(st.nextToken());
				sum += scores[j];
			}
			avg = (double)sum / students;
			sum = 0;
			for (int j = 0; j < students; j++)
			{
				if ((float)scores[j] > avg)
					sum++;
			}
			System.out.printf("%.3f%%\n", ((double)sum/students)*100);
		}
		
	}

}
