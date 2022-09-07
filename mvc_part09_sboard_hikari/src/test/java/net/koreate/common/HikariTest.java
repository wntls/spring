package net.koreate.common;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import net.koreate.common.utils.SearchCriteria;
import net.koreate.sboard.dao.SearchBoardDAO;
import net.koreate.sboard.vo.SearchBoardVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/context/root-context.xml"})
public class HikariTest {
	
	@Inject
	DataSource ds;
	
	@Test
	public void hikariTest() throws SQLException {
		System.out.println(ds);
		Connection conn = ds.getConnection();
		System.out.println("연결 완료 : "+ conn);
		conn.close();
	}
	
	@Inject
	SearchBoardDAO dao;
	
	//@Test
	public void test3()throws Exception{
		SearchBoardVO vo = new SearchBoardVO();
		vo.setTitle("테스트 제목");
		vo.setContent("테스트 내용");
		vo.setWriter("박주신");
		int result = dao.create(vo);
		System.out.println("result : "+ result);
	}
	
	@Test
	public void searchListTest() throws Exception{
		SearchCriteria cri = new SearchCriteria(1,20,"title","게시물");
		System.out.println(cri);
		List<SearchBoardVO> list = dao.searchList(cri);
		for(SearchBoardVO b : list) {
			System.out.println(b);
		}
	} 
	
}
















