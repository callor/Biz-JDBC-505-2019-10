package com.biz.hello;

public class HelloEx_02 {

	public static void main(String[] args) {

		AddClass addClass;
		addClass = new AddClass();
		addClass.add();
		addClass.add(1,2);
		
		int ret = addClass.add("Korea","Republic");
		System.out.println(ret);
		
		AddClass addClass2 = new AddClass();
		addClass2.add();
		addClass2.add(50,60);
		
		int aa = addClass.add("A","B");
		System.out.println(aa);
		
	}

}
