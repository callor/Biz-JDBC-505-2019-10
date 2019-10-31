package com.biz.iolist.exec;

import org.apache.ibatis.session.SqlSession;

import com.biz.iolist.config.DBConnection;

public class IolistEx_01 {

	public static void main(String[] args) {

		SqlSession sqlSession = DBConnection
						.getSqlSessionFactory()
						.openSession(true);
		
		
	}

}
