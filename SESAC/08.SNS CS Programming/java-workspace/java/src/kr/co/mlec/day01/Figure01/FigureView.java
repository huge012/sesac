package kr.co.mlec.day01.Figure01;

import java.util.Scanner;

public class FigureView {

	private Scanner sc;
	private Figure fg;
	
	public FigureView()
	{
		sc = new Scanner(System.in);
	}
	
	public void process()
	{
		System.out.println("도형을 선택하세요(1.직사각형 2.정사각형 3.삼각형 4.원)");
		int select = sc.nextInt();
		
		switch(select)
		{
		case 1:
			fg = new rectangle();
			fg.printArea();
			break;
		case 2:
			fg = new square();
			fg.printArea();
			break;
		case 3:
			fg = new triangle();
			fg.printArea();
			break;
		case 4:
			fg = new circle();
			fg.printArea();
			break;
		default:
			System.out.println("잘못 입력하셨습니다.");
		}
	}
	
}
