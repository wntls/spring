package com.koreate.betty.domain.board.service;

import java.lang.reflect.Member;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koreate.betty.domain.board.dao.FreeBoardRepository;
import com.koreate.betty.domain.board.dto.FreeBoardDto;
import com.koreate.betty.domain.board.dto.form.FreeBoardForm;
import com.koreate.betty.domain.board.vo.FreeBoard;
import com.koreate.betty.domain.member.dao.MemberRepository;
import com.koreate.betty.global.util.PageMaker;
import com.koreate.betty.global.util.SearchCriteria;
import com.koreate.betty.global.util.SearchPageMaker;

@Service
public class FreeBoardService {
	
	@Autowired
	FreeBoardRepository freeBoardRepository;
	
	// 게시글 등록
	public int write(FreeBoardForm form) {
		FreeBoard board = form.createFreeBoard();
		freeBoardRepository.save(board);
		return board.getBno();
	}
	
	// 게시글 삭제
	public int remove(int bno) {
		return freeBoardRepository.freeRemove(bno);
	}
	
	// 게시글 수정
	public int update(FreeBoardForm form) {
		FreeBoard board = form.createFreeBoard();
		return freeBoardRepository.freeUpdate(board);
	}
	
	// 게시글 전체 목록
	public List<FreeBoard> freeList(SearchCriteria cri) {
		return freeBoardRepository.listAll(cri);
	}
	
	// 조회수 증가
	public int updateCnt(int bno) {
		return freeBoardRepository.updateCnt(bno);
	}
	
	@Autowired
	MemberRepository memberRepository;
	
	// 게시글 상세
	public FreeBoard detail(int bno) {
		return freeBoardRepository.freeDetail(bno);
	}
	
	// 페이징 처리
	public PageMaker getPageMaker(SearchCriteria cri) {
		int totalCount = freeBoardRepository.listAllCount(cri);
		PageMaker pm = new SearchPageMaker();
		pm.setCri(cri);
		pm.setDisplayPageNum(5);
		pm.setTotalCount(totalCount);
		return pm;
	}
	
	
}
