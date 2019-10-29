package com.biz.hello;

public class HelloEx_04 {

	public static void main(String[] args) {
		add();
		add(30,40);
		/*
		 * add(int n1 = 30, int n2 = 40)
		 * sum n1 + n2
		 * sysout(sum)
		 */
		
		add(40,50);
		add(50,60);
		add(60,70);
		add(70,80);
		잡채만들기(100);
		잡채만들기(200);
		
	}
	
	public static void 잡채만들기(int 몇명) {
		System.out.println("잡채 " + 몇명 + " 명분 만들기");
	}

	
	public static void add(int n1, int n2) {
		int sum = n1 + n2;
		System.out.println(sum);
	}
	
	public static void add() {
		int num1 = 40;
		int num2 = 50;
		int sum = num1 + num2;
		System.out.println(sum);
	}
	
	
	

}
