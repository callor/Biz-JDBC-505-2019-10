package com.biz.iolist.config.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.biz.iolist.config.DBConnection;
import com.biz.iolist.dao.DeptDao;
import com.biz.iolist.dao.IolistDao;
import com.biz.iolist.dao.IolistViewDao;
import com.biz.iolist.dao.ProductDao;
import com.biz.iolist.persistence.IolistVO;

public class IolistServiceV1 {

	protected IolistDao iolistDao;
	protected DeptDao deptDao;
	protected ProductDao proDao;
	protected IolistViewDao viewDao;
	
	public IolistServiceV1() {
		
		SqlSession sqlSession = DBConnection
					.getSqlSessionFactory()
					.openSession(true);
		
		this.proDao =  sqlSession.getMapper(ProductDao.class);
		this.iolistDao =  sqlSession.getMapper(IolistDao.class);
		this.deptDao =  sqlSession.getMapper(DeptDao.class);
		this.viewDao =  sqlSession.getMapper(IolistViewDao.class);
	
	}
	
	public void viewAllList() {
		List<IolistVO> iolist = viewDao.selectAll();
		for(IolistVO vo : iolist) {
			System.out.println(vo.toString());
		}
	}
	
}
