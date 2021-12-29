package kr.co.mlec.day02.Figure02;

public class Square extends Rectangle {

	public Square(int width)
	{
		super(width, width);
	}
	
	public void printArea()
	{
		System.out.printf("가로 %d 인 정사각형의 넓이는 %.2f 입니다.", width, area);
	}
}
