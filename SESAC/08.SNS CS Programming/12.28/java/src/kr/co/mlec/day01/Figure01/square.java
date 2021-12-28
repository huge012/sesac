package kr.co.mlec.day01.Figure01;

import java.util.Random;

public class square extends Figure {

	private int width;
	private Random rd;
	
	public square()
	{
		rd = new Random();
		width = rd.nextInt(9)+2;
	}
	
	@Override
	public float calc() {
		return width * width;
	}

	@Override
	public void printArea() {
		float area = calc();
		System.out.printf("가로 %d 인 정사각형 넓이 : %.2f\n", width, area);
	}
	
}
