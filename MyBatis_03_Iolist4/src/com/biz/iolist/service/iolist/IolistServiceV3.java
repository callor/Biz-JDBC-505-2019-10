package com.biz.iolist.service.iolist;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.biz.iolist.persistence.DeptDTO;
import com.biz.iolist.persistence.IolistDTO;
import com.biz.iolist.persistence.IolistVO;
import com.biz.iolist.persistence.ProductDTO;

public class IolistServiceV3 extends IolistServiceV2 {
	
	@Override
	protected void update() {
		System.out.println("=================");
		System.out.println("매입매출수정");
		System.out.println("=================");

		System.out.print("거래처명 >> ");
		String strDName = scanner.nextLine();
		if(strDName.trim().isEmpty()) {
			ioView.viewAllList();
		} else {
			ioView.viewListByDName(strDName);	
		}
		System.out.print("수정할 SEQ >> ");
		String strSEQ = scanner.nextLine();
		
		long longSEQ = 0 ;
		try {
			longSEQ = Long.valueOf(strSEQ);
		} catch (Exception e) {
			System.out.println("SEQ 형식이 틀렸습니다");
			return;
		}
		
		// SEQ에 해당하는 iolist 가져오기
		IolistDTO iolistDTO = iolistDao.findById(longSEQ);
		
		while (true) {
			
			System.out.printf("거래구분[%s](1:매입, 2:매출, -1:종료) >> ",iolistDTO.getIo_inout());
			String strInout = scanner.nextLine();
			try {
				
				int intInout = Integer.valueOf(strInout);
				if(intInout < 0) break;
				
				if(intInout == 1) {
					iolistDTO.setIo_inout("매입");	
				} else if(intInout == 2) {
					iolistDTO.setIo_inout("매출");
				} else {
					System.out.println("매입, 매출구분을 다시 선택하세요");
					continue;
				}

			} catch (Exception e) {
				System.out.println("매입 매출구분을 다시 입력해 주세요");
				continue;
			}
			break;
		}

		if(iolistDTO.getIo_inout().isEmpty()) return;
		
		while(true) {
			SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
			
			// Date date = new Date();
			// String curDate = sd.format(date);
			
			//System.out.printf("거래일자(%s)",curDate);
			System.out.printf("거래일자(%s)",iolistDTO.getIo_date());
			
			String strDate = scanner.nextLine();
			if(strDate.trim().isEmpty()) {
				// iolistDTO.setIo_date(curDate);
			} else {
				try {
					sd.parse(strDate);
				} catch (ParseException e) {
					System.out.println("날짜형식이 잘못되었습니다");
					continue;
				}
				iolistDTO.setIo_date(strDate);
			}
			break;
		}
		
		while(true) {
			System.out.print("거래처명 입력(-Q:quit) >> ");
			strDName = scanner.nextLine();
			
			if(strDName.equals("-Q")) break;
			
			List<DeptDTO> deptList = deptDao.findByName(strDName);
			if(deptList != null && deptList.size() > 0) {
				
				for(DeptDTO dto : deptList) {
					System.out.println(dto.toString());
				}
				System.out.println("--------------------------");
				System.out.print("거래처코드 입력 >> ");
				String strDCode = scanner.nextLine();
				
				DeptDTO deptDTO = deptDao.findById(strDCode);
				if(deptDTO == null) {
					System.out.println("거래코드 없음 >> ");
					continue;
				} else {
					iolistDTO.setIo_dcode(strDCode);
				}
			} else {
				continue;
			}
			break;
		}
		if(iolistDTO.getIo_dcode().isEmpty()) return;
		
		while(true) {
			System.out.print("상품명 입력(-Q:quit) >> ");
			String strPName = scanner.nextLine();
			
			if(strPName.equals("-Q")) break;
			
			List<ProductDTO> proList = proDao.findByName(strPName);
			
			if(proList == null || proList.size() < 1) {
				System.out.println("찾는 상품이 없음");
				continue;
			} else {
				
				for(ProductDTO dto : proList) {
					System.out.println(dto.toString());
				}
				System.out.print("상품코드 >> ");
				String strPCode = scanner.nextLine();
				
				ProductDTO proDTO = proDao.findById(strPCode);
				if(proDTO == null) {
					System.out.println("상품코드를 확인하세요");
					continue;
				} else {
					iolistDTO.setIo_pcode(strPCode);
					int intPrice = iolistDTO.getIo_inout().equals("매입")
							? proDTO.getP_iprice()
							: proDTO.getP_oprice();
					iolistDTO.setIo_price(intPrice);
				}
			}
			break;
		}
		
		if(iolistDTO.getIo_pcode().isEmpty()) return;
		
		while(true) {
			System.out.printf("단가입력(%d) >> ",iolistDTO.getIo_price());
			String strPrice = scanner.nextLine();
			
			try {
				int price = Integer.valueOf(strPrice);
				iolistDTO.setIo_price(price);
			} catch (Exception e) {
				// TODO: handle exception
			}
			break;
		}
		
		while(true) {
			System.out.print("수량입력 >> ");
			String strQty = scanner.nextLine();
			
			try {
				int intQty = Integer.valueOf(strQty);
				iolistDTO.setIo_qty(intQty);
			} catch (Exception e) {
				System.out.println("수량은 숫자로만 입력!!");
				continue;
			}
			break;
		}
		
		int intTotal = iolistDTO.getIo_price() * iolistDTO.getIo_qty();
		iolistDTO.setIo_total(intTotal);
		
		int ret = iolistDao.update(iolistDTO);
		if(ret > 0) System.out.println("데이터 변경 완료");
		else System.out.println("데이터 변경 실패");

	}
	/*
	 * 매입매출 등록
	 * 
	 * 1. 매입,매출구분입력
	 * 
	 * 2. 날짜 현재날짜로 자동등록 
	 * 3. 거래처검색 거래처코드입력 입력한코드 검증
	 * 
	 * 4. 상품검색 상품코드입력 입력한코드 검증
	 * 
	 * 매입, 매출에 따라서 5. 매입단가, 매출단가 가져오기(세팅)
	 * 
	 * 6. 수량입력
	 * 
	 * 단가 * 수량 매입합계 또는 매출합계 계산하기
	 * 
	 * insert
	 * 
	 * 추가된 데이터 보여주기
	 */

}
