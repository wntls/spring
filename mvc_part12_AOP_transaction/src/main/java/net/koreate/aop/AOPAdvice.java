package net.koreate.aop;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import org.apache.taglibs.standard.tag.common.core.NullAttributeException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import net.koreate.dao.MessageDAO;
import net.koreate.vo.MessageVO;

@Component
@Aspect
@Slf4j
public class AOPAdvice {
	
	public AOPAdvice() {
		System.out.println("AOPAdvice 생성");
		log.info("logger AOP advice");
	}
	
	@Before("execution(* net.koreate.service.*.*(..))")
	public void startLog(JoinPoint jp) throws RuntimeException{
		log.info("---------------------------------------");
		log.info("----------START LOG------------");
		// net.koreate.service.MessageService
		log.info("target : "+ jp.getTarget());
		// method-execution
		log.info("type : "+ jp.getKind());
		// 실행 된 메소드 이름
		log.info("name : "+ jp.getSignature().getName());
		Object[] objs =jp.getArgs();
		log.info("parameters : "+ Arrays.toString(objs));
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		log.info("start time : "+ sdf.format(new Date()));
		log.info("----------END START LOG------------");
	}
	
	@After("execution(* net.koreate.service.MessageService.*(..))")
	public void endLog(JoinPoint jp) throws RuntimeException{
		log.info("----------END LOG------------");
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		log.info("start time : "+ sdf.format(new Date()));
		log.info("----------END LOG END------------");
	}
	
	@AfterReturning(pointcut="execution(!void net.koreate.service.MessageService.*(..))",returning="returnValue")
	public void returningTest(JoinPoint jp, Object returnValue) throws RuntimeException{
		log.info("-------------AfterReturning LOG-----------");	
		log.info("target : "+ jp.getTarget());
		log.info("type : "+ jp.getKind());
		log.info("name : "+ jp.getSignature().getName());
		log.info("return : "+returnValue);
		Object[] objs = jp.getArgs();
		log.info("parameters : "+ Arrays.toString(objs));
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		log.info("start time : "+ sdf.format(new Date()));
		log.info("-------------END AfterReturning LOG-----------");	
	}
	
	@Around("execution(* net.koreate.controller.MessageController.*(..))")
	public Object controllerLog(ProceedingJoinPoint pjp) throws Throwable {
		log.info("----------------------------------------");
		log.info("-------------Around Controller START---------------");
		long startTime = System.currentTimeMillis();
		log.info("Around target : "+pjp.getTarget());
		log.info("Around name : "+pjp.getSignature().getName());
		log.info("Around parameters : " + Arrays.toString(pjp.getArgs()));
		
		Object o = pjp.proceed();
		if(o != null) {
			log.info("Around Object : "+o);
			log.info("Around Object : "+o.toString());
		}
		
		long endTime = System.currentTimeMillis();
		log.info("work time : "+ (endTime - startTime));
		log.info("-------------Around Controller END---------------");
		return o;
	}
	
	@Autowired
	private MessageDAO dao;
	
	
	@Around(value = "execution(net.koreate.vo.MessageVO net.koreate.service.MessageService.readMessage(..)) && args(uid,mno)")
	public Object readMessageCheck(ProceedingJoinPoint pjp, String uid, int mno) throws Throwable{
		Object[] args = pjp.getArgs();
		log.info("args : "+ args);
		MessageVO messageVO = dao.readMessage(mno);
		log.info(messageVO.toString());
		if(messageVO.getOpnedate() != null) {
			log.info("------- throw readMessage Around END");
			throw new NullPointerException("이미 읽은 메세지");
		}
		
		Object o = pjp.proceed();
		
		if(o != null && o instanceof MessageVO) {
			messageVO = (MessageVO)o;
			log.info("readMessage Around : "+ messageVO);
		}
		log.info("-------- readMessage Around END-------");
		return o;
	}
	
	@AfterThrowing(value = "execution(* net.koreate.service.*.*(..))",throwing = "exception")
	public void endThrowingLog(JoinPoint jp, Exception exception) {
		log.info("---------------------------------");
		log.info("----------- START AFTER THROWING ------------");
		log.info("target : "+jp.getTarget());
		log.info("name : "+jp.getSignature().getName());
		log.warn("error : "+exception.getMessage());
		log.info("----------- END AFTER THROWING ------------");
	}
	
}
























