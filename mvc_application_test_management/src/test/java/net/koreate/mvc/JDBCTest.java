package net.koreate.mvc;

import java.sql.Connection;
import java.sql.SQLException;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:context/root-context.xml"})
public class JDBCTest {
	
	@Inject
	DataSource ds;
	
	@Test
	public void hikariTest() throws SQLException {
		System.out.println(ds);
		Connection conn = ds.getConnection();
		System.out.println("Connection : "+ conn);
		conn.close();
	}
	
	
}
