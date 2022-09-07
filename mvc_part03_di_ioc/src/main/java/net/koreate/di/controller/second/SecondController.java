package net.koreate.di.controller.second;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import net.koreate.di.dao.TestDAO;
import net.koreate.di.service.TestService;

@Controller
public class SecondController {
	
	@Autowired(required=false)
	TestService ts;
	
	@Inject
	@Named("testDAOImpl")
	TestDAO dao;
	
	// /WEB-INF/view/main.jsp
	@RequestMapping("main")
	public void doMain() {
		System.out.println("second doMain 호출");
		if(dao != null) {
			dao.select("second controller");
		}else {
			System.out.println("dao null");
		}
		
		if(ts != null) {
			ts.testService("second controller");
		}else {
			System.out.println("second controller ts is null");
		}
	}
}























