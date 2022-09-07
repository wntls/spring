package net.koreate.common;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import net.koreate.sboard.controller.SearchBoardController;
import net.koreate.sboard.dao.SearchBoardDAO;
import net.koreate.sboard.service.SearchBoardService;
import net.koreate.sboard.service.SearchBoardServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/root-context.xml"})
public class TestResources {
	
	@Autowired
	SearchBoardDAO dao;
	
	@Test
	public void test() throws Exception {
		System.out.println(dao);
		SearchBoardService sbs = new SearchBoardServiceImpl(dao);
		SearchBoardController sbc = new SearchBoardController(sbs);
		String register = sbc.register();
		System.out.println(register);
	}
	
}






















