package com.biz.oracle.exec;

import com.biz.oracle.service.BookCUDServiceV1;
import com.biz.oracle.service.BookServiceV1;

public class BookDeleteEx_01 {

	public static void main(String[] args) {

		// 전체리스트를 확인하고
		// b_code 값을 입력받아서
		// 데이터를 삭제
		
		BookServiceV1 bs = new BookServiceV1();
		BookCUDServiceV1 bC = new BookCUDServiceV1();
		
		bs.viewBookList();
		bC.deleteBook();
		
		
	}

}
