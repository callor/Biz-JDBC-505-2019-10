package com.biz.grade.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	private static Connection dbConn = null;

	/* static 생성자
	 * 
	 * 프로젝트가 시작됨과 동시에
	 * JVM에 의해서 자동으로 실행되는 클래스와 무관한
	 * 전역(전체에서 접근 가능한) 생성자 method
	 * 
	 */
	static {

		// DB 연결을 해서 dbConn 을 생성하기
		String jdbcDriver = DBContract.DBConn.JdbcDriver;
		String url = DBContract.DBConn.URL;
		String user = DBContract.DBConn.USER;
		String password = DBContract.DBConn.PASSWORD;

		try {
			Class.forName(jdbcDriver);
			dbConn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// 프로젝트가 시작하면서 생성된 
	// dbConn(연결객체, 인스턴스)를 필요할때
	// 가져가는 통로 method
	// dbConn 변수를 직접 접근하지 않고
	// getter method를 호출해서 가져간다.
	// singletone 기법과 유사
	public static Connection getDBConnection() {
		return dbConn;
	}

}
