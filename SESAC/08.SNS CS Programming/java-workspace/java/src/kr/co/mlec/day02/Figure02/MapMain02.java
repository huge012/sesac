package kr.co.mlec.day02.Figure02;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/*
 * key : ID
 * value : PW
 * 
 */
public class MapMain02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Map<String, String> members = new HashMap<>();
		members.put("aaa", "1111");
		members.put("bbb", "2222");
		members.put("ccc", "3333");
		members.put("ddd", "4444");
		
		System.out.println(members);
		
		System.out.println("< 비밀번호 변경서비스 >");
		System.out.println("회원님의 아이디를 입력하세요 : ");
		Scanner sc = new Scanner(System.in);
		String id = sc.nextLine();
		if (!members.containsKey(id))
		{
			System.out.println("입력하신 아이디 ["+id+"]은/는 존재하지 않습니다.");
			System.out.println("변경서비스를 종료합니다.");
			System.exit(0);
		}
		System.out.println("현재 패스워드를 입력하세요 : ");
		String password = sc.nextLine();
		if (!(members.get(id).equals(password)))
		{
			System.out.println("패스워드가 일치하지 않습니다.");
			System.out.println("변경서비스를 종료합니다.");
			System.exit(0);
		}
		System.out.println("변경할 패스워드를 입력하세요 : ");
		String newPass = sc.nextLine();
		members.put(id, newPass);
		System.out.println("패스워드 변경이 완료되었습니다.");
		
		System.out.println("<회원 정보 출력>");
		System.out.println("-----------");
		System.out.println("ID\tPASSWORD");
		Set<String> keys = members.keySet();
		for (String key : keys)
			System.out.println(key+"\t"+members.get(key));
		System.out.println("-----------");
		
		System.out.println("변경서비스를 종료합니다.");
	}

}
