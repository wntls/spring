package net.koreate.mvc.interceptor;

import java.lang.reflect.Method;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class TestInterceptor implements HandlerInterceptor{
	
	// preHandle 
	// 요청 처리가 되기 전
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("=========================================");
		System.out.println("preHandle START");
		
		HandlerMethod method = (HandlerMethod)handler;
		Method methodObj = method.getMethod();
		// 디스패쳐서블릿의 Controller 호출 정보
		System.out.println("controller : "+method.getBean());
		System.out.println("methodObj : "+methodObj);
		System.out.println("전송 방식 : "+request.getMethod());
		String commend = request.getRequestURI().substring(
				request.getContextPath().length()+1
				);
		System.out.println("요청 : "+commend);
		if(commend.equals("test1")) {
			response.sendRedirect(request.getContextPath());
			System.out.println("return false");
			return false;
		}
		//return super.preHandle(request, response, handler);
		System.out.println("preHandle END");
		System.out.println("=========================================");
		return true;
	}
	
	// 요청 처리가 완료된 후
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("=========================================");
		System.out.println("postHandle START");
		System.out.println(modelAndView.getViewName());
		Map<String,Object> map = modelAndView.getModel();
		for(String key : map.keySet()) {
			System.out.println("key : "+ key);
			System.out.println("value : "+ map.get(key));
		}
		
		if(modelAndView.getViewName().equals("another")) {
			modelAndView.setViewName("home");
		}
		
		Object result = modelAndView.getModel().get("result");
		if(result == null) {
			modelAndView.addObject("result","postHandle job");
		}
		System.out.println("postHandle END");
		System.out.println("=========================================");
	}
	
	// 출력이 완료된 후
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("=========================================");
		System.out.println("afterCompletion START");
		System.out.println(request.getAttribute("result"));
		System.out.println(request.getAttribute("result1"));
		System.out.println("afterCompletion END");
		System.out.println("=========================================");
	}
	
}





















