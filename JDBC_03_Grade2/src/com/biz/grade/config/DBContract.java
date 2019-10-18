package com.biz.grade.config;

/*
 * DBMS에 연결하고, 
 * 사용할 SQL 등과 관련된 정보를 등록
 */
public class DBContract {
	
	public static class DBConn {
		public static final String JdbcDriver = "oracle.jdbc.OracleDriver";
		public static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
		public static final String USER = "grade";
		public static final String PASSWORD = "grade";
	}
	
	public static class SQL {
		
		public static final String SELECT_SCORE 
			= " SELECT S_ID," + 
				" S_SCORE," + 
				" S_REM," + 
				" S_SUBJECT," + 
				" S_STD" +
				" FROM tbl_score ";
		
		public static final String SELECT_VIEW_SCORE
			= " SELECT S_STD," + 
					" ST_NAME," + 
					" ST_GRADE," + 
					" ST_DEPT," + 
					" D_NAME," + 
					" D_TEL," + 
					" S_SUBJECT," + 
					" SB_NAME," + 
					" S_SCORE," + 
					" S_ID" +
			" FROM view_score ";
		
		
		public static final String SELECT_STUDENT
			= "SELECT ST_NUM," + 
				" ST_NAME," + 
				" ST_TEL," + 
				" ST_ADDR," + 
				" ST_GRADE," + 
				" ST_DEPT" +
			" FROM tbl_student ";
		
		public static final String SELECT_SUBJECT 
			= "SELECT SB_CODE," + 
					" SB_NAME," + 
					" SB_PRO" +
				" FROM tbl_subject ";
				
		public static final String SELECT_DEPT
			= "SELECT D_NUM" + 
					" D_NAME," + 
					" D_PRO," + 
					" D_TEL" +
				" FROM tbl_dept ";
		
		public static final String INSERT_SCORE 
			= " INSERT INTO tbl_score " +
					" ( S_ID, " + 
					" S_STD," + // 학번
					" S_SUBJECT," + // 과목코드
					" S_SCORE," +  // 점수
					" S_REM )" +  // 비고
				" VALUES(?,?,?,?,?) ";
	
	}
	
}
