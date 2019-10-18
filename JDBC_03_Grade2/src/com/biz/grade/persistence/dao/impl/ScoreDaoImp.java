package com.biz.grade.persistence.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.biz.grade.config.DBContract;
import com.biz.grade.persistence.dao.ScoreDao;
import com.biz.grade.persistence.domain.ScoreDTO;
import com.biz.grade.persistence.domain.ScoreVO;

import oracle.jdbc.proxy.annotation.Pre;

public class ScoreDaoImp extends ScoreDao{

	@Override
	public List<ScoreVO> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ScoreVO findById(long id) {

		PreparedStatement pStr = null;
		String sql = DBContract.SQL.SELECT_VIEW_SCORE ;
		sql += " WHERE s_id = ?";
		
		try {
			pStr = dbConn.prepareStatement(sql);
			pStr.setLong(1, id);
			
			ResultSet rst = pStr.executeQuery();
			ScoreVO scoreVO = null;
			if(rst.next()) {
				scoreVO = this.rst_2_ScoreVO(rst);
			}
			rst.close();
			pStr.close();
			return scoreVO;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<ScoreVO> findByStName(String stName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(ScoreDTO scoreDTO) {

		PreparedStatement pStr = null;
		String sql = " INSERT INTO tbl_score ( ";
		sql += " S_ID,";
		sql += " S_SCORE,";
		sql += " S_REM,";
		sql += " S_SUBJECT,";
		sql += " S_STD )";
		sql += " VALUES(?,?,?,?,?)";
		try {

			pStr = dbConn.prepareStatement(sql);
			pStr.setLong(1,scoreDTO.getS_id());
			pStr.setInt(2,scoreDTO.getS_score());
			pStr.setString(3,scoreDTO.getS_rem());
			pStr.setString(4,scoreDTO.getS_subject());
			pStr.setString(5,scoreDTO.getS_std());
			
			int ret = pStr.executeUpdate();
			pStr.close();
			return ret;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return 0;
	}

	@Override
	public int update(ScoreDTO scoreDTO) {

		PreparedStatement pStr = null;
		String sql = "UPDATE tbl_score SET ";
		// sql += " S_ID = ?,";
		sql += " S_SCORE = ?,";
		sql += " S_REM = ?,";
		sql += " S_SUBJECT = ?,";
		sql += " S_STD = ?";
		sql += " WHERE S_ID = ? ";
				
		try {

			pStr = dbConn.prepareStatement(sql);
			pStr.setInt(1,scoreDTO.getS_score()) ;
			pStr.setString(2,scoreDTO.getS_rem()) ;
			pStr.setString(3,scoreDTO.getS_subject()) ;
			pStr.setString(4,scoreDTO.getS_std()) ;
			pStr.setLong(5,scoreDTO.getS_id()) ;
			
			int ret = pStr.executeUpdate();
			pStr.close();
			return ret;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return 0;
	}

	@Override
	public int delete(long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	private ScoreVO rst_2_ScoreVO(ResultSet rst) throws SQLException {
		
		ScoreVO scoreVO = ScoreVO.builder()
			.s_id(rst.getLong("S_ID"))
			.s_score(rst.getInt("S_SCORE"))
			.s_std(rst.getString("S_STD"))
			.s_subject(rst.getString("S_SUBJECT"))
			.sb_name(rst.getString("SB_NAME"))
			.st_dept(rst.getString("ST_DEPT"))
			.st_grade(rst.getInt("ST_GRADE"))
			.st_name(rst.getString("ST_NAME"))
			.d_name(rst.getString("D_NAME"))
			.d_tel(rst.getString("D_TEL"))
			.build();
		return scoreVO;
	}
	
	@Override
	public List<ScoreVO> findByStNum(String strStNum) {
		// TODO Auto-generated method stub
		PreparedStatement pStr = null;
		String sql = DBContract.SQL.SELECT_VIEW_SCORE;
		sql += " WHERE s_std = ? ";
		
		try {
			pStr = dbConn.prepareStatement(sql);
			pStr.setString(1, strStNum);
			ResultSet rst = pStr.executeQuery();
			
			List<ScoreVO> scList = new ArrayList<ScoreVO>();
			while(rst.next()) {
				scList.add(this.rst_2_ScoreVO(rst));
			}
			rst.close();
			pStr.close();
			return scList;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<ScoreVO> findBySubject(String strSubject) {
		// TODO Auto-generated method stub
		return null;
	}

}
