package com.biz.hello;

public class HelloEx_03 {

	public static void main(String[] args) {

		AddClass aClass = new AddClass();
		PersonClass bClass = new PersonClass();
		
		aClass.add();
		bClass.add();
		
		aClass.add(50,50);
		bClass.add(50,50);
		
		int ret1 = aClass.add("A","B");
		String ret2 = bClass.add("A","B");
		System.out.println(ret1);
		System.out.println(ret2);
	
	}

}
