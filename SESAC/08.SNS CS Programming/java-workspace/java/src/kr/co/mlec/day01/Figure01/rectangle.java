package kr.co.mlec.day01.Figure01;

import java.util.Random;

public class rectangle extends Figure {

	private int width, length;
	private Random rd;
	
	public rectangle()
	{
		rd = new Random();
		width = rd.nextInt(9)+2;
		length = rd.nextInt(9)+2;
	}
	
	public rectangle(int width, int lenght)
	{
		this.width = length;
		this.length = lenght;
	}
	
	@Override
	public float calc ()
	{
		return width * length;
	}
	
	@Override
	public void printArea()
	{
		float area = calc();
		System.out.printf("가로 %d 세로 %d인 직사각형 넓이 : %.2f\n", width, length, area);
	}
	
}
