package com.sac.zz.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.util.StopWatch;

// 보조업무 (업무 시간을 기록하는 보조업무)
public class StopWatchAdvice implements MethodInterceptor {
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		System.out.println("[메서드 호출전 StopWatchAdvice] - " + invocation.getMethod().getName()+"메서드 호출전");
		StopWatch watch = new StopWatch("계산시간");
		watch.start();
		
		// 주업무 호출
		Object obj = invocation.proceed();
		// 주업무 끝
		
		watch.stop();
		System.out.println("[메서드 호출후 StopWatchAdvice] - " + invocation.getMethod().getName()+"메서드 호출후");
		System.out.println(watch.prettyPrint());
		return obj;
	}
}
