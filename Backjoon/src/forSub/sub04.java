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
 * for 04. 빠른 A+B
 * 
 * https://www.acmicpc.net/problem/15552
 * 
 * 입출력
 * 버퍼 사용x : 키보드의 입력이 키를 누르는 즉시 바로 전달됨
 * 버퍼 사용o : 키보드 입력이 있을 때마다 한 문자씩 버퍼로 전송, 버퍼 가득 차거나 개행 나오면 한 번에 출력
 * 
 * 버퍼
 * 	데이터를 한 곳에서 다른 한 곳으로 전송하는 동안 일시적으로 데이터를 보관하는 메모리영역
 * 	엔터만 경계로 인식, 받은 데이터는 String으로 고정돼서 별도의 가공 필요
 * 
 * 버퍼 플러시(Buffer Flush) : 버퍼에 남아있는 데이터를 출력(비움)
 * 
 * 버퍼 이용한 입력 : BufferedReader
 * 
 * 버퍼 이용한 출력 : BufferedWriter
 * 
 * 버퍼 가공
 * 	String의 split 함수
 * 	StringTokenizer의 nextToken
 * 
 */

public class sub04 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int num = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		
		for (int i = 0; i < num; i++)
		{
			st = new StringTokenizer(br.readLine(), " ");
			bw.write(Integer.parseInt(st.nextToken())+Integer.parseInt(st.nextToken())+"\n");
		}
		br.close();
		bw.flush();
		bw.close();

	}

}
