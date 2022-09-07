package net.koreate.test.user.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import net.koreate.test.user.vo.UserVO;

public interface UserDAO {
	
	
	@Insert("INSERT INTO test_member(userid,userpw,username,email) \r\n" + 
			"		VALUES(#{userid},#{userpw},#{username},#{email})")
	void join(UserVO vo) throws Exception;	
	
	@Select("SELECT * FROM test_member \r\n" + 
			"		WHERE userid = #{userid} AND userpw = #{userpw}")
	UserVO login(UserVO vo) throws Exception;
}
