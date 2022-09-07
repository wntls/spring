package net.koreate.se;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import net.koreate.sec.dao.MemberDAO;
import net.koreate.sec.vo.ValidationMemberVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:root/root-context.xml","classpath:security/security-context.xml"})
public class MemberTest {
	
	@Autowired
	MemberDAO dao;
	
	@Autowired
	PasswordEncoder encoder;
	
	@Test
	public void passwordEncoder() throws Exception{
		String u_pw = "qkrwntls1!";
		String encode = encoder.encode(u_pw);
		System.out.println("암호화 전 : "+u_pw);
		// 암호화 후 : $2a$10$TS2qcMdvA/DgjPLcFi/mse2oFd8fbSkZBL0T8zldFnQrMInzvO49a
		// 암호화 후 : $2a$10$glxzwYZpTOewhvQ3sX61IuboaaWTYSNbhdXeEfRJHH1b49tMFP0K2
		System.out.println("암호화 후 : "+encode);
		System.out.println(encode.equals("$2a$10$TS2qcMdvA/DgjPLcFi/mse2oFd8fbSkZBL0T8zldFnQrMInzvO49a"));
		System.out.println(encoder.matches("qkrwntls1!", "$2a$10$glxzwYZpTOewhvQ3sX61IuboaaWTYSNbhdXeEfRJHH1b49tMFP0K2"));
		
		ValidationMemberVO vo = new ValidationMemberVO();
		vo.setU_id("wn@tls.com");
		vo.setU_pw(encode);
		vo.setU_name("박주신");
		vo.setU_phone("01011111111");
		vo.setU_birth("19960803");
		vo.setU_post("58763");
		vo.setU_addr("부산광역시 동래구 충렬대로 84");
		vo.setU_addr_detail("영남빌딩 9층");
		dao.memberJoin(vo);
		System.out.println("삽입 완료");
		
	}

}










