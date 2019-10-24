package com.biz.dbms.persistence;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// AllArg.., Getter, Setter, method들이 없으면
// mybatis가 제대로 작동하지 않는다.
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class BBsDTO {
	
	/*
	 * DTO, VO를 생성할때
	 * 필드(맴버변수)이름은 TABLE의 칼럼 이름과 같게 설정
	 * mybatis 자동 setter, getter 호출 기능이 잘 작동한다.
	 */
	private long bs_id;		//	number
	private String bs_date;	//	varchar2(10 byte)
	private String bs_time;	//	varchar2(10 byte)
	private String bs_writer;	//	nvarchar2(20 char)
	private String bs_subject;	//	nvarchar2(125 char)
	private String bs_text;	//	nvarchar2(1000 char)
	private int bs_count;	//	number
	
}
