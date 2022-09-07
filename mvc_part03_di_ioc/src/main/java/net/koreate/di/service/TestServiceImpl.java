package net.koreate.di.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import net.koreate.di.dao.TestDAO;

@Service
public class TestServiceImpl implements TestService{
	
	private TestDAO dao;
	
	@Autowired @Qualifier("td")
	public void setDao(TestDAO dao) {
		this.dao = dao;
	}

	@Override
	public void testService(String message) {
		System.out.println(message+" : test service");
		System.out.println("dao : " + dao);
	}
}
