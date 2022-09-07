package net.koreate.lombok;

import java.util.Date;
import java.util.List;

import javax.jws.Oneway;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.Singular;
import lombok.ToString;

// @Data
@Getter
@Setter
//@ToString(exclude = "upw")
@ToString(of = {"uno","uname","friendList"})
//@EqualsAndHashCode(of = {"uid","upw"})
@EqualsAndHashCode(exclude = {"uno","regdate","uname","friendList"})
//@NoArgsConstructor
@AllArgsConstructor
//@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
//@RequiredArgsConstructor(access = AccessLevel.PUBLIC)
//@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
@Builder
public class UserVO {
	@Getter
	private int uno;
	@NonNull @Setter
	private String uid;
	@NonNull
	private String upw;
	private final String uname;
	private Date regdate;
	
	@Singular("list")
	private List<String> friendList;
	
	
	
	
	
	
	
	
	
	
}
