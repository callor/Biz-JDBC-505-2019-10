package com.biz.iolist.exec;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class NumberCheck_01 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		// 1.8
		LocalDate localDate = LocalDate.now();
		int intYear = localDate.getYear();
		
		//1.7
		SimpleDateFormat sd = new SimpleDateFormat("yyyy");
		String curYear = sd.format(new Date());
		intYear = Integer.valueOf(curYear);
		
		while(true) {
			
			System.out.printf("연도를 입력하세요(%d)",intYear);
			String strYear = scan.nextLine();
			
			try {
				intYear = Integer.valueOf(strYear);
			} catch (Exception e) {
				if(strYear.trim().isEmpty()) {
					System.out.println("Enter를 누름");
					break;
				} else {
					System.out.println("숫자가 아님");
					continue;
				}
			}
			break;
		}
		System.out.printf("입력한 연도 = (%d)",intYear);
		
		
		
		
	}

}
