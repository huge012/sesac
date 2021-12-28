package kr.co.mlec.day01.Figure01;

import java.util.Random;

public class circle extends Figure {

	private int length;
	private Random rd;
	
	public circle()
	{
		rd = new Random();
		length = rd.nextInt(9)+2;
	}
	
	@Override
	public float calc() {
		return 3.14f*length*length;
	}
	
	@Override
	public void printArea() {
		// TODO Auto-generated method stub
		float area = calc();
		System.out.printf("반지름 %d 인 원의 넓이 : %.2f\n", length, area);
	}
	
}
