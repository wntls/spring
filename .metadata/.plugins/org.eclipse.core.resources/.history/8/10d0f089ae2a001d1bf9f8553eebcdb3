package com.koreate.betty.domain.board.free;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import com.koreate.betty.domain.board.dto.form.FreeBoardCommentForm;
import com.koreate.betty.domain.board.dto.form.FreeBoardForm;
import com.koreate.betty.domain.board.service.FreeCommentService;
import com.koreate.betty.domain.board.vo.FreeBoard;
import com.koreate.betty.domain.board.vo.FreeBoardComment;
import com.koreate.betty.global.config.AppConfig;
import com.koreate.betty.global.config.RootConfig;
import com.koreate.betty.global.config.WebConfig;
import com.koreate.betty.global.util.Criteria;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@WebAppConfiguration
@ContextConfiguration(classes = { WebConfig.class, AppConfig.class, RootConfig.class })
@RunWith(SpringJUnit4ClassRunner.class)
public class FreeBoardCommentRepoTest {
	
	@Autowired 
	private WebApplicationContext wc;
	
	@Autowired
	private FreeCommentService fc;
	
	FreeBoardCommentForm form1;
	FreeBoardCommentForm form2;
	FreeBoardCommentForm form3;
	FreeBoardCommentForm form30;
	FreeBoardCommentForm form4;
	FreeBoardCommentForm form5;
	FreeBoardCommentForm form5_1;
	
	private Criteria cri;
	
	@Before
	public void init() {
		form1 = new FreeBoardCommentForm();
		form1.setOrigin(78);
//		form1.setDepth(1);
//		form1.setSeq(1);
		form1.setMemberId("id002");
		form1.setComment("zzzzzzzzzzz");
		
		cri = new Criteria();
		cri.setPerPageNum(50);
		
		
		
		form3 = new FreeBoardCommentForm();
		form3.setMemberId("id001");
		form3.setComment("3번글의 댓글이다");
		
		form5 = new FreeBoardCommentForm();
		form5.setMemberId("id001");
		form5.setComment("5번글의 댓글이다");
		
		form30 = new FreeBoardCommentForm();
		
		form5_1 = new FreeBoardCommentForm();
		form5_1.setOrigin(91);
		form5_1.setMemberId("id002");
		form5_1.setComment("qwqwqwqwqwqwqwqwqwq");
		
		form4 = new FreeBoardCommentForm();
		form4.setCno(48);
		form4.setComment("수정수정수정수정수정수정");
		
		form2 = new FreeBoardCommentForm();
		form2.setOrigin(102);
		form2.setMemberId("id003");
		form2.setComment("으아아아아아아아아악");
		
		
	}
	
	//@Test
	public void remove() {
		int re = fc.remove(47, "id002");
		log.info("re={}",re);
	}
	
	
	//@Test
	public void add() {
		//FreeBoard board = form5.createFreeBoard();
		int re = fc.add(form1);
		log.info("re={}",re);
	}
	
	//@Test
	public void reply() {
		//FreeBoard board = form5.createFreeBoard();
		int re = fc.reply(form1);
		log.info("re={}",re);
	}
	

	//@Test
	public void lists() {
		List<FreeBoardComment> list = fc.list(cri, 3);
		list.stream().forEach(System.out::println);
	}
	
	
	@Test
	@Transactional
	public void list() {
		List<FreeBoardComment> list = fc.list(cri, 30);
		log.info("list={}",list);
		
		//5번 참조하는 댓글
		int r5 = fc.add(form5);
		list = fc.list(cri, 5);
		System.out.println("=========5번 참조 댓글");
		list.stream().forEach(System.out::println);
		//3번 참조하는 댓글
		list = fc.list(cri, 3);
		System.out.println("=========3번 참조 댓글");
		list.stream().forEach(System.out::println);
		//5번의 댓글의 댓글
		fc.add(form5);
		fc.reply(form2);
		list = fc.list(cri, 5);
		System.out.println("=========5번 댓글의 댓글");
		list.stream().forEach(System.out::println);
		//30번 참조하는 새 댓글
		//FreeBoard board = form5.createFreeBoard();
		list = fc.list(cri, 30);
		System.out.println("=========30번 참조 새 댓글");
		list.stream().forEach(System.out::println);
		//30번의 cno 6번 댓글의 대댓글 
		list = fc.list(cri, 30);
		System.out.println("=========30번 cno번 댓글");
		list.stream().forEach(System.out::println);
		//30번 댓글 목록 출력
		list = fc.list(cri, 30);
		System.out.println("=========30번 참조 댓글");
		list.stream().forEach(System.out::println);
		//5번 댓글 목록 출력
		list = fc.list(cri, 5);
		System.out.println("=========5번 댓글 목록");
		list.stream().forEach(System.out::println);
		
		
	}
	
	
}
























