package com.sac.di1;

public class TVUser {

	public static void main(String[] args) {

		System.out.println("==== Interface 이용한 TV ====");
		m1();
		
		System.out.println("==== Factory 이용한 TV ====");
		m3();
		
	}

	private static void m1() {
		/* Interface 사용 전
		SamsungTV tv1 = new SamsungTV();
		tv1.powerOn();
		tv1.powerOff();
		
		LgTV tv2 = new LgTV();
		tv2.turnOn();
		tv2.turnOff();
		*/
		
		/* Interface 사용 후 */
		ITV tv = new SamsungTV();
		tv.powerOn();
		tv.powerOff();
	}

	private static void m3() {
		ITV tv = TVFactory.makeTV("S");
		tv.powerOn();
		tv.powerOff();
	}
}
