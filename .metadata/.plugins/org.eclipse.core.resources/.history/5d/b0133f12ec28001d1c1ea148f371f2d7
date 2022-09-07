package com.koreate.betty.domain.board.dao;

import java.util.List;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import com.koreate.betty.domain.board.provider.FreeBoardCommentProvider;
import com.koreate.betty.domain.board.vo.FreeBoard;
import com.koreate.betty.domain.board.vo.FreeBoardComment;
import com.koreate.betty.global.util.Criteria;

@Mapper
public interface FreeBoardCommentRepository {
	
	// 댓글 등록
	@InsertProvider(type=FreeBoardCommentProvider.class, method="commentAdd")
	//@Options(useGeneratedKeys = true , keyProperty = "cno")
	public int commentAdd(FreeBoardComment cvo);

	// 대댓글 등록
	@InsertProvider(type=FreeBoardCommentProvider.class, method="commentAdd")
	//@Options(useGeneratedKeys = true , keyProperty = "cno")
	public int commentReply(FreeBoardComment cvo);	
	
	// 댓글 삭제
	@UpdateProvider(type=FreeBoardCommentProvider.class, method="removeComment")
	public int removeComment(@Param("loginUser") String loginUser, @Param("cno") int cno);
	
	// 업데이트 오리진
	@UpdateProvider(type=FreeBoardCommentProvider.class, method="updateOrigin")
	public int updateOrigin();

	// 댓글 목록 출력 WHERE free_bno = bno
	@SelectProvider(type=FreeBoardCommentProvider.class, method = "commentList")
	public List<FreeBoardComment> commentList(@Param("cri") Criteria cri, @Param("bno") int bno);
	
	// 댓글 전체 개수
	@SelectProvider(type=FreeBoardCommentProvider.class, method = "totalCount")
	public int totalCount(int bno);
	
}
