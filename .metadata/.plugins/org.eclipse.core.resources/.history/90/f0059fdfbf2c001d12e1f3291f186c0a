package com.koreate.betty.domain.board.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.koreate.betty.domain.board.dto.FreeBoardCommentDto;
import com.koreate.betty.domain.board.dto.form.FreeBoardCommentForm;
import com.koreate.betty.domain.board.service.FreeBoardService;
import com.koreate.betty.domain.board.service.FreeCommentService;
import com.koreate.betty.global.util.Criteria;
import com.koreate.betty.global.util.PageMaker;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class FreeBoardCommentApiController {
	
	@Autowired
	FreeCommentService freeCommentService;
	
	@Autowired
	FreeBoardService freeBoardService;
	
	@GetMapping("boards/free/{bno}/{page}comments")
	public Map<String, Object> controllerLoadTest(@PathVariable(name = "bno") Integer bno, @PathVariable(name = "page") int page) {
		log.info("api called complete");
		Criteria cri = new Criteria(page,5);
		PageMaker pm = freeCommentService.getPageMaker(cri, bno);
		Map<String, Object> map = new HashMap<>();
		map.put("list", freeCommentService.list(pm.getCri(), bno));
		//map.put("page",freeBoardService.detail(bno));
		map.put("pm", pm);
		return map;
	} 
	
	@PostMapping("boards/free/{bno}/comments")
	public String commentAdd(FreeBoardCommentForm form) {
		System.out.println("ㅎㅇ");
		int add = freeCommentService.add(form, form.getFreeBno());
		
		return add == 1 ? "성공" : "실패";
	}
	
	/*
	@PostMapping("boards/free/{bno}/com")
	public String commentReply(FreeBoardCommentForm form) {
		System.out.println("ㅎㅇ");
		int add = freeCommentService.reply(form, form.getFreeBno());
		
		return add == 1 ? "성공" : "실패";
	}
	*/
	
	@DeleteMapping("boards/free/comments/{cno}")
	public int remove(@PathVariable Integer cno, Model model) {
		FreeBoardCommentDto dto = new FreeBoardCommentDto(); 
		model.addAttribute("cm",dto.getCno());
		return freeCommentService.remove(cno);
	}
	
}











