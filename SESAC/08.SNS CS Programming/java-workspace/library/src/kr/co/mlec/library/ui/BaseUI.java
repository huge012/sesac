package kr.co.mlec.library.ui;

import java.util.Scanner;

import kr.co.mlec.library.vo.MemberVO;

public abstract class BaseUI implements IUI {

	private Scanner sc;
	protected MemberVO user;
	
	public BaseUI()
	{
		super();
		sc = new Scanner(System.in);
		user = new MemberVO();
	}
	
	public BaseUI(MemberVO user)
	{
		super();
		sc = new Scanner(System.in);
		this.user = user;
	}
	
	public String scanStr(String msg)
	{
		System.out.print(msg);
		
		return sc.nextLine();
	}
	
	public int scanInt(String msg)
	{
		System.out.print(msg);
		return Integer.parseInt(sc.nextLine());
	}
	
	@Override
	public void execute() {
		// TODO Auto-generated method stub

	}

}
