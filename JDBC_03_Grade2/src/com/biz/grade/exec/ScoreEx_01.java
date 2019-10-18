package com.biz.grade.exec;

import java.util.List;

import com.biz.grade.persistence.domain.ScoreVO;
import com.biz.grade.service.ScoreServiceV2;
import com.biz.grade.service.extend.ScoreServiceV2Ext;

public class ScoreEx_01 {

	public static void main(String[] args) {

		ScoreServiceV2 sc = new ScoreServiceV2Ext();
		
		List<ScoreVO> scoreList = sc.selectAll();
		
		if(scoreList == null || scoreList.size() < 1) {
			System.out.println("데이터가 없습니다");
			
			// main() method에서 return를 실행하면
			// 프로젝트를 종료하라!!!
			return ;
		}
		
		for(ScoreVO vo : scoreList) {
			System.out.println(vo.toString());
		}
		
	}

}
