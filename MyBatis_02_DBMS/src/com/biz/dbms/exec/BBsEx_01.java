package com.biz.dbms.exec;

import com.biz.dbms.service.BBsServiceV1;

public class BBsEx_01 {

	public static void main(String[] args) {

		BBsServiceV1 bbs = new BBsServiceV1();
		
		// 키보드를 사용해서 게시판 글쓰기를 구현
		bbs.writeBBS() ;
		
		System.out.println("게시판 입력 종료");
		// 입력된 게시판 보기
		bbs.viewBBsList() ;
		
		
	}

}
