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
 * for 08. A+B -8
 * 
 * https://www.acmicpc.net/problem/11022
 * 
 */

public class sub08 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int num = Integer.parseInt(br.readLine());	
		StringTokenizer st;
		
		for (int i = 1; i <= num; i++)
		{
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			bw.write("Case #"+i+": "+a+" + "+b+" = "+(a+b)+"\n");
		}
		br.close();
		bw.flush();
		bw.close();
		
	}

}
