package com.koreate.betty.global.config;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.FilterType;
import org.springframework.http.CacheControl;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.koreate.betty.domain.member.interceptor.SignInByCookieInterceptor;
import com.koreate.betty.domain.member.resolver.LoginArgumentResolver;
import com.koreate.betty.domain.member.service.MemberService;
import com.koreate.betty.domain.member.service.SignService;
import com.koreate.betty.global.interceptor.ChooseNavInterceptor;

@EnableWebMvc
@EnableScheduling
@EnableAspectJAutoProxy
@ComponentScan( basePackages = { "com.koreate.betty" }, 
				excludeFilters = @ComponentScan.Filter(
								type = FilterType.ANNOTATION,
								classes = Configuration.class
								)
			)
public class AppConfig implements WebMvcConfigurer {
	
	@Autowired
	MemberService memberService;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new ChooseNavInterceptor())
		.order(0)
		.addPathPatterns("/**")
		.excludePathPatterns("/resources/**");
		registry.addInterceptor(new SignInByCookieInterceptor(memberService))
		.order(1)
		.addPathPatterns("/**")
		.excludePathPatterns("/resources/**");
	}

	@Override 
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**")
				.addResourceLocations("/resources/")
				.setCacheControl(CacheControl.maxAge(Duration.ofDays(365)));;
		}
	
	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
		 resolvers.add(new LoginArgumentResolver());
	}

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
		registry.viewResolver(viewResolver);
	}
	

	
}
