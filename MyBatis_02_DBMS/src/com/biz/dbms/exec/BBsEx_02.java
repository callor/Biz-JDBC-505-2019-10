package com.biz.dbms.exec;

import com.biz.dbms.service.BBsServiceV2;

public class BBsEx_02 {

	public static void main(String[] args) {

		BBsServiceV2 bbs = new BBsServiceV2();
		
		bbs.viewBBsList();
		bbs.bbsMenu();
		
	}

}
