package com.koreate.betty.domain.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koreate.betty.domain.board.dao.FreeBoardCommentRepository;
import com.koreate.betty.domain.board.dto.form.FreeBoardCommentForm;
import com.koreate.betty.domain.board.vo.FreeBoard;
import com.koreate.betty.domain.board.vo.FreeBoardComment;
import com.koreate.betty.global.util.Criteria;
import com.koreate.betty.global.util.PageMaker;
import com.koreate.betty.global.util.SearchCriteria;
import com.koreate.betty.global.util.SearchPageMaker;

@Service
public class FreeCommentService {
	
	@Autowired
	FreeBoardCommentRepository dao;
	
	// 댓글 등록
	public int add(FreeBoardCommentForm form, int bno) {
		FreeBoardComment vo = form.freeBoardComment();
		System.out.println(vo.getComment());
		int result = dao.commentAdd(vo, bno);
		dao.updateOrigin();
		return result;
	}
	
	// 대댓글
	public int reply(FreeBoardCommentForm form, int bno) {
		FreeBoardComment vo = form.freeBoardComment();
		return dao.commentReply(vo, bno);
	}
	
	// 댓글 삭제
	public int remove(int cno) {
		return dao.removeComment(cno);	
	}
	
	// 오리진 업데이트
	/*
	public int updateOrigin() {
		return dao.updateOrigin();
	}*/
	
	// 댓글 목록 출력
	public List<FreeBoardComment> list(Criteria cri, int bno){
		return dao.commentList(cri, bno);
	}
	
	// 페이징 처리
	public PageMaker getPageMaker(Criteria cri, int bno) {
		int totalCount = dao.totalCount(bno);
		PageMaker pm = new PageMaker();
		pm.setCri(cri);
		pm.setDisplayPageNum(5);
		pm.setTotalCount(totalCount);
		return pm;
	}
	
	
}
