package kr.co.mlec.day01.Figure01;

import java.util.Random;

	public class triangle extends Figure {
	private int width, length;
	private Random rd;
	
	public triangle()
	{
		rd = new Random();
		width = rd.nextInt(9)+2;
		length = rd.nextInt(9)+2;
	}
	
	@Override
	public float calc() {
		return (width * length / 2.0f);
	}

	@Override
	public void printArea() {
		float area = calc();
		System.out.printf("높이 %d 밑변 %d 인 삼각형 넓이 : %.2f", width, length, area);
	}
}
