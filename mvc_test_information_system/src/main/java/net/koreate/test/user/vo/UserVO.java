package net.koreate.test.user.vo;

import java.sql.Timestamp;

import lombok.Data;
@Data
public class UserVO {
	
	String userid;
	String userpw;
	String username;
	String email;
	Timestamp regdate;
	Timestamp updatedate; 
	
}
