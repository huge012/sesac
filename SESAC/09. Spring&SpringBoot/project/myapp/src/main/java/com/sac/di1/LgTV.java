package com.sac.di1;

/*
public class LgTV {
	public void turnOn() {
		System.out.println(getClass().getSimpleName() + " 전원을 켭니다");
	}
	
	public void turnOff() {
		System.out.println(getClass().getSimpleName() + " 전원을 끕니다");
	}
}
*/

public class LgTV implements ITV {
	@Override
	public void powerOn() {
		System.out.println(getClass().getSimpleName() + " 전원을 켭니다");
	}
	
	@Override
	public void powerOff() {
		System.out.println(getClass().getSimpleName() + " 전원을 끕니다");
	}
}
