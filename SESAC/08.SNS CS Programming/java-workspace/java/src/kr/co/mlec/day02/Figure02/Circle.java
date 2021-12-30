package kr.co.mlec.day02.Figure02;

public class Circle extends Figure {

	protected int r;
	
	public Circle(int r)
	{
		this.r = r;
		calc();
	}
	
	@Override
	public void calc() {
		area = (float)(r * r * Math.PI);
	}

	@Override
	public void printArea() {
		// TODO Auto-generated method stub
		System.out.printf("반지름 %d 인 원의 넓이는 %.2f 입니다.", r, area);
	}

}
