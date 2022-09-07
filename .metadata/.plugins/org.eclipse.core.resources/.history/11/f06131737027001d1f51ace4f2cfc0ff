package com.koreate.betty.domain.member.dto.form;

import java.sql.Timestamp;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.koreate.betty.domain.member.vo.Member;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignUpForm {
	
	@NotBlank
	String id;
	
	@NotBlank
	String pw;
	
	@NotBlank
	String repw;
	
	@NotBlank
	String nickname;
	
	@NotBlank
	String name;
	
	@NotBlank
	String gender;
	
	@NotBlank
	String birth;
	
	@NotBlank
	String addr;
	
	@NotBlank
	String phone;
	
	@NotBlank
	String email;
	
	@NotNull
	Integer rights;
		
		public Member convertToMember(){
			return new Member()
					.builder()
					.id(id)
					.pw(pw)
					.nickname(nickname)
					.name(name)
					.gender(gender)
					.birth(Timestamp.valueOf(birth))
					.phone(phone)
					.addr(addr)
					.email(email)
					.rights(rights)
					.build();
		}
		
		
}