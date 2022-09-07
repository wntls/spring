package com.koreate.betty.domain.board.provider;

import org.apache.ibatis.jdbc.SQL;

import com.koreate.betty.domain.board.vo.FreeBoard;
import com.koreate.betty.global.util.SearchCriteria;

import static com.koreate.betty.domain.model.TableConst.*;

public class FreeBoardProvider {

	// 자유게시판 등록
	public String save(FreeBoard board) {
		return new SQL()
				.INSERT_INTO(FREE_BOARD_TBL)
				.INTO_COLUMNS("member_id", "tag", "title", "content")
				.INTO_VALUES("#{memberId},#{tag},#{title},#{content}")
				.toString();
	}
	
	// 게시물 상세
	public String detail(int bno) {
		return new SQL()
				.SELECT("*")
				.FROM(FREE_BOARD_TBL)
				.WHERE("bno = #{bno}")
				.toString();
	}

	// 자유게시판 삭제 요청
	public String freeRemove(int bno) {
		return new SQL()
				.UPDATE(FREE_BOARD_TBL)
				.SET("showboard = 'n'")
				.WHERE("bno = #{bno}")
				.toString();
	}

	// 자유게시판 수정 요청
	public String freeUpdate(FreeBoard board) {
		return new SQL().UPDATE(FREE_BOARD_TBL)
				.SET("title = #{title}, content = #{content}, tag = #{tag}")
				.WHERE("bno = #{bno}")
				.toString();
	}

	// 자유게시판 목록 요청
	public String freeList(SearchCriteria cri) {
		SQL sql = new SQL();
		sql.SELECT("*");
		sql.FROM(FREE_BOARD_TBL);
		getSearchWhere(cri, sql);
		sql.ORDER_BY("bno DESC");
		sql.OFFSET(cri.getStartRow());
		sql.LIMIT(cri.getPerPageNum());
		return sql.toString();
	}
	
	// 전체 게시물 개수
	public String listAllCount(SearchCriteria cri) {
		SQL sql = new SQL().SELECT("count(*)");
		sql.FROM(FREE_BOARD_TBL);
		getSearchWhere(cri, sql);
		return sql.toString();
	}
	
	// 조회수 증가
	public String updateCnt(int bno) {
		return new SQL()
				.UPDATE(FREE_BOARD_TBL)
				.SET("viewcnt = viewcnt + 1")
				.WHERE("bno = #{bno}")
				.toString();
	}
	
	// 검색
	private void getSearchWhere(SearchCriteria cri, SQL sql) {
		String titleQuery = "title LIKE CONCAT('%','"+cri.getKeyword()+"','%')";
		String contentQuery = "content LIKE CONCAT('%',#{keyword},'%')";
		String writerQuery = "member_id LIKE CONCAT('%',#{keyword},'%')";
		if(cri.getSearchType() != null && !cri.getSearchType().trim().equals("")
				&& !cri.getSearchType().trim().equals("n")) {
			if(cri.getSearchType().contains("t")) {
				sql.OR().WHERE(titleQuery);
			}
			if(cri.getSearchType().contains("c")) {
				sql.OR().WHERE(contentQuery);
			}
			if(cri.getSearchType().contains("w")) {
				sql.OR().WHERE(writerQuery);
			}
		}
	}

}














