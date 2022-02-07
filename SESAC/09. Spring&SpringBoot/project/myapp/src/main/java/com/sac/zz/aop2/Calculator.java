package com.sac.zz.aop2;

import org.springframework.stereotype.Component;

//Core Concern : 핵심로직, 비지니스 로직, 주 관심사, 보조관심사의 타겟
@Component
public class Calculator {
	
	public void add(int x, int y) {
		int result = x+y;
		System.out.println("arg2개 add 결과 : "+result);
	}
	public void add() {
		System.out.println("arg0개 add 결과 : ");
	}
	public void add(int x) {
		System.out.println("arg1개 add 결과 : "+x);
	}

	public void sub(int x, int y) {
		int result = x-y;
		System.out.println("arg2개 sub 결과 : "+result);
	}
	public void mul(int x, int y) {
		int result = x*y;
		System.out.println("arg2개 mul 결과 : "+result);
	}
	public void div(int x, int y) {
		int result = x/y;
		System.out.println("arg2개 div 결과 : "+result);
	}
	
}
