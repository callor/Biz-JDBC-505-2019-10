package com.biz.grade.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import com.biz.grade.persistence.ScoreDTO;
import com.biz.grade.persistence.StudentDTO;
import com.biz.grade.utils.DBContract;

/*
 * 추상클래스 선언
 * 추상클래스
 * 		일부는 구현된 method
 * 		일부는 형태만 갖는 method
 */
public abstract class ScoreService {

	protected Connection dbConn = null;
	
	/*
	 * dbConn 을 설정하여 DBMS에 접속할수 있는 통로 설정
	 */
	protected void dbConnection() {
		try {
			Class.forName(DBContract.DbConn.JdbcDriver);
			dbConn = DriverManager.getConnection(
					DBContract.DbConn.URL, 
					DBContract.DbConn.USER, 
					DBContract.DbConn.PASSWORD
			);
			System.out.println("DbConnection OK!!!");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("JDBC 드라이버를 찾지 못함!!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("DBMS 접속 오류!!");
		}
	}
	
	// CRUD
	public abstract int insert(ScoreDTO scoreDTO) ;

	// 모든 레코드
	// 1개 이상의 레코드
	public abstract List<ScoreDTO> selectAll();
	
	// id 값을 매개변수로 받아서
	// 1개의 레코드만 조회하는 method
	public abstract ScoreDTO findById(long id);
	
	public abstract List<ScoreDTO> findByName(String name);
	
	// 과목별로 점수리스트를
	public abstract List<ScoreDTO> findBySubject(String subject);
	
	public abstract int update(ScoreDTO scoreDTO) ;
	public abstract int delete(long id);
	
}




