package com.biz.iolist.config.service;

public class ProductServiceV3 extends ProductServiceV2 {
	
	
	public void menuProduct() {
		System.out.println("==============================");
		System.out.print("대한쇼핑몰 상품관리 시스템 v3");
		System.out.println("==============================");
		System.out.println("1.등록  2.수정  3.삭제  4.검색 0.끝");
		System.out.print("업무선택 >> ");
		String strMenu = scanner.nextLine();
		
		
		
	}
	
	/*
	 * 상품정보들을 입력받아서 insert 수행
	 * 상품코르를 입력받아서
	 * 있으면 다시 입력하도록
	 * 없으면 다음으로 진행
	 * 
	 */
	public void insertProduct() {
		
	}
	
	/*
	 * 상품코드를 입력받아서 delete 수행
	 */
	public void deleteProduct() {
		
	}

}
