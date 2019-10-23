package com.biz.mybatis.exec;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.biz.mybatis.config.DBConnection;
import com.biz.mybatis.mapper.BookDao;
import com.biz.mybatis.peristence.BookDTO;

public class MyBatisEx_03 {

	public static void main(String[] args) {

		/*
		 * JDBC의 다양한 클래스를 대신하여
		 * Java 어플리케이션과 DBMS간의 연결 Connection을
		 * 대신 관리해줄 클래스, 객체선언
		 * 
		 * session
		 * 네트워크 환경에서 지점과 지점사이가 다양한 방법으로
		 * 연결되고 데이터를 주고받을 준비가 된 통료
		 */
		SqlSession sqlSession 
			= DBConnection
				.getSqlSessionFactory()
				.openSession(true);
		
		BookDao bookDao 
			= sqlSession.getMapper(BookDao.class);
		
		BookDTO bookDTO = BookDTO.builder()
				.b_name("MyBATIS")
				.b_comp("경영원")
				.b_writer("내멋으로")
				.b_price(50000)
				.build();
		
		bookDao.insert(bookDTO);
		
		List<BookDTO> bookList = bookDao.selectAll();
		for(BookDTO dto : bookList) {
			System.out.println(dto.toString());
		}
		
	}
}
