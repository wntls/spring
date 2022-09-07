package net.koreate.di.controller.home;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.koreate.di.dao.TestDAO;
import net.koreate.di.service.TestService;
import net.koreate.di.vo.TestBoardVO;

/**
 * 		DI Annotation
 * 		@Autowired		@Qualifier		@Inject		@Resource
 *범용성  	스프링 전용			스프링 전용			자바에서 지원	자바에서 지원
 *연결성	타입에 맞춰서 주입	특정 객체의 		    타입에 맞춰서 주입	이름으로 주입	
 *						name을 이용해서 주입
 *						독립적인 사용 X	
 */						

@Controller
public class HomeController {
	
	
	@Autowired
	TestService tsi; // = new TestServiceImpl();
	
	@Inject
	@Named("td")
	TestDAO dao;
	
	@Resource(name="path")
	String path;
	
	@Autowired
	@Qualifier("profile")
	String profile1;
	
	@Autowired
	TestBoardVO vo;
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		if(tsi != null) {
			tsi.testService("Home Controller");
		}else {
			System.out.println("home tsi is null");
		}
		
		if(dao != null) {
			dao.select("homeController");
		}else {
			System.out.println("home dao null");
		}
		System.out.println("path : "+path);
		System.out.println("profile : "+profile1);
		System.out.println(vo);
		return "home";
	}
	
}

















