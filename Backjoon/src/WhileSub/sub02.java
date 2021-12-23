package WhileSub;

/*
 * 2021-12-23
 * 
 * While 02. A+B -4
 * 
 * https://www.acmicpc.net/problem/10951
 * 
 * 입력의 끝이 명시되어 있지 않음 : EOF를 확인해야 함
 * EOF : End Of File, 파일의 끝
 * 
 * 백준의 경우 데이터를 주는 과정에서 더이상 데이터를 보내지 않음으로 NoSechElementException을 발생
 * 평소 입력 System.in의 경우 Enter/Space는 예외 발생x 조건문 걸어서 예외처리 하거나 EOF 입력해야 함
 * (윈도우 : ctrl+z, 리눅스 : ctrl+D) or 정수가 아닌 문자열을 입력해 InputMismatchException 줘야함
 * 
 * 1. Scanner
 *  - try-catch문으로 예외 발생 시 반복문 종료
 *  - Scanner 메소드인 hasNext() 사용
 *  
 * 2. BufferedReader
 *  - EOF일 경우 null 반환 (W:ctrl+z, L:ctrl+D)
 *  
 *  
 *  ---
 *  
 *  문제 풀이
 *  
 *  1. Scanner 이용 : hasNext() 반환
 *   - 속도가 BufferedReader보다 느림
 *  
 *  2. BufferedReader 이용
 *   - StringTokenizer 이용하여 구분자 기준 문자열 나눔
 *   - Integer.parseInt()로 문자열을 int형으로 변환
 *   - while문 안에 새 int형 변수 매번 생성하게 되어 딜레이 다소 발생
 *  
 *  3. BufferedReader 이용
 *   - 문제에서 입력되는 정수는 한자리수, 공백 위치도 항상 고정
 *   - 지정된 위치에 있는 문자열만 반환해서 문자열끼리 더하면 더 빠름
 */


/* 2. BufferedReader 이용한 풀이 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class sub02 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st;
		String str; 
		
		while ((str=br.readLine()) != null)
		{
			st = new StringTokenizer(str, " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			bw.write(a+b+"\n");
		}
		br.close();
		bw.flush();
		bw.close();
		
	}

}


/* 1. Scanner 이용한 풀이

import java.util.Scanner;

public class sub02 {

	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);
		
		while (sc.hasNextInt())
		{
			int a = sc.nextInt();
			int b = sc.nextInt();
			System.out.println(a+b);
		}
	}

}

*/



/* 3. BufferedReader 이용한 풀이
 
// https://st-lab.tistory.com/40 참고

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class sub02 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StrinBuilder();
		String str; 
		
		while ((str=br.readLine()) != null)
		{
			int a = str.charAt(0) - 48;
			int b = str.charAt(2) - 48;
			sb.append(a+b).append("\n");
		}
		System.out.print(sb);		
	}

}

*/