package kr.co.mlec.day02.Figure02;

public class Rectangle extends FlatFigure {

	public Rectangle(int width, int height)
	{
		super(width, height);
	}
	
	@Override
	public void calc() {
		area = (float)width*height;
	}

	@Override
	public void printArea() {
		// TODO Auto-generated method stub
		System.out.printf("가로 %d, 세로 %d 인 직사각형의 넓이는 %.2f 입니다.", width, height, area);
	}

}
