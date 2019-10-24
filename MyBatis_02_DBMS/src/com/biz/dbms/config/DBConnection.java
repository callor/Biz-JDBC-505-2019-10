package com.biz.dbms.config;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DBConnection {
	
	private static SqlSessionFactory sqlSessionFactory = null;
	
	static {
		
		// *-config.xml 파일을 읽어서 
		// mybatis 초기 설정값을 가져오기
		String configFile = "com/biz/dbms/config/mybatis-config.xml";
		InputStream inputStream = null;
		
		try {
			// configFile을 읽어오는 절차
			inputStream = Resources.getResourceAsStream(configFile);
			
			// sqlSessionFactory를 싱글톤으로 생성하기 위한 절차
			SqlSessionFactoryBuilder builder
				= new SqlSessionFactoryBuilder();
			if(sqlSessionFactory == null ) {
				sqlSessionFactory = builder.build(inputStream);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	} //  end static
	
	public static SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}

}
