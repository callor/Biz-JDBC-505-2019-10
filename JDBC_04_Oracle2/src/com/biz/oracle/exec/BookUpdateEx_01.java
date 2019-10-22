package com.biz.oracle.exec;

import com.biz.oracle.service.BookCUDServiceV1;
import com.biz.oracle.service.BookServiceV1;

/*
 * 도서명을 입력받아서
 * 리스트를 보여주고
 * 수정할 도서코드를 입력받고
 * 해당하는 도서를 수정
 * 1. 각 항목을 보여주고
 * 	  새로운 값을 입력하면 수정
 *    그냥 Enter 입력하면 그대로 유지
 */
public class BookUpdateEx_01 {

	public static void main(String[] args) {

		// SELECT를 위한 서비스 클래스
		BookServiceV1 bs = new BookServiceV1();
		
		// INSERT, UPDATE, DELETE 위한 서비스 클래스
		BookCUDServiceV1 bC = new BookCUDServiceV1();
		
		// bs에서 도서명을 입력했을때 List를 보여주는 method 호출
		String strName = bs.searchBookName();
		if(strName.equals("-Q")) {
			System.out.println("도서정보 변경 업무 종료");
		} else {
			// 도서리스트를 보고
			// 도서코드를 입력받아서 도서정보를 수정
			bC.updateBook();
			bs.searchBookName(strName);
		}
	}
}
