package com.nie;

import com.nie.mapper.BooksMapper;
import com.nie.pojo.Books;
import com.nie.service.BooksServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@SpringBootTest
class DemoApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	DataSource dataSource;
	@Autowired
	private BooksMapper booksMapper;
	@Autowired
	private BooksServiceImpl booksServiceImpl;

	@Test
	public void test() throws SQLException {
//		System.out.println(dataSource.getClass());
//		Connection connection = dataSource.getConnection();
//		System.out.println(connection);
//
//		//template模板，拿来即用
//		connection.close();

		List<Books> list =  booksServiceImpl.selectAll();
		for (Books books:list){
			System.out.println(books);
		}
	}
}
