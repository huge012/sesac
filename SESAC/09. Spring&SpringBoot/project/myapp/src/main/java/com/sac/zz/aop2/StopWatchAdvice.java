package com.sac.zz.aop2;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

// 보조업무 (업무 시간을 기록하는 보조업무)
@Component
@Aspect
public class StopWatchAdvice {
	
	@Pointcut("execution(* div(int, int))")
	public void targetMethod2() {
		
	}
	
	@Around("targetMethod2()")
	public Object invoke(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("[메서드 호출전 StopWatchAdvice] - " + joinPoint.getSignature().getName()+"메서드 호출전");
		StopWatch watch = new StopWatch("계산시간");
		watch.start();
		
		// 주업무 호출
		Object obj = joinPoint.proceed();
		// 주업무 끝
		
		watch.stop();
		System.out.println("[메서드 호출후 StopWatchAdvice] - " + joinPoint.getSignature().getName()+"메서드 호출후");
		System.out.println(watch.prettyPrint());
		return obj;
	}
}
