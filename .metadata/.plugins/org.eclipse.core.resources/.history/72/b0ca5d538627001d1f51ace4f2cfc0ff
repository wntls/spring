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

import com.koreate.betty.domain.board.dao.FreeBoardRepository;
import com.koreate.betty.domain.board.dto.form.FreeBoardForm;
import com.koreate.betty.domain.board.service.FreeBoardService;
import com.koreate.betty.domain.board.vo.FreeBoard;
import com.koreate.betty.global.config.AppConfig;
import com.koreate.betty.global.config.RootConfig;
import com.koreate.betty.global.config.WebConfig;
import com.koreate.betty.global.util.SearchCriteria;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@WebAppConfiguration
@ContextConfiguration(classes = { WebConfig.class, AppConfig.class, RootConfig.class })
@RunWith(SpringJUnit4ClassRunner.class)
//@Transactional
public class FreeBoardRepoTest {

	@Autowired private WebApplicationContext wc;
	
	@Autowired private FreeBoardService freeBoardService;
	
	FreeBoardForm form1;
	FreeBoardForm form2;
	FreeBoardForm form3;
	FreeBoardForm ex;
	
	FreeBoardForm formR1;
	FreeBoardForm formR2;
	FreeBoardForm formR3;
	
	FreeBoardForm formU1;
	FreeBoardForm formU2;
	FreeBoardForm formU3;
	
	@Autowired
	private FreeBoardRepository freeBoardRepository;
	
	private SearchCriteria cri;
	
	@Before
	public void init_data() {
		
		form1 = new FreeBoardForm();
		form1.setMemberId("id001");
		form1.setTag("태그태그");
		form1.setTitle("제목제목");
		form1.setContent("내용내용");
		
		form2 = new FreeBoardForm();
		form2.setMemberId("id002");
		form2.setTag("질문");
		form2.setTitle("제목 002");
		form2.setContent("내용 002");
		
		form3 = new FreeBoardForm();
		form3.setMemberId("id003");
		form3.setTag("일상");
		form3.setTitle("제목 003");
		form3.setContent("내용 003");
		form3.setMemberId("id003");
		form3.setTag("일상");
		form3.setTitle("제목 003");
		form3.setContent("내용 003");
		form3.setMemberId("id003");
		form3.setTag("일상");
		form3.setTitle("제목 003");
		form3.setContent("내용 003");
		
		ex = new FreeBoardForm();
		ex.setMemberId("none");
		ex.setTag("tag");
		ex.setTitle("title");
		ex.setContent("content");
		
		formR1 = new FreeBoardForm();
		formR1.setBno(6);
		formR2 = new FreeBoardForm();
		formR2.setBno(7);
		formR2.getTag();
		formR2.getTitle();
		formR2.getContent();
		formR3 = new FreeBoardForm();
		formR3.setBno(8);
		
		formU1 = new FreeBoardForm();
		formU1.setBno(3);
		formU1.setTag("수정");
		formU1.setTitle("수정");
		formU1.setContent("수정");
		
		formU2 = new FreeBoardForm();
		formU2.setBno(5);
		formU2.setTag("바꿈");
		formU2.setTitle("바꿈");
		formU2.setContent("바꿈");
		
		formU3 = new FreeBoardForm();
		formU3.setBno(5);
		formU3.setTag("ㅇㄴㅇ");
		formU3.setTitle("ㅁㅇㅁㄴㅇ");
		formU3.setContent("ㅁㄴㅇㄻㄴㅇ");
		
		cri = new SearchCriteria();
		cri.setPerPageNum(5);
		cri.setSearchType("");
		cri.setKeyword("");
	}
	
	//@Test
	public void 컨텍스트_로드() throws InterruptedException {
		Thread.sleep(5000);
		log.info("complete");
	}
	
	//@Test
	public void DAO_SAVE_AND_USE_GENERATED_KEY() {
		
		int first = freeBoardService.write(form1);
		int second = freeBoardService.write(form2);
		int third = freeBoardService.write(form3);
		
		log.info("first={}, second={}, third={}",first,second,third);
	}
	
	
	//@Test
	public void removeTest() {
		int first = freeBoardService.remove(1);
		int second = freeBoardService.remove(2);
		int third = freeBoardService.remove(3);
		log.info("first={}, second={}, third={}",first,second,third);
	}
	
		//@Test
		public void updateTest() {
			//FreeBoard first = freeBoardService.update(1);
			//FreeBoard second = freeBoardService.update(2);
			//FreeBoard third = freeBoardService.update(3);
			//log.info("first={}, second={}, third={}",first,second,third);
		}
	
	@Test	
	public void listTest() {
		List<FreeBoard> list = freeBoardService.freeList(cri);
		log.info("list : "+ list.size());
		FreeBoard board = list.get(1);
		log.info(board.getTitle());
	}
	
	//@Test
	@Transactional
	public void 통합테스트() {
		// save
		int save = freeBoardService.write(form1);
		log.info("save={}",save);
		// find 게시물 상세 
		FreeBoard find = freeBoardService.detail(30);
		log.info("find={}",find);
		// upCnt 조회수 증가
		int upCnt = freeBoardService.updateCnt(2);
		log.info("upCnt={}",upCnt);
		// findAll 게시물 목록
		List<FreeBoard> findAll = freeBoardService.freeList(cri);
		log.info("findAll Count ={}",findAll.size());
		findAll.stream().forEach(System.out::println);
		// update 
		int update = freeBoardService.update(formU2);
		log.info("update={}",update);
		// delete
		int delete = freeBoardService.remove(6);
		log.info("delete={}",delete);
	}
	
}
