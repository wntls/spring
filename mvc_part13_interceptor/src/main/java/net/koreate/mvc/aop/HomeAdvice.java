package net.koreate.mvc.aop;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class HomeAdvice {
	
	@Around("execution(* net.koreate.mvc.controller.*.*(..))")
	public Object controllerLog(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("=========================================");
		System.out.println("--- AROUND START CONTROLLER");
		System.out.println("target : "+pjp.getTarget());
		System.out.println("name : "+pjp.getSignature().getName());
		System.out.println("args : "+Arrays.toString(pjp.getArgs()));
		// 실체 메소드 호출
		Object o = pjp.proceed();
		// 후처리
		if(o != null) {
			System.out.println("around : "+o);
		}
		System.out.println("--- AROUND END CONTROLLER");
		System.out.println("=========================================");
		return o;
	}
	
}
