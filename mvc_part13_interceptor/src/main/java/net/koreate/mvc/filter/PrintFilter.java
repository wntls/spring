package net.koreate.mvc.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class PrintFilter implements Filter{
	
	String filterParam;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("=========================================");
		System.out.println("PrintFilter init() 시작");
		filterParam = filterConfig.getInitParameter("filterParam");
		System.out.println("PrintFilter init() 종료");
		System.out.println("=========================================");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("=========================================");
		System.out.println("PrintFilter doFilter() 시작");
		request.setCharacterEncoding(filterParam);
		chain.doFilter(request, response);
		System.out.println("PrintFilter doFilter() 종료");
		System.out.println("=========================================");
	}

	@Override
	public void destroy() {
		System.out.println("=========================================");
		System.out.println("PrintFilter destroy()");
		System.out.println("=========================================");
	}

}
