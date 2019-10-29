package com.biz.hello;

import java.util.ArrayList;
import java.util.List;

public class HelloEx_07 {

	
	public static void main(String[] args) {
		int a = add();
		int b = add(30,40);
		String c = add("Republic","Korea");
		
		int d;
		d = add(50,60);
		
	}
	public static void add() {
		return;
	}
	public static int add(int n1, int n2) {
		return 50 + 40;		
	}
	public static String add(String s1, String s2) {
		return "대한민국";		
	}
	
	public static List<String> add(List<String> sList) {
		return new ArrayList<String>();
	}
	
}
