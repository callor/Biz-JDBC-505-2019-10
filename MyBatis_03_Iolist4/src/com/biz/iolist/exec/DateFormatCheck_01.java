package com.biz.iolist.exec;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateFormatCheck_01 {

	public static void main(String[] args) {

		/*
		 * SimpleDateFormat과 try{} 을 사용한 방법
		 * 
		 * 입력하는 날짜형식을 지정하고 싶을때
		 * 입력하는 사람이 지정된 형식대로 입력하지 않으면
		 * 메시지를 보여주고 다시 입력받도록 할수 있다.
		 * 
		 */
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
		
		try {
			sd.parse("201901");
		} catch (ParseException e) {
			System.out.println("날짜 형식이 잘못되었습니다");
		}
		
	}

}
