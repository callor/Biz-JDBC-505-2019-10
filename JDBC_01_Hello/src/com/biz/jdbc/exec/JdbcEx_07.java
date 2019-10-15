package com.biz.jdbc.exec;

import java.util.List;

import com.biz.jdbc.domain.ScoreVO;
import com.biz.jdbc.service.ScoreJDBCServiceV3;

public class JdbcEx_07 {

	public static void main(String[] args) {

		ScoreJDBCServiceV3 sc = new ScoreJDBCServiceV3();
		
		ScoreVO scoreVO = ScoreVO.builder()
				.s_id(607)
				.s_std("이몽룡")
				.s_score(100)
				.s_rem("연습").build();
		
		int ret = sc.insert(scoreVO);
		System.out.println(ret);
		
		List<ScoreVO> scList = sc.findByName("이몽룡");
		for(ScoreVO s : scList) {
			System.out.println(s);
		}
	
	}

}
