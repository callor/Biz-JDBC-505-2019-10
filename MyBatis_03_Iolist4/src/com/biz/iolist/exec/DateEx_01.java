package com.biz.iolist.exec;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class DateEx_01 {

	public static void main(String[] args) {
		
		// 현재(시스템 날짜) 에서 14일 후 날짜 구하기)
		// 1.7 이하에서
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date(System.currentTimeMillis()));
		calendar.add(Calendar.DATE,14);
		
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
		String retDate = sd.format(calendar.getTime());
		System.out.println(retDate);
				
		//1.8 이상에서
		LocalDate localDate = LocalDate.now();
		localDate = localDate.plusDays(14);
		retDate = localDate.toString();
		System.out.println(retDate);
		
		
		String rent_due_date = "2019-10-30";
		String rent_date = "2019-10-31";
		
		// 반납예정일 < 반납일 : 포인트 0
		// 반납예정일 >= 반납일 : 포인트 5
		
		int diff = rent_date.compareTo(rent_due_date);
		System.out.println(diff);
		if(diff > 0) { // 1 이상이면 지연
			System.out.println("지연반납");
		} else { // 0이거나 -1이이면 정상
			System.out.println("정상반납");
		}
		
		
		
		
		
	}
}
