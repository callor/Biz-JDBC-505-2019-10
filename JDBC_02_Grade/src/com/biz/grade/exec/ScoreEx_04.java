package com.biz.grade.exec;

import java.util.Scanner;

import com.biz.grade.persistence.ScoreDTO;
import com.biz.grade.persistence.StudentDTO;
import com.biz.grade.service.ScoreService;
import com.biz.grade.service.ScoreServiceV1;
import com.biz.grade.service.StudentService;
import com.biz.grade.service.StudentServiceV1;

public class ScoreEx_04 {

	public static void main(String[] args) {

		StudentService st = new StudentServiceV1();
		ScoreService sc = new ScoreServiceV1();
		Scanner scanner = new Scanner(System.in);
		// Random rnd = new Random();
		
		while(true) {
			
			System.out.println("===================");
			System.out.println("성적입력");
			System.out.println("===================");
			System.out.print("학번 >> ");
			String strNum = scanner.nextLine();
			
			/*
			 * 
			 * 성적정보를 추가하려고 하는데
			 * 학번을 입력했을때
			 * 학생정보 테이블에 학번을 조회하여
			 * 만약 아직 등록되지 않은 학번이라면
			 * 성적정보를 입력할수 없도록
			 * 	(오류가 발생할 것이이므로
			 *  	: score와 student 테이블이 참조무결성(FK) 설정이
			 *  	되어 있기 때문에)
			 * 미리 입력 사용자에게 공지 하는 효과
			 * 
			 * 최종 DB SQL이 실행되면서 발생할수 있는 오류 상황을
			 * 코드에서 미리 방지하는 효과
			 * 
			 * ==> Validation 처리
			 * 
			 */
			StudentDTO stDto = st.findById(strNum);
			if(stDto == null) {
				System.out.println("학생정보에 없는 학번입니다!!");
				System.out.println("학생정보를 먼저 등록해야");
				System.out.println("성적을 입력할수 있습니다");
				continue;
			}
			
			System.out.print("과목코드 >> ");
			String strSubject = scanner.nextLine();
			/*
			 * 과목table에서 과목코들 조회한 후 없으면
			 * 메시지 보여주는 코드가 필요
			 */
			System.out.print("점수 >>");
			String strScore = scanner.nextLine();
			int intScore = Integer.valueOf(strScore);

			// score테이블의 PK인 s_id 값을 random으로 생성
			long s_id = (long)(Math.random() * 1000000);
			ScoreDTO scoreDTO = ScoreDTO.builder()
					.s_id(s_id)
					.s_std(strNum)
					.s_score(intScore)
					.s_subject(strSubject)
					.build();
			
			int ret = sc.insert(scoreDTO);
			// if(ret == 1) 이런 코드 금지!!!!
			if(ret > 0) {
				System.out.println("데이터 추가 완료");
			} else {
				System.out.println("데이터 추가 실패");
			}
		}
	}
}
