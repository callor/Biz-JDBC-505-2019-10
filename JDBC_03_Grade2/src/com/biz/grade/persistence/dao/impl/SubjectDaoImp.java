package com.biz.grade.persistence.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.biz.grade.config.DBContract;
import com.biz.grade.persistence.dao.SubjectDao;
import com.biz.grade.persistence.domain.StudentDTO;
import com.biz.grade.persistence.domain.SubjectDTO;

public class SubjectDaoImp extends SubjectDao {

	@Override
	public List<SubjectDTO> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SubjectDTO findById(String sb_num) {
		
		PreparedStatement pSt = null;
		String sql = DBContract.SQL.SELECT_SUBJECT;
		sql += " WHERE sb_code = ?";
		
		try {
			
			pSt = dbConn.prepareStatement(sql);
			pSt.setString(1, sb_num.toUpperCase());
			ResultSet rst = pSt.executeQuery();
			
			SubjectDTO subDTO = null;
			if(rst.next()) {
				subDTO = this.rst_2_DTO(rst);
			}
			rst.close();
			pSt.close();
			return subDTO;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	private SubjectDTO rst_2_DTO(ResultSet rst) throws SQLException {
		return SubjectDTO.builder()
				.sb_code(rst.getString("SB_CODE"))
				.sb_name(rst.getString("SB_NAME"))
				.sb_pro(rst.getString("SB_PRO"))
				.build();
	}

	@Override
	public List<SubjectDTO> findByName(String sb_name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SubjectDTO> findByPro(String sb_pro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(SubjectDTO subjectDTO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(SubjectDTO subjectDTO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String sb_num) {
		// TODO Auto-generated method stub
		return 0;
	}

}
