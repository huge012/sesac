package kr.co.mlec.day02;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/*
 * Set : 순서(x), 중복(x) 인터페이스
 * - HashSet
 * - TreeSet
 */

public class SetMain {

	public static void main(String[] args) {
		
		Set<String> set = new HashSet<>();   // 순서 x
		//Set<String> set = new TreeSet<>();   // 문자열의 경우 오름차순
		
		set.add("one");
		set.add("two");
		set.add("three");
		set.add("four");
		set.add("five");
		
		System.out.println(set.add("one") ? "중복데이터 삽입 성공" : "중복데이터 삽입 실패");
		
		System.out.println("총 갯수 : "+set.size());
		
		// 1.5버전 for문
		System.out.println("<< 전체데이터 출력1 >>");
		for(String str : set)
			System.out.println(str);
		System.out.println("-----------------");
		
		
		// toArray사용
		System.out.println("<< 전체데이터 출력2 >>");
		Object[] arr = set.toArray();
		for(int i = 0; i < arr.length; i++)
			System.out.println(arr[i]);  // toString으로 사용, String과 상관없이 obj출력
		
		// obj 타입을 String으로 형변환 시켜줘야 String 내의 함수를 사용할 수 있음, String으로 형변환시킴
		for(int i = 0; i < arr.length; i++)
		{
			String str = (String)arr[i];
			System.out.println("["+str+"], lengh : "+str.length());
		}
		System.out.println("-----------------");
		
		
		System.out.println("<< 전체데이터 출력3 >>");
		System.out.println(set);
		System.out.println("-----------------");

		
		/*
		 * Iterator (순환자) 주요 메소드 (Set, List 사용가능)
		 *  - hasNext() : 다음 데이터의 존재여부를 판단
		 *  - Next() : 다음 데이터 접근
		 */
		System.out.println("<< 전체데이터 출력4 >>");
		Iterator<String> ite = set.iterator(); // set 내의 String에 접근함
		while (ite.hasNext()) // 데이터 여부 확인
		{
			String str = ite.next();
			System.out.println(str);
		}
		System.out.println("-----------------");
		
	}

}
