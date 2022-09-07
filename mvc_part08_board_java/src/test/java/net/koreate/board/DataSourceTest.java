package net.koreate.board;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import net.koreate.board.config.RootConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		classes = {RootConfig.class}
)
public class DataSourceTest {
	
	@Autowired
	DataSource ds;
	
	@Autowired
	DriverManagerDataSource dmds;
	
	@Autowired
	SqlSessionFactory sf;
	
	@Autowired
	SqlSessionTemplate ss;
	
	@Test
	public void dataSourceTest() throws Exception{
		System.out.println(ds.getConnection());
		System.out.println(ds);
		System.out.println(dmds);
		System.out.println(sf);
		System.out.println(ss);
		System.out.println("========================");
		System.out.println(sf);
		System.out.println(ss.getSqlSessionFactory());
	}
	
}






















