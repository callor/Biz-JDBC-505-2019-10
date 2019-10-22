package com.biz.oracle.persistence;

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
public class BookDTO {

	private String b_code;		//	varchar2(5 byte)
	private String b_name;		//	nvarchar2(50 char)
	private String b_comp;		//	nvarchar2(50 char)
	private String b_writer;	//	nvarchar2(50 char)
	private int b_price;		//	number
	
}
