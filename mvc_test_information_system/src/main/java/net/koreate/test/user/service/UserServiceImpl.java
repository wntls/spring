package net.koreate.test.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.koreate.test.user.dao.UserDAO;
import net.koreate.test.user.vo.UserVO;
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDAO dao;
	
	@Override
	public void join(UserVO vo) throws Exception {
		dao.join(vo);
	}

	@Override
	public UserVO login(UserVO vo) throws Exception {
		return dao.login(vo);
	}

}
