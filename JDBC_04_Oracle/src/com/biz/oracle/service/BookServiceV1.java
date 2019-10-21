package com.biz.oracle.service;

import java.util.List;
import java.util.Scanner;

import com.biz.oracle.persistence.BookDTO;
import com.biz.oracle.persistence.dao.BookDao;
import com.biz.oracle.persistence.dao.BookDaoImp;

public class BookServiceV1 {

	// 객체 선언(아직 사용준비 전 단계)
	BookDao bookDao = null;
	Scanner scanner = null;

	// 클래스 생성자
	public BookServiceV1() {
	
		// 선언된 객체를 사용할수 있도록 초기화
		// 초기화된 클래스 = 인스턴스(화 되었다)
		scanner = new Scanner(System.in);
		bookDao = new BookDaoImp();
		
	}
	
	/*
	 * 도서정보 전체리스트를 DB로 부터 읽어서
	 * console에 보이기
	 */
	public void viewBookList() {
		
		// dao의 selectAll() method를 호출하여
		// 전체 리스트를 DB로 부터 가져와서
		// bookList에 받기
		List<BookDTO> bookList = bookDao.selectAll();
		
		// bookList에는 전체 리스트가 담겨있을 것이므로
		// viewList() 전체리스트를 콘솔에 보일것이다.
		this.viewList(bookList);
		
	} // end viewBookList

	/*
	 * bookList를 매개변수로 받아서
	 * console에 보이기
	 */
	private void viewList(List<BookDTO> bookList) {
		System.out.println("=================================");
		System.out.println("전체 도서 리스트 V1");
		System.out.println("=================================");
		System.out.println("코드\t도서명\t출판사\t저자\t가격");
		System.out.println("---------------------------------");
		for(BookDTO dto  : bookList) {
			System.out.printf("%s\t",dto.getB_code());
			System.out.printf("%s\t",dto.getB_name());
			System.out.printf("%s\t",dto.getB_comp());
			System.out.printf("%s\t",dto.getB_writer());
			System.out.printf("%d\n",dto.getB_price());
		}
		System.out.println("================================");
	}
	
	/*
	 * 키보드에서 도서이름을 입력받아서
	 * 리스트를 콘솔에 보이기
	 */
	public void searchBookName(boolean bConti) {
		while(true) {
			if(this.searchBookName()) break;
		}
	}

	public boolean searchBookName() {

		System.out.println("===========================");
		System.out.println("도서검색");
		System.out.println("===========================");
		System.out.print("도서명(-Q:quit) >> ");
		String strName = scanner.nextLine();
		if(strName.equals("-Q")) return true;
			
		List<BookDTO> bookList 
			= bookDao.findByName(strName);
			
		if(bookList == null || bookList.size() < 1) {
			System.out.println("찾는 도서명이 없음!!");
			return false;
		}
			
		// bookList에는 입력한 도서명에 해당하는 
		//		리스트가 담겨 있을것
		// viewList()는 검색조건에 맞는 리스트만 보일것
		this.viewList(bookList);
		return true;
	
	}

	
	
	public void searchBookPrice() {

		while(true) {
			System.out.println("=====================");
			System.out.println("도서가격검색");
			System.out.println("=====================");
			
			try {
				
				System.out.print("시작가격(-Q:quit) >> ");
				String strSPrice = scanner.nextLine();
				if(strSPrice.equals("-Q")) break;
				
				int sprice = Integer.valueOf(strSPrice);
				
				System.out.print("종료가격(-Q:quit) >> ");
				String strEprice = scanner.nextLine();
				if(strEprice.equals("-Q")) break;
				
				int eprice = Integer.valueOf(strEprice);
				
				List<BookDTO> bookList 
					= bookDao.findByPrice(sprice, eprice);
				
				this.viewList(bookList);

			} catch (Exception e) {
				System.out.println("가격은 숫자로만 입력하세요");
				continue;
			}
			
			
		}
		
		
	}
	
}
