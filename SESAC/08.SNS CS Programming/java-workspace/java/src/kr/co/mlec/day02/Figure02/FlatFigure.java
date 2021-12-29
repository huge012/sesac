package kr.co.mlec.day02.Figure02;

abstract public class FlatFigure extends Figure {

	protected int width;
	protected int height;
	
	public FlatFigure(int width, int height)
	{
		this.width = width;
		this.height = height;
		calc();
	}

}
