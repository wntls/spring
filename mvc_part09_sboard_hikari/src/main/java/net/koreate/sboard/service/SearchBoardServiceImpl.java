package net.koreate.sboard.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import net.koreate.common.utils.PageMaker;
import net.koreate.common.utils.SearchCriteria;
import net.koreate.common.utils.SearchPageMaker;
import net.koreate.sboard.dao.SearchBoardDAO;
import net.koreate.sboard.vo.SearchBoardVO;
@Service
public class SearchBoardServiceImpl implements SearchBoardService {

	private final SearchBoardDAO dao;
	
	public SearchBoardServiceImpl(SearchBoardDAO dao) {
		this.dao = dao;
	}

	@Override
	public String register(SearchBoardVO vo) throws Exception {
		int resutl = dao.create(replace(vo));
		String msg = "SUCCESS";
		if(resutl == 0) {
			msg = "FAILED";
		}
		return msg;
	}

	@Override
	public String modify(SearchBoardVO vo) throws Exception {
		return dao.update(replace(vo)) != 1 ? "FAILED" : "SUCCESS";
	}

	@Override
	public String remove(int bno) throws Exception {
		return dao.remove(bno) > 0 ? "SUCCESS" : "FAILED";
	}

	@Override
	public SearchBoardVO read(int bno) throws Exception {
		return dao.read(bno);
	}

	@Override
	public void updateViewCnt(HttpServletRequest request, HttpServletResponse response, int bno) throws Exception {
		String cookieBno = "sboardCookie"+bno;
		Cookie[] cookies = request.getCookies();
		if(cookies != null) {
			for(Cookie cookie : cookies) {
				if(cookie.getName().equals(cookieBno)) {
					return;
				}
			}
		}
		// cookie가 존재 하지 않음
		Cookie cookie = new Cookie(cookieBno,String.valueOf(bno));
		String path = request.getContextPath()+"/sboard";
		System.out.println(path);
		cookie.setPath(path);
		cookie.setMaxAge(60*60);
		response.addCookie(cookie);
		dao.updateViewCnt(bno);
	}

	@Override
	public List<SearchBoardVO> list(SearchCriteria cri) throws Exception {
		String type = cri.getSearchType();
		String word = cri.getKeyword();
		System.out.println("type : "+type);
		System.out.println("word : "+word);
		
		List<SearchBoardVO> list = dao.searchList(cri);
		if(type != null && !type.trim().equals("") && !type.equals("n")) {
			for(SearchBoardVO vo : list) {
			// 제목, 작성자
				vo.setTitle(highLisght(vo.getTitle(), word));
				vo.setWriter(highLisght(vo.getWriter(), word));
			}
		}
		System.out.println(list);
		return list;
	}
	
	// 수정 할 텍스트, keyword
	public String highLisght(String text,String word) {
		text = text.replace(word, "<b style='color:red;'>"+word+"</b>");
		return text;
	}
	
	// < > 특수문자 치환
	public String replaceScript(String text) {
		// < == &lt;
		// > == &gt;
		text = text.replace("<", "&lt");
		text = text.replace(">", "&gt");
		return text;
	}
	
	// 삽입 또는 수정될 객체 정보에서 특수문자 치환
	public SearchBoardVO replace(SearchBoardVO vo) {
		vo.setTitle(replaceScript(vo.getTitle()));
		vo.setContent(replaceScript(vo.getContent()));
		vo.setWriter(replaceScript(vo.getWriter()));
		return vo;
	}
	
	
	@Override
	public PageMaker getPageMaker(SearchCriteria cri) throws Exception {
		int totalCount = dao.searchListCount(cri);
		PageMaker pm = new SearchPageMaker();
		pm.setCri(cri);
		pm.setTotalCount(totalCount);
		return pm;
	}

	@Override
	public Map<String, Object> getListModel(SearchCriteria cri) throws Exception {
		return null;
	}

}
