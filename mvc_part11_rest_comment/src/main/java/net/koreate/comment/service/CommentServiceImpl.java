package net.koreate.comment.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import net.koreate.comment.dao.CommentDAO;
import net.koreate.comment.vo.CommentDTO;
import net.koreate.common.utils.Criteria;
import net.koreate.common.utils.PageMaker;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
	
	private final CommentDAO dao;
	
	@Override
	public List<CommentDTO> commentList(int bno) throws Exception {
		return dao.commentList(bno);
	}

	@Override
	public String addComment(CommentDTO dto) throws Exception {
		int result = dao.add(dto);
		return result == 1 ? "SUCCESS" : "FAILED";
	}

	@Override
	public String update(CommentDTO dto) throws Exception {
		int result = dao.update(dto);
		return result > 0 ? "SUCCESS" : "FAILED";
	}

	@Override
	public String deleteComment(int cno) throws Exception {
		return dao.delete(cno) > 0 ? "SUCCESS" : "FAILED";
	}

	@Override
	public List<CommentDTO> commentListPage(int bno, Criteria cri) throws Exception {
		return dao.listPage(bno, cri);
	}

	@Override
	public PageMaker getPageMaker(Criteria cri, int bno) throws Exception {
		int totalCount = dao.totalCount(bno);
		PageMaker pageMaker = new PageMaker();
		pageMaker.setDisplayPageNum(5);
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(totalCount);
		return pageMaker;
	}

}









