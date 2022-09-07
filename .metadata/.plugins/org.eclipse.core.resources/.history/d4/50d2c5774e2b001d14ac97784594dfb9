package com.koreate.betty.domain.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.koreate.betty.domain.board.dto.FreeBoardCommentDto;
import com.koreate.betty.domain.board.dto.form.FreeBoardForm;
import com.koreate.betty.domain.board.service.FreeBoardService;
import com.koreate.betty.domain.board.vo.FreeBoard;
import com.koreate.betty.domain.board.vo.FreeBoardComment;
import com.koreate.betty.domain.member.service.MemberService;
import com.koreate.betty.domain.member.vo.Member;
import com.koreate.betty.global.util.PageMaker;
import com.koreate.betty.global.util.SearchCriteria;
import com.koreate.betty.global.util.SearchPageMaker;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/boards/free")
public class FreeBoardController {

	@Autowired
	FreeBoardService freeBoardService;
	@Autowired
	MemberService memberService;
	
	@GetMapping
	public String freeBoardList(SearchCriteria cri, Model model) {
		List<FreeBoard> list = freeBoardService.freeList(cri);
		PageMaker pm = freeBoardService.getPageMaker(cri);
		log.info("cri page = {}",cri.getPage());
		model.addAttribute("list",list);
		model.addAttribute("pm",pm);
		return "board/free/free-board";
	}
	
	@GetMapping("new")
	public String freeBoardNew() {
		return "board/free/free-new";
	}
	
	@GetMapping("modifyPage")
	public String freeBoardEdit(Model model, int bno) {
		model.addAttribute("board",freeBoardService.detail(bno));
		return "board/free/free-edit";
	}
	
	
	@PostMapping("modifyPage")
	public String freeBoardEdit(FreeBoardForm form, RedirectAttributes rttr) {
		freeBoardService.update(form);
		rttr.addAttribute("bno",form.getBno());
		return "redirect:/board/free/free-detail";
	}
	
	
	@PostMapping("remove")
	public String remove(int bno) {
		freeBoardService.remove(bno);
		return "redirect:/boards/free";
	}
	
	
	@GetMapping("{bno}")
	public String freeBoardDetail(@PathVariable Integer bno, @ModelAttribute("cri") SearchCriteria cri, Model model) {
		FreeBoard board =  freeBoardService.detail(bno);
		model.addAttribute("board", board);
		log.info("cri = {}", cri);
		log.info("prev cri page = {}",cri.getPage());
		PageMaker pm = new SearchPageMaker();
		pm.setCri(cri);
		model.addAttribute("pm",pm);
		Member member = memberService.findOne(board.getMemberId());
		freeBoardService.updateCnt(bno);
		String img = member.getImg();
		model.addAttribute("img",img);
		log.info("post cri page = {}",cri.getPage());
		return "board/free/free-detail";
	}
	
}
