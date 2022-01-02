package kr.co.mlec.jdbc;

public class StringMain {

	public static void main(String[] args) {
		
		// 1. String 문자열 테스트
		String str = "";
		long start = System.currentTimeMillis();
		for (int i = 0; i < 100000; i++)
			str += i;
		long end = System.currentTimeMillis();
		System.out.println("총 소요시간(초) : " + (end - start)/1000. + "초");
		// 계속 문자열이 바뀌는 상태를 형성, "0" -> "01" -> "012"
		
		
		// 2. 숫자형 테스트
		int sum = 0;
		for(int i = 0; i < 100000; i++)
			sum += i;
		System.out.println("총합 : " + sum);
		
		StringBuilder sb = new StringBuilder();
		start = System.currentTimeMillis();
		for (int i = 0; i < 100000; i++)
			sb.append(i);
		end = System.currentTimeMillis();
		System.out.println("총 소요시간(초) : " + (end - start)/1000. + "초");
		// 0.001초
		// 자주 변환할 문자열은 꼭 stringBuilder로 써야함
		// 앞으로 StringBuilder 사용 예정 (SelectMain03 참조)
		
	}
	
}
