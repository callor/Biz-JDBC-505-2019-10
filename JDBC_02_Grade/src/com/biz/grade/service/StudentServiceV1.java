package com.biz.grade.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.biz.grade.persistence.ScoreDTO;
import com.biz.grade.persistence.StudentDTO;
import com.biz.grade.utils.DBContract;

public class StudentServiceV1 extends StudentService {

	@Override
	public int insert(StudentDTO scoreVO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<StudentDTO> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StudentDTO findById(String num) {

		this.dbConnection();
		PreparedStatement pStr = null;
		String sql = DBContract.SQL.STUDENT_SELECT;
		sql += " WHERE ST_NUM = ? ";
		
		try {

			pStr = dbConn.prepareStatement(sql);
			pStr.setString(1, num);
			ResultSet rst = pStr.executeQuery();

			// 학생NUM로 조회를 해서 있으면 dto return
			// 없으면 null return
			StudentDTO sdto = null;
			if(rst.next()) {
				 sdto = this.rstTOdto(rst);
			}
			rst.close();
			dbConn.close();
			return sdto;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
				
		
		return null;
	}

	@Override
	public List<StudentDTO> findByName(String name) {

		this.dbConnection();
		PreparedStatement pStr = null;
		
		String sql = DBContract.SQL.STUDENT_SELECT ;
		sql += " WHERE ST_NAME = ? ";
		
		try {
			pStr = dbConn.prepareStatement(sql);
			pStr.setString(1, name);
			ResultSet rst = pStr.executeQuery();
			
			// stdList를 생성을 하면 stdList가 null 아니다
			List<StudentDTO> stdList = new ArrayList<StudentDTO>();
			while(rst.next()) {
				
				stdList.add(this.rstTOdto(rst)); 

				
//						StudentDTO.builder()
//						.st_num(rst.getString("ST_NUM"))
//						.st_name(rst.getString("ST_NAME"))
//						.st_addr(rst.getString("ST_ADDR"))
//						.st_grade(rst.getInt("ST_GRADE"))
//						.st_tel(rst.getString("ST_TEL"))
//						.st_dept(rst.getString("ST_DEPT"))
//						.build()
//				);
			}
			rst.close();
			dbConn.close();
			return stdList;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<StudentDTO> findBySubject(String subject) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(StudentDTO scoreVO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(long id) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	private StudentDTO rstTOdto(ResultSet rst) 
					throws SQLException {
		
		return StudentDTO.builder()
		.st_num(rst.getString("ST_NUM"))
		.st_name(rst.getString("ST_NAME"))
		.st_addr(rst.getString("ST_ADDR"))
		.st_grade(rst.getInt("ST_GRADE"))
		.st_tel(rst.getString("ST_TEL"))
		.st_dept(rst.getString("ST_DEPT"))
		.build();
		
	}
	

}
