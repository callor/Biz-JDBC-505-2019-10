package com.biz.iolist.persistence;

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
public class IolistDTO {

	private long io_seq;//	number
	private String io_date;//	varchar2(10 byte)
	private String io_inout;//	nvarchar2(2 char)
	private int io_qty;//	number
	private int io_price;//	number
	private int io_total;//	number
	private String io_pcode;//	varchar2(5 byte)
	private String io_dcode;//	varchar2(5 byte)
	
}
