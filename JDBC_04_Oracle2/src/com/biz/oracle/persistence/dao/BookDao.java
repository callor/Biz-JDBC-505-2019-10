package com.biz.oracle.persistence.dao;

import java.sql.Connection;
import java.util.List;

import com.biz.oracle.config.DBConnection;
import com.biz.oracle.persistence.BookDTO;

/*
 * 추상클래스로 선언
 * tbl_books 테이블의 CRUD를 구현
 */
public abstract class BookDao {
	
	protected Connection dbConn = null;
	
	public BookDao() {
		this.dbConn = DBConnection.getDBConnection();
	}
	
	/*
	 * B_CODE : PK 기준으로 값검색 findById(String b_code)
	 * B_NAME : findByName(String b_name)
	 * B_COMP : findByComp(String b_comp)
	 * B_WRITER : findByWriter(String b_writer)
	 * B_PRICE : findByPrice(int price), 
	 * 		findByPrice(int sprice, int eprice)  
	 */
	
	public abstract List<BookDTO> selectAll();
	
	// PK 기준으로
	public abstract BookDTO findById(String b_code);
	
	public abstract List<BookDTO> findByName(String b_name);
	public abstract List<BookDTO> findByComp(String b_comp);
	public abstract List<BookDTO> findByWriter(String b_writer);
	
	// 값이 일치하는 도서 리스트
	public abstract List<BookDTO> findByPrice(int price);
	
	// 값의 범위에 들어 있는 도서 리스트
	// 1000 ~ 20000
	public abstract List<BookDTO> findByPrice(int sprice, int eprice); 
	
	public abstract int insert(BookDTO bookDTO);
	public abstract int update(BookDTO bookDTO);
	public abstract int delete(String b_code);
	
}
