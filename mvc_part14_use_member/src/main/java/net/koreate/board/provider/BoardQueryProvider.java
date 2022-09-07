package net.koreate.board.provider;

import org.apache.ibatis.jdbc.SQL;

import net.koreate.board.vo.BoardVO;
import net.koreate.common.utils.SearchCriteria;

public class BoardQueryProvider {
	
	public String deleteAttach(int bno) {
		SQL sql = new SQL();
		sql.DELETE_FROM("tbl_attach");
		sql.WHERE("bno = #{bno}");
		return sql.toString();
	}
	
	
	
	// showboard = 'n' update
	public String remove(int bno) {
		return new SQL().UPDATE("re_tbl_board")
						.SET("showboard = 'n'")
						.WHERE("bno = #{bno}")
						.toString();
	}
	
	public String register(BoardVO board) {
		// 원본글 등록 != 답변글 등록
		SQL sql = new SQL();
		sql.INSERT_INTO("re_tbl_board");
		sql.INTO_COLUMNS("title,content");
		if(board.getOrigin() != 0) {
			sql.INTO_COLUMNS("origin,depth,seq");
		}
		sql.INTO_COLUMNS("uno");
		sql.INTO_VALUES("#{title},#{content}");
		if(board.getOrigin() != 0) {
			sql.INTO_VALUES("#{origin},#{depth},#{seq}");
		}
		sql.INTO_VALUES("#{uno}");
		String query = sql.toString();
		System.out.println(query);
		return query;
	}
	
	public String searchSelectSql(SearchCriteria cri) throws Exception{
		SQL sql = new SQL();
		sql.SELECT("R.*, U.uname AS writer");
		sql.FROM("re_tbl_board AS R NATURAL JOIN tbl_user AS U");
		getSearchWhere(cri, sql);
		sql.ORDER_BY("R.origin DESC, R.seq ASC");
		sql.LIMIT(cri.getPerPageNum());
		sql.OFFSET(cri.getStartRow());
		String query = sql.toString();
		System.out.println(query);
		return query;
	}
	
	public String searchSelectCount(SearchCriteria cri) {
		SQL sql = new SQL();
		sql.SELECT("count(*)");
		sql.FROM("re_tbl_board AS R NATURAL JOIN tbl_user AS U");
		getSearchWhere(cri, sql);
		String query = sql.toString();
		System.out.println(query);
		return query;
	}
	
	
	private void getSearchWhere(SearchCriteria cri, SQL sql) {
		String titleQuery = "title LIKE CONCAT('%','"+cri.getKeyword()+"','%')";
		String contentQuery = "content LIKE CONCAT('%',#{keyword},'%')";
		String writerQuery = "U.uname LIKE CONCAT('%',#{keyword},'%')";
		
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



























