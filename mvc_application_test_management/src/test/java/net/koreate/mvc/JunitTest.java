package net.koreate.mvc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import lombok.extern.slf4j.Slf4j;
import net.koreate.mvc.board.dao.BoardDAO;
import net.koreate.mvc.board.vo.BoardVO;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:context/*.xml"})
@WebAppConfiguration
public class JunitTest {
	
	@Autowired
	BoardDAO dao;
	
	
	//@Test
	public void daoRead () throws Exception {
		BoardVO vo = dao.read(1);
		System.out.println(vo);
	}
	
	@Test
	public void daoCreate () throws Exception {
		BoardVO vo = new BoardVO();
		vo.setTitle("제목제목제목");
		vo.setContent("내용내용내용");
		vo.setWriter("작성자박주신");
		dao.create(vo);
		System.out.println(vo);
	}
	
	
	//@Test
	public void daolistCount () throws Exception {
		int Count = dao.listCount();
		System.out.println("listCount : "+Count);
	}
	
	
}
