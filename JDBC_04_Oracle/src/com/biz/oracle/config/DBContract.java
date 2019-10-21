package com.biz.oracle.config;

public class DBContract {

	public static class SQL  {
		
		public static final String SELECT_BOOKS
			= " SELECT B_CODE," + 
				"        B_NAME," + 
				"        B_COMP," + 
				" B_WRITER," + 
				" B_PRICE " +
				" FROM tbl_books ";
		
	}
	
}
