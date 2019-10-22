package com.biz.oracle.service;

import java.util.Scanner;

import com.biz.oracle.persistence.BookDTO;
import com.biz.oracle.persistence.dao.BookDao;
import com.biz.oracle.persistence.dao.BookDaoImp;

public class BookCUDServiceV1 {


	private BookDao bookDao = null;
	private Scanner scanner = null;
	
	public BookCUDServiceV1() {
		scanner = new Scanner(System.in);
		bookDao = new BookDaoImp();
	}
	
	public void inputBook() {
		
		while(true) {
			
			System.out.println("=======================");
			System.out.println("도서정보 등록");
			System.out.println("=======================");

			String strB_name = null;
			while(true) {
				System.out.print("1. 도서명(-Q:quit) >> ");
				strB_name = scanner.nextLine();
				if(strB_name.equals("-Q")) break;
				if(strB_name.isEmpty()) {
					System.out.println("도서명은 반드시 입력해야 합니다");
					continue;
				}
				break;
			}
			if(strB_name.equals("-Q")) break;

			System.out.print("2. 출판사(-Q:quit) >> ");
			String strB_comp = scanner.nextLine();
			if(strB_comp.equals("-Q")) break;
			
			System.out.print("3. 저자(-Q:quit) >> ");
			String strB_writer = scanner.nextLine();
			if(strB_writer.equals("-Q")) break;
			
			String strB_price = null;
			int intB_price = 0;
			while(true) {
				try {
					System.out.print("4. 가격(-Q:quit) >> ");
					strB_price = scanner.nextLine();
					intB_price = Integer.valueOf(strB_price);
					if(strB_price.equals("-Q")) break;
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("가격은 숫자로만 입력!!");
					continue;
				}
				break;
			}
			if(strB_price.equals("-Q")) break;
			
			BookDTO bookDTO = BookDTO.builder()
					.b_name(strB_name)
					.b_comp(strB_comp)
					.b_writer(strB_writer)
					.b_price(intB_price)
					.build();

			int ret = bookDao.insert(bookDTO);
			if(ret > 0) 
				System.out.println("도서정보 저장완료");
			else
				System.out.println("도서정보 저장실패~~~");
			
		}
		
	}

	public void deleteBook() {

		while(true) {
			System.out.println("===================");
			System.out.print("삭제할 코드(-Q :quit) >>");
			String strCode = scanner.nextLine();
			
			if(strCode.equals("-Q")) break;
			
			BookDTO bookDTO = bookDao.findById(strCode);
			if(bookDTO == null) {
				System.out.println("도서 코드가 없습니다");
				continue;
			}
			bookDao.delete(strCode);
		}
	}

	public void updateBook() {

		System.out.println("===================");
		System.out.println("도서정보 수정");
		System.out.println("===================");
		System.out.print("수정할 도서코드(-Q:quit) >> ");
		String strCode = scanner.nextLine();
		if(strCode.equals("-Q"))  ; // 입력을 끝내기
		
		// 키보드로 입력받은 코드에 해당하는 도서정보를 가져오기
		BookDTO bookDTO = bookDao.findById(strCode);
		/*
		 * 보통의 경우 PK를 수정하는 프로세스는 좋지 않다.
		 * PK를 수정해야 할 경우는
		 * 기존의 Data를 삭제하고 
		 * 		새로운 데이터를 INSERT 하거나
		 * 기존의 Data는 그대로 유지하고 
		 * 		새로운 데이터를 INSERT 한다.
		 */
		// 각 항목별로 값을 수정
		System.out.printf("변경할 도서명(%s)",bookDTO.getB_name());
		String strName = scanner.nextLine();
		
		// 새로운 도서명을 입력했을때는
		// bookDTO의 도서명 필드를 새로운 도서명으로 대치하고
		// 그냥 Enter만 입력했을때는 변경하지 않는다.
		// 실수로 공백(space)가 입력될때를 대비하여
		// 입력된 도서명의 앞뒤 공백을 제거하고 검사
		// strName.trim().length() : 객체의 chainnig 방법
		if(strName.trim().length() > 0) {
			bookDTO.setB_name(strName.trim());
		}
		
		System.out.printf("출판사(%s)",bookDTO.getB_comp());
		String strComp = scanner.nextLine();
		if(strComp.trim().length() > 0) {
			bookDTO.setB_comp(strComp.trim());
		}
		
		System.out.printf("저자(%s)",bookDTO.getB_writer());
		String strWriter = scanner.nextLine();
		if(strWriter.trim().length() > 0) {
			bookDTO.setB_writer(strWriter.trim());
		}
		
		System.out.printf("가격(%d)", bookDTO.getB_price());
		String strPrice = scanner.nextLine();
		int intPrice = 0;
		
		// 입력된 가격을 숫자로 변환하는 코드에서
		// 만약 값을 입력하지 않고 Enter를 누르면
		// NumberFormatException이 발생하는 것을
		// 역 이용하여
		// 만약 값을 입력하면 해당 값을 DTO에 저장하고
		// 그렇지 않으면 건너뛰도록 코딩
		try {
			intPrice = Integer.valueOf(strPrice);
			bookDTO.setB_price(intPrice);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		// 여기 도착했을때
		// bookDTO에 담긴 값은
		// 처음에 table에서 읽은 값이 저장되어 있거나
		// 중간에 키보드로 입력한 값으로 변경되었거나 한다.
		
		int ret = bookDao.update(bookDTO);
		if(ret > 0) {
			System.out.println("도서정보를 변경했습니다");
		} else {
			System.out.println("도서정보 변경 실패!!!");
		}
	}
}
