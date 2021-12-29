package kr.co.mlec.day02.Figure02;

public class Triangle extends FlatFigure {

	public Triangle(int width, int height)
	{
		super(width, height);
	}
	
	@Override
	public void calc() {
		// TODO Auto-generated method stub
		area = width*height*0.5f;
	}

	@Override
	public void printArea() {
		// TODO Auto-generated method stub
		System.out.printf("밑변 %d, 높이%d 인 삼각형의 넓이는 %.2f 입니다.", width, height, area);
	}

}
