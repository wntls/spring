package net.koreate.mvc.common.util;

import lombok.Getter;
import lombok.ToString;

// 게시물 페이징 전용 클래스
@Getter
@ToString
public class Criteria {
	
	private int page;		// 현재 페이지
	private int perPageNum; // 한 페이지에 보여줄 게시글의 개수
	
	public Criteria() {
		this(1,10);
	}
	
	public Criteria(int page, int perPageNum) {
		this.page = page;
		this.perPageNum = perPageNum;
	}

	public void setPage(int page) {
		if(page <= 0) {
			this.page = 1;
			return;
		}
		this.page = page;
	}

	public void setPerPageNum(int perPageNum) {
		if(perPageNum <= 0 || perPageNum > 50) {
			this.perPageNum = 10;
			return;
		}
		this.perPageNum = perPageNum;
	}
	
	public int getPageStart() {
		return (this.page-1)*perPageNum;
	}

}
