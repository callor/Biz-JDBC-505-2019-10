package com.biz.iolist.exec;

import com.biz.iolist.service.dept.DeptServiceV1;

public class DeptEx_01 {

	public static void main(String[] args) {

		DeptServiceV1 ds = new DeptServiceV1();
		// ds.viewAllList();
		
		System.out.println("==========================");
		// ds.viewNameList();
		
		System.out.println("==========================");
		ds.viewNameAndCeoList();
		
		
	}

}
