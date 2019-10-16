package com.biz.grade.persistence;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
/*
 * 
 * DBMS Table과 연관된 Class
 * VO(Value Object), DTO(Data Transfer Object)
 * - 공통기능
 * 		Table과 연된되어서 CRUD를 수행할때
 * 		데이터를 담아서 method간에 이동할때 사용
 * 
 * - DTO
 * 		물리적 Table과 연관(매핑)되어 완전한 CRUD를 수행할때
 * 		
 * - VO
 * 		VIEW Table, Join 된 SQL과 연관되어
 * 		주로 READ(=Retrieve 인출)용으로 사용
 *  
 */

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ScoreDTO {

	private long s_id;
	private String s_std; // 학번
	private String s_subject; // 과목코드
	private int s_score; // 과목점수
	private String s_rem; // 비고
	
}
