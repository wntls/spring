package net.koreate.board.config;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import net.koreate.board.util.Calculator;

@Configuration
@MapperScan(basePackages = {"net.koreate.board.dao"})
public class RootConfig {
	
	@Inject
	ApplicationContext context;
	// == spring container
	// BeanFactory == 빈을 관리하고 조회 하는 역할
	// 국제화 기능, 환경변수관려 처리, 애플리케이션 이벤트, 리소스 조회
	
	@Bean
//	@Scope("prototype")
//	@Scope("singltone")
	public DataSource dataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/spring_data");
		ds.setUsername("spring");
		ds.setPassword("12345");
		return ds;
	}
	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception{
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(dataSource());
		bean.setTypeAliasesPackage("net.koreate.board.vo, net.koreate.board.util");
		// mapper xml
		bean.setMapperLocations(context.getResources("classpath:mybatis/sql/*.xml"));
		return bean.getObject();
	}
	
	@Bean
	public SqlSession sqlSession()throws Exception{
		SqlSession session = new SqlSessionTemplate(sqlSessionFactory());
		return session;
	}
	
	@Bean
	public Calculator getCalculator() {
		return new Calculator();
	}	
}














