package com.biz.grade.exec;

import java.util.List;
import java.util.Scanner;

import com.biz.grade.persistence.ScoreVO;
import com.biz.grade.service.ScoreServiceV2;
import com.biz.grade.service.extend.ScoreServiceV2Ext;

public class ScoreEx_02 {

	public static void main(String[] args) {

		ScoreServiceV2 sc = new ScoreServiceV2Ext();
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			System.out.println("======================");
			System.out.println("이름으로 성적표 검색");
			System.out.println("======================");
			System.out.print("이름 (-Q:quit) >> ");
			String strName = scanner.nextLine();
			if(strName.equals("-Q")) break;
			
			List<ScoreVO> scoreList = sc.findByStName(strName);
			if(scoreList == null || scoreList.size() < 1) {
				System.out.println("데이터가 없음!!");
				System.out.println("학생이름을 다시 입력!!");
				continue;
			}
			for(ScoreVO vo : scoreList) {
				System.out.println(vo.toString());
			}
			
		}
		System.out.println("Good Bye!!!");
		
		
		
	}

}
