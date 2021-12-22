package forSub;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
 * 2021-12-22
 * 
 * for 05. N 찍기
 * 
 * https://www.acmicpc.net/problem/2741
 * 
 */

public class sub05 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int num = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= num; i++)
		{
			bw.write(i+"\n");
		}
		br.close();
		bw.flush();
		bw.close();

	}

}
