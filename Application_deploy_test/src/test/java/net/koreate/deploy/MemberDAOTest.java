package net.koreate.deploy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import net.koreate.deploy.member.dao.MemberDAO;
import net.koreate.deploy.member.model.MemberVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/spring/root-context.xml", 
		"classpath:/spring/appServlet/servlet-context.xml"})
@WebAppConfiguration
public class MemberDAOTest {
	
	@Autowired
	private MemberDAO dao;
	
	
	@Test
	public void testDAORead() {
		MemberVO vo = new MemberVO();
		vo.setId("admin");
		vo.setPass("admin");
		MemberVO m = dao.read(vo);
		System.out.println(m);
	}
	
}
