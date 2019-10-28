package com.biz.iolist.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.biz.iolist.persistence.DeptDTO;

public interface DeptDao {

	public List<DeptDTO> selectAll();
	public DeptDTO findById(String d_code); // PK 검색
	
	public List<DeptDTO> findByName(String d_name);
	public List<DeptDTO> findByCEO(String d_ceo);
	
	public List<DeptDTO> findByNameAndCEO(
			@Param("d_name") String d_name,
			@Param("d_ceo") String d_ceo);
	
	public int insert(DeptDTO deptDTO);
	public int update(DeptDTO deptDTO);
	public int delete(String d_code);
	
}
