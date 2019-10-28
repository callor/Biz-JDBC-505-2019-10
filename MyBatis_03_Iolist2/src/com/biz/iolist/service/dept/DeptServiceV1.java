package com.biz.iolist.service.dept;

import java.util.List;
import java.util.Scanner;

import com.biz.iolist.config.DBConnection;
import com.biz.iolist.dao.DeptDao;
import com.biz.iolist.persistence.DeptDTO;

public class DeptServiceV1 {

	protected DeptDao deptDao;
	Scanner scanner ;
	
	public DeptServiceV1() {
		deptDao = DBConnection.getSqlSessionFactory()
					.openSession(true)
					.getMapper(DeptDao.class);
		scanner = new Scanner(System.in);
	}
	
	// deptDao.selectAll() 을 호출하여 전체 리스트를
	// 보여주는 method
	public void viewAllList() {
		
		List<DeptDTO> deptList = deptDao.selectAll();
		if(deptList == null || deptList.size() < 1) {
			System.out.println("리스트가 없음");
		} else {
			this.viewList(deptList);
		}

	}
	
	// 키보드에서 거래처이름을 입력하여
	// 거래처리스트를 보여주는 method
	public void viewNameList() {
		System.out.println("===============================");
		System.out.println("거래처 이름검색");
		System.out.println("===============================");
		System.out.print("거래처명 >> ");
		String strDName = scanner.nextLine();
		
		List<DeptDTO> deptList = null;
		if(strDName.trim().isEmpty()) {
			deptList = deptDao.selectAll();
		} else {
			deptList = deptDao.findByName(strDName);	
		}
		this.viewList(deptList);
	}
	
	// 키보드에서 거래처명과
	// 대표이름을 입력하여
	// 거래처리스트를 보여주는 method
	public void viewNameAndCeoList() {
		
		System.out.println("===============================");
		System.out.println("거래처, 대표 이름검색");
		System.out.println("===============================");

		System.out.print("거래처명 >> ");
		String strDName = scanner.nextLine();

		System.out.print("대표명 >> ");
		String strDCEO = scanner.nextLine();
		
		List<DeptDTO> deptList = null;

		// 거래처명, 대표명을 아무것도 입력하지 않았을때
		if(strDName.trim().isEmpty() && strDCEO.trim().isEmpty()) {
			deptList = deptDao.selectAll();

		// 거래처명만 입력하지 않았을때,
		// 대표명만 입력했을때 대표명으로 검색
		} else if(strDName.trim().isEmpty()){
			deptList = deptDao.findByCEO(strDCEO);
			
		// 대표명을 입력하지 않았을때,
		// 거래처명만 입력했을때 거래처명으로 검색	
		} else if(strDCEO.trim().isEmpty()){
			deptList = deptDao.findByName(strDName);	

		// 둘다 입력하면 거래처명과 대표명으로 검색	
		} else {
			deptList = deptDao.findByNameAndCEO(strDName, strDCEO);
		}
		this.viewList(deptList);

		
		
	}

	// 각 view에서 List를 출력할때 사용할 method
	// List를 반복하면서 deptDTO를 매개변수로 전달 
	protected void viewList(DeptDTO deptDTO) {
		System.out.print(deptDTO.getD_code() + "\t");
		System.out.print(deptDTO.getD_name() + "\t");
		System.out.print(deptDTO.getD_ceo() + "\t");
		System.out.print(deptDTO.getD_tel() + "\t");
		System.out.print(deptDTO.getD_addr() + "\n");
	}
	
	// List를 받아서 출력할때 사용할 method
	protected void viewList(List<DeptDTO> deptList) {
		
		System.out.println("=============================");
		System.out.println("거래처리스트");
		System.out.println("=============================");
		System.out.println("코드\t상호\t대표\t전화\t주소");
		System.out.println("-----------------------------");
		for(DeptDTO deptDTO : deptList) {
			this.viewList(deptDTO);
		}
		System.out.println("===============================");
		
	}
	
	
	
	
	
	
}
