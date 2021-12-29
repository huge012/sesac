package kr.co.mlec.day02.Figure02;

import java.util.Random;
import java.util.Scanner;

public class FigureView {
	
	private Scanner sc;
	private Figure fg;
	private Random rd;
	
	public FigureView()
	{
		sc = new Scanner(System.in);
		rd = new Random();
	}
	
	public void process()
	{
		System.out.println("도형을 선택하세요(1.직사각형 2.정사각형 3.삼각형 4.원)");
		int select = sc.nextInt();
		
		switch(select)
		{
		case 1:
			fg = new Rectangle(rd.nextInt(9)+2, rd.nextInt(9)+2);
			fg.printArea();
			break;
		case 2:
			fg = new Square(rd.nextInt(9)+2);
			fg.printArea();
			break;
		case 3:
			fg = new Triangle(rd.nextInt(9)+2, rd.nextInt(9)+2);
			fg.printArea();
			break;
		case 4:
			fg = new Circle(rd.nextInt(9)+2);
			fg.printArea();
			break;
		default:
			System.out.println("잘못 입력하셨습니다. ");
		}
	}
}
