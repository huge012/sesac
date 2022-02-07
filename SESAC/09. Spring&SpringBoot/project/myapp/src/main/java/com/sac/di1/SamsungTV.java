package com.sac.di1;

/*public class SamsungTV {
	public void powerOn() {
		System.out.println(getClass().getSimpleName() + " 전원을 켭니다");
	}
	
	public void powerOff() {
		System.out.println(getClass().getSimpleName() + " 전원을 끕니다");
	}
}*/

public class SamsungTV implements ITV {
	
	public SamsungTV() {
		System.out.println("default 생성자");
	}
	
	public SamsungTV(String model) {
		System.out.println(model + ":arg1 생성자");
	}
	
	@Override
	public void powerOn() {
		System.out.println(getClass().getSimpleName() + " 전원을 켭니다");
	}
	
	@Override
	public void powerOff() {
		System.out.println(getClass().getSimpleName() + " 전원을 끕니다");
	}
}