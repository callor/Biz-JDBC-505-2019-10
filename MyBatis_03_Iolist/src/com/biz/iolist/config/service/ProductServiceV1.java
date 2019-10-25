package com.biz.iolist.config.service;

import java.util.List;
import java.util.Scanner;

import com.biz.iolist.config.DBConnection;
import com.biz.iolist.dao.ProductDao;
import com.biz.iolist.persistence.ProductDTO;

public class ProductServiceV1 {

	protected ProductDao proDao;
	protected Scanner scanner ;
	public ProductServiceV1() {
		
		scanner = new Scanner(System.in);
		this.proDao = DBConnection
						.getSqlSessionFactory()
						.openSession(true)
						.getMapper(ProductDao.class);
	}
	
	public void proUpdate() {
		
//		List<ProductDTO> proList = proDao.selectAll();
// 		for(ProductDTO dto : proList) {
// 			System.out.println(dto.toString());
// 		}

		System.out.println("==========================");
 		System.out.print("수정할 상품코드");
 		String strPCode = scanner.nextLine();
 		
 		// 입력한 상품코드를 대문자로 변경
 		strPCode = strPCode.toUpperCase();
 		
 		// 입력한 상품코드를 다시 조회
 		ProductDTO proDTO = proDao.findById(strPCode);
 		System.out.println("================================");
 		System.out.printf("상품코드 : %s\n",proDTO.getP_code());
 		System.out.printf("상품이름 : %s\n",proDTO.getP_name());
 		System.out.printf("매입단가 : %d\n",proDTO.getP_iprice());
 		System.out.printf("매출단가 : %d\n",proDTO.getP_oprice());
 		
 		/*
 		 * 3항연산자
 		 * 조건식 ? true return : false return
 		 * 조건식이 참이면 method가 true를 return하는 것과 같고
 		 * 그렇지 않으면 false를 return 하는 것과 같다.
 		 * 
 		 * 변수에 조건에 따라 다른값을 채우고 싶을때
 		 * 
 		 * 변수 = 조건식 ? true : false 
 		 * s = a == 1 ? "참" : "거짓"
 		 * 변수 a에 담긴 값이 1이면 변수 s에 "참"을 채우고
 		 * 그렇지 않으면 "거짓"을 채워라
 		 */
 		String strVAT 
 			= proDTO.getP_vat().equals("1") ? "과세" : "면세"  ;
 		System.out.printf("과세여부 : %s\n",strVAT);
 		System.out.println("================================");
 		
 		
 		System.out.printf("변경할 상품명(%s) >> ",proDTO.getP_name());
 		String strName = scanner.nextLine();
		
 		// strName 변수에 아무런 문자열도 들어있지 않다면
 		// 그냥 Enter만 눌렀을 경우
 		// if(strName.trim().length() < 1)
 		// ! 그렇지 않으면
 		if(!strName.trim().isEmpty()) {
 			proDTO.setP_name(strName);
 		}

 		System.out.printf("변경할 매입단가(%d) >> ",proDTO.getP_iprice());
 		String strIPrice = scanner.nextLine();
 		
 		/*
 		 * 만약 매입단가를 입력하지 않고 그냥 Enter만 눌렀다면
 		 * Integer.valudOf(strIPrice) 에서 Exception이 발생할 것이다.
 		 * try{} 감싸진 코드에서Exception이 발생을하면
 		 * 나머지 코드는 무시되고 catch() jump한다.
 		 * 
 		 * 이런 기능을 역 이용하여
 		 * 값을 입력하지 않거나, 문자열등을 포함하면
 		 * 원래 proDTO의 iprice 값을 변경하지 않도록 한다.
 		 */
 		try {
			proDTO.setP_iprice(Integer.valueOf(strIPrice));
		} catch (Exception e) {
			// TODO: handle exception
		}

 		System.out.printf("변경할 매출단가(%d) >> ",proDTO.getP_oprice());
 		String strOPrice = scanner.nextLine();
 		try {
			proDTO.setP_oprice(Integer.valueOf(strOPrice));
		} catch (Exception e) {
			// TODO: handle exception
		}


 		/* 
 		 * proDTO의 필드변수들은
 		 * 각 항목을 입력받을때 Enter만 입력했다면
 		 * 원래 DB table에서 가져온 값이 그대로 유지 될것이고
 		 * 
 		 * 값을 입력했다면
 		 * 새로운 값으로 변경 되어 있을 것이다.
 		 */

 		int ret = proDao.update(proDTO);
 		if(ret > 0) {
 			System.out.println("데이터 변경 완료!!");
 		} else {
 			System.out.println("데이터 변경 실패!!");
 		}
 		
 		// 확인작업
 		System.out.println(proDao.findById(strPCode).toString());
 		
	}
}
