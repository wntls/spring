package net.koreate.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import net.koreate.dao.MessageDAO;
import net.koreate.dao.UserDAO;
import net.koreate.vo.MessageVO;
import net.koreate.vo.UserVO;

@Service
@RequiredArgsConstructor
public class MessageService {
	
	private final UserDAO userDAO;
	private final MessageDAO messageDAO;
	
	@Transactional
	public void addMessage(MessageVO vo) throws Exception {
		System.out.println("addMessage Service 호출");
		// 발신자 포인트 증가
		UserVO uv = new UserVO();
		uv.setUid(vo.getSender());
		uv.setUpoint(10);
		userDAO.updatePoint(uv);
		// 메세지 등록
		messageDAO.create(vo);
		System.out.println("addMessage Service 종료");
	}

	public List<MessageVO> list() throws Exception{
		return messageDAO.list();
	}

	public MessageVO readMessage(String uid, int mno) throws Exception{
		/*
		MessageVO message = messageDAO.readMessage(mno);
		if(message.getOpnedate() != null) {
			throw new NullPointerException("이미 읽은 메세지 입니다");
		}
		*/
		// opendate => now();
		messageDAO.updateMessage(mno);
		UserVO vo = new UserVO();
		vo.setUid(uid);
		vo.setUpoint(5);
		userDAO.updatePoint(vo);
		
		MessageVO message = messageDAO.readMessage(mno);
		return message;
	}
	
	
}














