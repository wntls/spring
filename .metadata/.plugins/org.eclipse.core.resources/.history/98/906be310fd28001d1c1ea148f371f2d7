package com.koreate.betty.domain.board.dto.form;

import javax.validation.constraints.NotBlank;

import com.koreate.betty.domain.board.vo.FreeBoardComment;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FreeBoardCommentForm {
	
	private Integer cno;
	
	@NotBlank
	private Integer freeBno;
	
	@NotBlank
	private String memberId;
	
	@NotBlank
	private String comment;
	
	
	private Integer origin;
	
	
	public FreeBoardComment freeBoardComment() {
		return FreeBoardComment.builder()
				.cno(cno)
				.freeBno(freeBno)
				.memberId(memberId)
				.comment(comment)
				.origin(origin)
				.build();
	}
	
}








