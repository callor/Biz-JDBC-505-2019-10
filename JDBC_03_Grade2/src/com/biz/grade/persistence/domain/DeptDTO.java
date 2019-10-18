package com.biz.grade.persistence.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class DeptDTO {
	private String d_num;	//	varchar2(5 byte)
	private String d_name;	//	nvarchar2(30 char)
	private String d_pro;	//	nvarchar2(20 char)
	private String d_tel;	//	varchar2(20 byte)
}
