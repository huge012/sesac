package com.sac.zz.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

// 보조업무 (업무를 기록하는 보조업무)
public class LoggingAdvice implements MethodInterceptor {
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		System.out.println("[메서드 호출전 LoggingAdvice] - "+invocation.getMethod().getName()+"메서드 호출전");
		
		// 주업무 호출
		Object obj = invocation.proceed();
		// 주업무 끝
		
		System.out.println("[메서드 호출후 LoggingAdvice] - " + invocation.getMethod().getName()+"메서드 호출후");
		
		return obj;
	}
}
