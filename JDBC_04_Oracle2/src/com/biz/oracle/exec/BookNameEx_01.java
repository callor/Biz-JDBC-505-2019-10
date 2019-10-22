package com.biz.oracle.exec;

import com.biz.oracle.service.BookServiceV1;

public class BookNameEx_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BookServiceV1 bs = new BookServiceV1();
		
		// searchBookName() method에
		// true값을 파라메터로 전달을 하면
		// 반복하면서 도서이름을 검색하게되고
		// 파라메터를 전달하지 않으면
		// 한번만 실행
		bs.searchBookName(true);
		System.out.println("도서검색 종료");

	}

}
