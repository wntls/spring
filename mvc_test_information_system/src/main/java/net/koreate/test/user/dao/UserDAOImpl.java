package net.koreate.test.user.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import net.koreate.test.user.vo.UserVO;

public class UserDAOImpl implements UserDAO {

	public static String namespace = "net.koreate.test.user.dao.UserDAO";
	
	private SqlSession session;
	
	@Override
	public void join(UserVO vo) throws Exception {
		session.insert(namespace+".join",vo);
	}

	@Override
	public UserVO login(UserVO vo) throws Exception {
		return session.selectOne(namespace+".login",vo);
	}

}
