package net.koreate.common.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.util.WebUtils;

import lombok.extern.slf4j.Slf4j;
import net.koreate.common.session.MySessionEventListener;
import net.koreate.user.service.UserService;
import net.koreate.user.vo.UserVO;
@Slf4j
public class CheckCookieInterceptor implements HandlerInterceptor{
	
	@Autowired
	private UserService us;
	
	@Autowired
	MySessionEventListener mel;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		log.info("--- check Cookie 시작 ---");
		HttpSession session = request.getSession();
		if(session.getAttribute("userInfo") != null) {
			log.info("이미 로그인 상태");
			return true;
		}
		
		Cookie cookie = WebUtils.getCookie(request, "signInCookie");
		if(cookie != null) {
			UserVO vo = us.getUserById(cookie.getValue());
			if(vo != null) {
				boolean result = mel.expireDuplicatedSession(vo.getUid(), session.getId());
				System.out.println(result);
				session.setAttribute("userInfo", vo);
			}
		}
		log.info("--- check Cookie 종료 ---");
		/*
		Cookie[] cookies = request.getCookies();
		if(cookies != null) {
			for(Cookie c : cookies) {
				if(c.getName().equals("signInCookie")) {
					String uid = c.getValue();
					UserVO vo = us.getUserById(uid);
					if(vo != null) {
						session.setAttribute("userInfo", vo);
					}
					return true;
				}
			}
		}
		 */
		return true;
	}
	
}
