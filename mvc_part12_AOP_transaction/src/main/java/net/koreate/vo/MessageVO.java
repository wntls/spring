package net.koreate.vo;

import java.util.Date;

import lombok.Data;

@Data
public class MessageVO {
	
	private int mno;
	private String targetid;
	private String sender;
	private String message;
	private Date opnedate;
	private Date senddate;
	
}
