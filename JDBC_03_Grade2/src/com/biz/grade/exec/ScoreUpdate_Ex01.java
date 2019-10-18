package com.biz.grade.exec;

import java.util.List;

import com.biz.grade.persistence.domain.ScoreDTO;
import com.biz.grade.persistence.domain.ScoreVO;
import com.biz.grade.service.ScoreServiceV3;

/*
 * 1.학생이름을 입력받아서
 * 2.학생정보 리스트를 보여주고
 * 3.학번입력받고
 * 4.학번에 해당하는 성적리스트 보여주고
 * 5.리스트를 보고 ID를 입력하면
 * 6.각 칼럼별로 
 * 	 값을 보여주고
 * 	 그냥 Enter를 입력하면 원래 값을 유지
 * 	 새로운 값을 입력하고 Enter를 입력하면 새로운 값으로 변경

 *  ID 100을 선택했다
 *  학번(T0020) >> Etner :  이경우는 T0020으로 그냥 유지 
 *  과목(S003) >> S004Enter : 이경우는 S004로 변경
 *  점수(33) >> 90Enter : 이경우도 90으로 변경
 */
public class ScoreUpdate_Ex01 {

	public static void main(String[] args) {
		ScoreServiceV3 sc = new ScoreServiceV3();
		ScoreDTO scoreDTO = null;
		
		
		List<ScoreVO> scList = sc.updateStudent();
		if(scList == null) {
			System.out.println("성적입력 종료!!");
			return ; // 프로젝트 종료
		}
		for(ScoreVO vo : scList) {
			System.out.print(vo.getS_id()+"\t");
			System.out.print(vo.getSb_name()+"\t");
			System.out.println(vo.getS_score());
		}

		ScoreVO scoreVO = sc.selectScore();
		if(scoreVO == null) {
			System.out.println("성적입력 종료!!");
			return ; // 프로젝트 종료
		}
		System.out.println(scoreVO.toString());

		int ret = sc.updateScore(scoreVO);
		if(ret > 0) {
			System.out.println("데이터 변경 완료");
		} else {
			System.out.println("데이터 변경 실패");
		}
		
		
		

	}

}
