package com.biz.oracle.exec;

import com.biz.oracle.service.BookServiceV1;

public class BookPriceEx_01 {

	/*
	 * 두개의 숫자(도서금액)을 입력받아서
	 * 범위내에 있는 도서 목록을 보이기
	 */
	public static void main(String[] args) {
		
		BookServiceV1 bs = new BookServiceV1();
		bs.searchBookPrice();
		
	}

}
