package com.biz.iolist.service.pro;

import com.biz.iolist.persistence.ProductDTO;

public class ProductServiceV3 extends ProductServiceV2 {
	
	
	public void menuProduct() {
		System.out.println("==============================");
		System.out.println("대한쇼핑몰 상품관리 시스템 v3");
		System.out.println("==============================");
		System.out.println("1.등록  2.수정  3.삭제  4.검색 0.끝");
		System.out.print("업무선택 >> ");
		String strMenu = scanner.nextLine();
		int intMenu = Integer.valueOf(strMenu) ;
		
		if(intMenu == 1) {
			this.insertProduct();
		} else if(intMenu == 2) {
			
			this.searchPName();
			this.proUpdate();
		
		} else if(intMenu == 3) {
			// 상품으로 리스트 검출
			this.searchPName();
			// 상품코드를 입력받고 삭제
			this.deleteProduct();
		
		} else if(intMenu == 4) {
		
			this.searchPName();
		
		} else if(intMenu == 0) {
			
		}
 		
		
	}
	
	/*
	 * 상품정보들을 입력받아서 insert 수행
	 * 상품코르를 입력받아서
	 * 있으면 다시 입력하도록
	 * 없으면 다음으로 진행
	 * 1. 상품코드를 어떻게 할것인가?
	 * 		가. 자동으로 생성하기
	 * 		나. 직접 입력하기(이미 문서로 작성된 경우)
	 * 
	 * 2. 상품이름을 입력하는데, 완전히 일치하는 상품이 이미 있는 경우
	 * 		가. 코드가 다르면 그냥 입력하기
	 * 		나. 코드가 다르고 단가부분이 다르면 그냥 입력하기
	 * 			상품정보 : 상품이름, 품목, 주매입처
	 * 		다. 같은 상품이름 입력 금지
	 * 
	 * 3. 단가부분
	 * 		가. 매입단가를 입력하면, 표준 판매단가를 계산하기
	 * 		나. 매입단가, 매출단가를 별도 입력
	 * 		다. 매입단가일경우 VAT 포함여부
	 * 		다. 매출단가, 소매점에서는 VAT 포함이 기본
	 * 			도매점일경우 VAT 포함여부
	 * 
	 * 
	 */
	public void insertProduct() {
		
		System.out.println("===========================");
		
		
		String strPCode;
		while(true) {
			System.out.print("상품코드(Enter : 자동생성, Q:quit)");
			strPCode = scanner.nextLine();
			if(strPCode.equals("-Q")) break;
			if(strPCode.trim().isEmpty()) {

				// 코드 자동생성
				String strTMPCode = proDao.getMaxPCode();
				
				// strTMPCode = P0393 이라면 
				
				// 그중에서 0393만 추출하여 숫자로 변환
				int intPCode = Integer.valueOf(strTMPCode.substring(1));
				
				// 1을 증가시키기 : 394
				intPCode ++;
				
				// 현재코드의 첫번째 문자열을 잘라내고
				strPCode = strTMPCode.substring(0, 1);
				
				// 394를 0394문자열로 변환시키고 strPCode와 연결
				strPCode += String.format("%04d",intPCode);
				
				// P0394
				System.out.println("생성된코드 : " + strPCode);
				System.out.println("사용하시겠습니까?(Enter:Yes)");
				String strYesNo = scanner.nextLine();
				if(strYesNo.trim().isEmpty()) break;
				else continue;
				
			} 
			
			if(strPCode.length() != 5) {
				System.out.println("상품코드의 길이 규칙에 맞지 않음");
				// 조치취하기
				continue;
			}
			
			strPCode = strPCode.toUpperCase();
			if(!strPCode.substring(0,1).equalsIgnoreCase("P")) {
				System.out.println("상품코드는 첫글자가 P로 시작되어야 함");
				continue;
			}
			
			try {
				Integer.valueOf(strPCode.substring(1));
			} catch (Exception e) {
				System.out.println("상품코드2번째 이후는 숫자만 올수 있음");
				continue;
			}
			
			if(proDao.findById(strPCode) != null) {
				System.out.println("이미 등록된(사용중인)코드!!");
				continue;
			}
			break;

		} // pcode 입력 끝
		if(strPCode.equals("-Q")) return;

		// 상품이름 입력
		String strPName ;
		while(true) {
			
			System.out.print("상품이름(-Q:quit) ");
			strPName = scanner.nextLine();
			if(strPName.equals("-Q")) break;
			
			if(strPName.trim().isEmpty()) {
				System.out.println("상품이름은 반드시 입력해야 함");
				continue;
			}
			
			ProductDTO proDTO = proDao.findBySName(strPName);
			if(proDTO != null) {
				System.out.println("=========================");
				System.out.println("같은이름의 상품있음!!");
				System.out.println("-------------------------");
				System.out.println("상품코드:" +proDTO.getP_name());
				System.out.println("품목:" );
				System.out.println("주매입처:");
				System.out.println("매입단가:" +proDTO.getP_iprice());
				System.out.println("매출단가:" +proDTO.getP_oprice());
				System.out.println("-------------------------");
				System.out.print("사용하시겠습니까?(Enter:사용,NO:다시입력)");
				String yesNo = scanner.nextLine();
				if(yesNo.trim().isEmpty()) break;
				continue;
			}
		} // 상품이름 입력 끝
		
		
	}
	
	/*
	 * 상품코드를 입력받아서 delete 수행
	 */
	public void deleteProduct() {
		
		System.out.println("삭제할 상품코드 >> ");
		String strPCode = scanner.nextLine();
		
		// 코드가 정상적인지 검증
		ProductDTO proDTO = this.viewPDetail(strPCode);
		
		if(proDTO == null) {
			System.out.println("상품코드가 없습니다");
			return;
		}
		
		int ret = proDao.delete(strPCode);
		if(ret > 0) {
			System.out.println("정상적으로 삭제 완료");
		} else {
			System.out.println("삭제실패");
		}
	}

}
