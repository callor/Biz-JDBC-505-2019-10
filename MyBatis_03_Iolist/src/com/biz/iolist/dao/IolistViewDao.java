package com.biz.iolist.dao;

import java.util.List;

import com.biz.iolist.persistence.IolistVO;

public interface IolistViewDao {
	
	public List<IolistVO> selectAll();
	public IolistVO findById(long io_seq);
	
	public List<IolistVO> findByDCode(String io_dcode);
	public List<IolistVO> findByPCode(String io_pcode);

	public List<IolistVO> findByDName(String io_dname);
	public List<IolistVO> findByPName(String io_pname);
	
}
