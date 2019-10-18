package com.biz.grade.persistence.dao;

import java.sql.Connection;
import java.util.List;

import com.biz.grade.config.DBConnection;
import com.biz.grade.persistence.domain.SubjectDTO;

public abstract class SubjectDao {

	protected Connection dbConn = null;
	public SubjectDao() {
		this.dbConn = DBConnection.getDBConnection();
	}
	
	// 조건없이 모든 데이터를 조회하는 method
	// List<> 형태의 데이터를 return
	public abstract List<SubjectDTO> selectAll();
	
	// PK를 조건으로 데이터를 조회하는 method
	// PK로 조회한다는 것은 출력되는 데이터가 1개 Record다
	// VO(DTO) 형태의 데이터를 return
	public abstract SubjectDTO findById(String sb_num);

	// 학과이름으로 조회해서 결과를 return method
	public abstract List<SubjectDTO> findByName(String sb_name);
	public abstract List<SubjectDTO> findByPro(String sb_pro);
	
	// DTO에 과목 데이터를 저장하여 method에 주입한후
	// insert 수행
	public abstract int insert(SubjectDTO subjectDTO);
	public abstract int update(SubjectDTO subjectDTO);
	
	// 매개변수로 일반적으로 findById() 메서드의
	// 매개변수와 형, 값이 같다.
	public abstract int delete(String sb_num);
	
}
