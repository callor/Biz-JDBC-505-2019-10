package com.biz.oracle.exec;

import com.biz.oracle.service.BookCUDServiceV1;
import com.biz.oracle.service.BookServiceV1;

/*
 * 도서명을 입력받아서 도서명을 검색한
 * 리스트를 보여주고
 * 도서코드를 입력받아서 해당도서를 삭제하고
 * 결과를 다시 리스트로 보여주기
 */
public class BookDeleteEx_02 {

	public static void main(String[] args) {
		
		BookServiceV1 bs = new BookServiceV1();
		BookCUDServiceV1 bC = new BookCUDServiceV1();
		
		bs.searchBookName();
		bC.deleteBook();
		bs.viewBookList();
		
	}
}
