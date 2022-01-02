package kr.co.mlec.login.ui;

import java.util.Scanner;

public abstract class BaseUI implements ILoginUI {

	protected Scanner sc;
	
	public BaseUI()
	{
		sc = new Scanner(System.in);
	}
	
	public String scanStr(String msg)
	{
		System.out.print(msg);
		return sc.nextLine();
	}
	
}
