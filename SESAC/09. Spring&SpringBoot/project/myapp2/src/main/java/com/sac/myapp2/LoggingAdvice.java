package com.sac.myapp2;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

// 보조업무 (업무를 기록하는 보조업무)
@Component
@Aspect
public class LoggingAdvice {
	
	@Pointcut("execution(* add(int)) || execution(* add(int, int))")
	public void targetMethod2() {
		
	}
	
	@Around("targetMethod2()")
	public Object aroundMethod(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("[LoggingAdvice 주업무 before - " + joinPoint.getSignature().getName() + "메소드 호출 전");
		Object obj = joinPoint.proceed();
		System.out.println("[LoggingAdvice 주업무 after - " + joinPoint.getSignature().getName() + "메소드 호출 후");
		
		return obj;
	}
	
	@Before("targetMethod2()")
	public void aa(JoinPoint joinPoint) {
		System.out.println("before이벤트..." + joinPoint.getSignature().getName());
	}
	
	@AfterReturning("targetMethod2()")
	public void bb(JoinPoint joinPoint) {
		System.out.println("after이벤트..." + joinPoint.getSignature().getName());
	}
	
}
