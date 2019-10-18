package com.biz.grade.service.extend;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.biz.grade.config.DBContract;
import com.biz.grade.persistence.domain.ScoreDTO;
import com.biz.grade.persistence.domain.ScoreVO;
import com.biz.grade.service.ScoreServiceV2;

public class ScoreServiceV2Ext extends ScoreServiceV2 {

	@Override
	public List<ScoreVO> selectAll() {

		PreparedStatement pStr = null;
		String sql = DBContract.SQL.SELECT_VIEW_SCORE;
		
		try {

			pStr = dbConn.prepareStatement(sql);
			ResultSet rst = pStr.executeQuery();
			
			List<ScoreVO> scoreList = new ArrayList<ScoreVO>();
			while(rst.next()) {
				scoreList.add(this.rstTOScoreVO(rst));
			}
			rst.close();
			pStr.close();
			return scoreList;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	private ScoreVO rstTOScoreVO(ResultSet rst) throws SQLException {
		
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
	public ScoreVO findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(ScoreDTO scoreDTO) {

		PreparedStatement pStr = null;
		String sql = " INSERT INTO tbl_score " +
				" ( S_ID, " + 
				" S_STD," + // 학번
				" S_SUBJECT," + // 과목코드
				" S_SCORE," +  // 점수
				" S_REM )" +  // 비고
			" VALUES(?,?,?,?,?) ";
		try {
			
			pStr = dbConn.prepareStatement(sql);
			pStr.setLong(1, scoreDTO.getS_id());
			pStr.setString(2, scoreDTO.getS_std());
			pStr.setString(3, scoreDTO.getS_subject());
			pStr.setInt(4, scoreDTO.getS_score());
			pStr.setString(5, scoreDTO.getS_rem());
			
			// CRUD 중에서 CUD(Insert, Update, Delete()는
			// excuteUpdate() method를 사용한다.
			// 쿼리가 정상 수행되면 
			// 	ret는 0보다큰값을 갖는다.
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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(long id) {

		PreparedStatement pStr = null;
		String sql = " DELETE FROM tbl_score " ;
		sql += " WHERE s_id = ?";
		
		try {
			pStr = dbConn.prepareStatement(sql);
			pStr.setLong(1, id);
			int ret = pStr.executeUpdate();
			
			pStr.close();
			return ret;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return 0;
	}

	/*
	 * stName 변수를 매개변수로 받아서
	 * 학생이름으로 검색한 다음 List로 return
	 */
	@Override
	public List<ScoreVO> findByStName(String stName) {

		PreparedStatement pStr = null;
		String sql = DBContract.SQL.SELECT_VIEW_SCORE;
		sql += " WHERE ST_NAME = ? ";
		
		try {
			pStr = dbConn.prepareStatement(sql);
			pStr.setString(1, stName);
			
			ResultSet rst = pStr.executeQuery();
			List<ScoreVO> scoreList = new ArrayList<ScoreVO>();
			while(rst.next()) {
				scoreList.add(this.rstTOScoreVO(rst));
			}
			
			rst.close();
			pStr.close();
			return scoreList;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return null;
	}

	/*
	 * 학번을 매개변수로 받아서
	 * 성적리스트를 return
	 */
	@Override
	public List<ScoreVO> findByStNum(String strStNum) {

		PreparedStatement pStr = null;
		String sql = DBContract.SQL.SELECT_VIEW_SCORE;
		sql += " WHERE s_std = ? ";
		
		try {
			pStr = dbConn.prepareStatement(sql);
			pStr.setString(1, strStNum);
			ResultSet rst = pStr.executeQuery();
			
			List<ScoreVO> scList = new ArrayList<ScoreVO>();
			while(rst.next()) {
				scList.add(this.rstTOScoreVO(rst));
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

		PreparedStatement pStr = null;
		
		String sql = DBContract.SQL.SELECT_VIEW_SCORE;
		sql += " WHERE s_subject = ? ";
		
		try {
			pStr = dbConn.prepareStatement(sql);
			pStr.setString(1, strSubject);
			
			ResultSet rst = pStr.executeQuery();
			List<ScoreVO> scList = new ArrayList<ScoreVO>();
			while(rst.next()) {
				scList.add(this.rstTOScoreVO(rst));
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


}
