package net.koreate.test.user.service;

import net.koreate.test.user.vo.UserVO;

public interface UserService {
	
	
		void join(UserVO vo) throws Exception;
		
		
		UserVO login(UserVO vo) throws Exception;

}
