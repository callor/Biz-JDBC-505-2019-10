package com.biz.iolist.service.iolist.view;

import java.util.List;

import com.biz.iolist.config.DBConnection;
import com.biz.iolist.dao.IolistViewDao;
import com.biz.iolist.persistence.IolistVO;

public class IolistViewServiceV1 {

	IolistViewDao ioViewDao ;
	
	public IolistViewServiceV1() {
		ioViewDao = DBConnection.getSqlSessionFactory()
					.openSession(true)
					.getMapper(IolistViewDao.class);
	}

	protected void viewList(List<IolistVO> iolist) {
		System.out.println("=================================================");
		System.out.println("매입매출정보");
		System.out.println("=================================================");
		System.out.println("SEQ\t거래일자\t구분\t거래처\t상품\t수량\t단가\t합계");
		System.out.println("--------------------------------------------------");
		for(IolistVO vo : iolist) {
			this.viewItem(vo);
		}
		System.out.println("=================================================");
	}
	
	protected void viewItem(IolistVO vo) {
		System.out.print(vo.getIo_seq() + "\t");
		System.out.print(vo.getIo_date() + "\t");			
		System.out.print(vo.getIo_inout() + "\t");
		System.out.printf("(%s)%s\t",vo.getIo_dcode(),vo.getIo_dname());
		System.out.printf("(%s)%s\t",vo.getIo_pcode(),vo.getIo_pname());
		System.out.print(vo.getIo_qty() + "\t");
		System.out.print(vo.getIo_price() + "\t");
		System.out.print(vo.getIo_total() + "\n");
	}
	
	public void viewAllList() {
		List<IolistVO> iolist = ioViewDao.selectAll();
		if(iolist != null && iolist.size() > 0) {
			this.viewList(iolist);
		}
	}

	// 상품코드를 매개변수로 받아 리스트 출력
	public void viewListByPCode(String pcode) {
		List<IolistVO> iolist = ioViewDao.findByPCode(pcode);
		if(iolist != null && iolist.size() > 0) {
			this.viewList(iolist);
		}
	}

	// 상품이름을 매개변수로 받아 리스트 출력
	public void viewListByPName(String pname) {
		List<IolistVO> iolist = ioViewDao.findByPName(pname);
		if(iolist != null && iolist.size() > 0) {
			this.viewList(iolist);
		}
	}

	// 거래처코드 매개변수로 받아 리스트 출력
	public void viewListByDCode(String dcode) {
		List<IolistVO> iolist = ioViewDao.findByDCode(dcode);
		if(iolist != null && iolist.size() > 0) {
			this.viewList(iolist);
		}
	}

	// 거래처명을 매개변수로 받아 리스트 출력
	public void viewListByDName(String dname) {
		List<IolistVO> iolist = ioViewDao.findByDName(dname);
		if(iolist != null && iolist.size() > 0) {
			this.viewList(iolist);
		}
	}
	
}
