package net.koreate.board.vo;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class BoardVO {
	
	private int bno;
	private String title;
	private String content;
	private int origin;
	private int depth;
	private int seq;
	private Date regdate;
	private Date updatedate;
	private int viewcnt;
	private String showboard;
	private int uno;
	private String writer;
	
	// 첨부파일 목록
	private List<String> files;
	
}
