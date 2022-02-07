package com.sac.di1;

public class TVFactory {
	
	public static ITV makeTV(String brand) {
		if (brand.equals("S")) {
			return new SamsungTV("ABC");
		}
		else if (brand.equals("L")) {
			return new LgTV();
		} else {
			return null;
		}
	}
	
	
}
