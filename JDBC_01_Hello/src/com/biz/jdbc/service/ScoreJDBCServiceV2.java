package com.biz.jdbc.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.biz.jdbc.domain.ScoreVO;

public class ScoreJDBCServiceV2 {

//	protected String jdbcDriver = "oracle.jdbc.driver.OracleDriver";
//	protected String url = "jdbc:oracle:thin:@localhost:1521:xe";
//	protected String userName = "grade";
//	protected String password = "grade";
	
	protected Connection dbConn = null ;
	protected PreparedStatement pStr = null;
	
	protected List<ScoreVO> scoreList = null;
	
	public List<ScoreVO> getScoreList() {
		return this.scoreList;
	}
	
	protected void dbConnection() {
		try {
			Class.forName(DBConstract.DB_INFO.JdbcDriver);
			dbConn 
				= DriverManager.getConnection(
						DBConstract.DB_INFO.URL,
						DBConstract.DB_INFO.USER,
						DBConstract.DB_INFO.PASSWORD);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<ScoreVO> selectAll() {
		
		String sql = " SELECT * FROM tbl_score ";
		this.select(sql);
		return this.scoreList;
	
	}
	
	public List<ScoreVO> findById(int s_id) {

		String sql = " SELECT * FROM tbl_score ";
		sql += " WHERE s_id = " + s_id ;
		
		this.select(sql);
		return this.scoreList;
		
	}
	
	public List<ScoreVO> findByName(String s_name) {
		String sql = " SELECT * FROM tbl_score ";
		sql += " WHERE s_std = " + s_name ;
		this.select(sql);
		return this.scoreList;
	}
	
	protected void select(String sql) {
		
		this.dbConnection();
		this.scoreList = new ArrayList<ScoreVO>();
		
		try {
			pStr = dbConn.prepareStatement(sql);
			
			ResultSet rst = pStr.executeQuery();
			while(rst.next()) {
				ScoreVO sVO = ScoreVO.builder()
						.s_id(rst.getInt(DBConstract.SCORE.S_ID))
						.s_std(rst.getString(DBConstract.SCORE.S_STD))
						.s_score(rst.getInt(DBConstract.SCORE.S_SCORE))
						.s_rem(rst.getString(DBConstract.SCORE.S_REM))
						.build();
				scoreList.add(sVO);
			}
			
			pStr.close();
			dbConn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	
}
