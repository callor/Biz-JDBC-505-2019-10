package com.biz.hello;

public class PersonClass {

	public void add() {
		System.out.println("나는 Person 클래스의 add 메서드");
	}
	
	public void add(int n1, int n2) {
		System.out.println("두수의 합? " + (n1 + n2));
	}
	
	public String add(String s1, String s2) {
		return s1 + s2;
	}
	
}
