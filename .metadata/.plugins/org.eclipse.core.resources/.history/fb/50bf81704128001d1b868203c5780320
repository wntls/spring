package com.koreate.betty.domain.board.provider;

import static com.koreate.betty.domain.model.TableConst.FREE_COMMENT_TBL;

import static com.koreate.betty.domain.model.SessionConst.USER;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

import com.koreate.betty.domain.board.vo.FreeBoardComment;
import com.koreate.betty.global.util.Criteria;

public class FreeBoardCommentProvider {
	
	// 댓글 작성
	public String commentAdd(FreeBoardComment cvo) {
		SQL sql = new SQL();
		sql.INSERT_INTO(FREE_COMMENT_TBL);
		sql.INTO_COLUMNS("free_bno, comment");
		if(cvo.getOrigin() != null && cvo.getOrigin() != 0) {
			sql.INTO_COLUMNS("origin");
		}
		sql.INTO_COLUMNS("member_id");
		sql.INTO_VALUES("#{freeBno}, #{comment}");
		if(cvo.getOrigin() != null && cvo.getOrigin() != 0) {
			sql.INTO_VALUES("#{origin}");
		}
		sql.INTO_VALUES("#{memberId}");
		return sql.toString();
	}
	
	// 댓글 수정
	public String commentModify(@Param("loginUser") String loginUser, @Param("cvo") FreeBoardComment cvo) {
		return new SQL().UPDATE(FREE_COMMENT_TBL)
				.SET("comment = #{cvo.comment}")
				.WHERE("cno = #{cvo.cno}")
				.AND().WHERE("member_id = #{loginUser}")
				.toString();
	}
	
	// origin column 값 수정
	public String updateOrigin() {
		return new SQL().UPDATE(FREE_COMMENT_TBL)
				.SET("origin = LAST_INSERT_ID()")
				.WHERE("cno = LAST_INSERT_ID()")
				.toString();
	}
	
	
	// 댓글 삭제
	public String removeComment(@Param("loginUser") String loginUser, @Param("cno") int cno) {
		return new SQL().UPDATE(FREE_COMMENT_TBL)
				.SET("showboard = 'n'")
				.WHERE("cno = #{cno}")
				.AND().WHERE("member_id = #{loginUser}")
				.toString();
	}
	
	// 댓글 목록
	public String commentList(@Param("cri") Criteria cri, @Param("bno") int bno) {
		return new SQL()
				.SELECT("*")
				.FROM(FREE_COMMENT_TBL)
				.WHERE("free_bno = #{bno}")
				.ORDER_BY("origin ASC")
				.OFFSET(cri.getStartRow())
				.LIMIT(cri.getPerPageNum())
				.toString();
	}
	
	// 댓글 전체 개수
	public String totalCount(int bno) {
		return new SQL()
				.SELECT("count(*)")
				.FROM(FREE_COMMENT_TBL)
				.WHERE("free_bno = #{bno}")
				.toString();
	}
}






