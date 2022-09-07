package net.koreate.board.util;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;

import net.koreate.board.dao.BoardDAO;

public class Calculator {
	
	@Inject
	BoardDAO dao;
	
	public Calculator() {
		System.out.println("Calculator 생성");
		System.out.println(dao);
	}
	
	public int minus(int a, int b) {
		return a - b;
	}
	
	@PostConstruct
	public void init() {
		System.out.println("객체 생성 후 생성");
		// 의존성 주입이 완료되고 bean 사용 준비가 완료 되면 호출
		System.out.println(dao);
	}
	
	@PreDestroy
	public void destroy() {
		System.out.println("Calculator destroy");
	}
}
