package kr.co.mlec.board.ui;

import java.util.Scanner;

// 부모 인터페이스인 IBoardUI의 excute() 함수를 정의하지 않으므로 추상클래스로 지정
public abstract class BaseUI implements IBoardUI {

	protected Scanner sc;
	
	// 생성자
	public BaseUI()
	{
		sc = new Scanner(System.in);
	}
	
	// 문자열 입력받는 메소드
	public String scanStr(String msg)
	{
		System.out.print(msg);
		String str = sc.nextLine();
		
		return str;
	}
	
	// 숫자 입력받는 메소드
	public int scanInt(String msg)
	{
		System.out.println(msg);
		int num = Integer.parseInt(sc.nextLine());
		
		return num;
	}


}
