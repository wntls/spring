package net.koreate.comment;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import net.koreate.comment.dao.CommentDAO;
import net.koreate.comment.vo.CommentDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/spring/root-context.xml"})
public class MybatisTest {
	
	@Inject
	SqlSessionFactory sqlSessionFactory;
	
	@Test
	public void testSqlSessionFactory() {
		SqlSession session = sqlSessionFactory.openSession();
		System.out.println(session.getConnection());
	}
	
	@Autowired
	CommentDAO dao;
	
	@Test
	public void test2Comment() throws Exception{
		CommentDTO dto = new CommentDTO();
		dto.setBno(20);
		dto.setCommentAuth("박주신");
		dto.setCommentText("1등");
		int result = dao.add(dto);
		System.out.println(result);
	}
}




















