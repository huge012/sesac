package kr.co.mlec.day02;


import java.util.ArrayList;
import java.util.List;

/*
 * 
 * List : 순서(o), 중복(o)
 * -ArrayList
 * -LinkedList
 * 
 * Wrapper class : 기본 자료형 -> 참조 자료형
 * 기본자료형	참조자료형
 * boolean	Boolean
 * char		Character
 * byte		Byte
 * short	Short
 * int		Integer
 * long		Long
 * float	Float
 * double	Double
 * 
 */

public class ListMain {

	public static  void main(String[] args)
	{
		// ArrayList, LinkedList 상관없이 들어오게 묵시적 형변환
		//List<String> list = new ArrayList<String>();
		// JDK 1.7버전부터 뒤쪽 제너릭 생략 가능
		List<String> list = new ArrayList<>();
		
		// int는 기본 자료형이라 제너릭에 사용 불가
		//List<int> list = new ArrayList<int>();
		// 기본 자료형을 감싸서  참조 자료형으로 만들어줌 (Wrapper class)
		List<Integer> list2 = new ArrayList<>();
		
		// list.add(10); String 아니라서 오류
		// list.add(new Random()); String 아니라서 오류
		list.add("one");
		list.add("two");
		list.add("three");
		list.add("four");
		list.add("one");
		
		System.out.println("원소의 총 개수 : "+list.size());
		System.out.println("0번지 위치한 데이터 : "+list.get(0));
		
		// 데이터 삭제하면 List 내용 앞당겨짐
		System.out.println("0번지 데이터 ( "+list.remove(0)+" ) 삭제완료");
		System.out.println("0번지 위치 데이터 : "+list.get(0));
		
		
		boolean bool = list.contains("three");
		if (bool) 
			System.out.println("three는 존재합니다.");
		else
			System.out.println("three는 존재하지 않습니다");
		
		
		if (list.remove("three"))
			System.out.println("삭제 성공");
		else
			System.out.println("삭제 실패");
		
		bool = list.contains("three");
		if (bool) 
			System.out.println("three는 존재합니다.");
		else
			System.out.println("three는 존재하지 않습니다");
		
		// 데이터 전체 출력 1 : for문
		for (int i = 0; i < list.size(); i++)
			System.out.println(list.get(i));
		
		// 데이터 전체 출력 2 : foreach문, 전체 데이터 출력할 때만 사용
		for (String str : list)
			System.out.println(str);
		
		System.out.println(list);
		
	}
	
}
