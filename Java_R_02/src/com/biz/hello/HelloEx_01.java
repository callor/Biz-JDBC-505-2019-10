package com.biz.hello;

public class HelloEx_01 {

	/*
	 * main() method에서
	 * add() method를 호출하는 코드
	 */
	public static void main(String[] args) {
		// 현재 클래스(HelloEx_01)에 선언된 add() method를 
		// 호출하는 방법
		add();
		
		// AddClass에 선언된 add() method를 호출하고 싶다.
		// AddClass.add() 이렇게는 안된다.
		// 다른 클래스에 있는 method는 원칙적으로 
		// 직접 호출이 안된다.
		
		//1.클래스를 객체선언하고 초기화를 해주어 한다
		//  클래스를 객체로 선언하고 초기화 하는 것을
		//	클래스의 인스턴스를 만든다 라고 한다.
		
		// 클래스를 객체로 선언한다.
		// 클래스(Class)
		//		 객체(OBject)
		AddClass addClass; // 선언
		
		// addClass를 사용해서 뭔가 일을 
		// 		수행하기 위한 준비
		addClass = new AddClass() ; // 초기화, 생성
		
		// AddClass에 있는 add() method를 호출하겠다 라는 것
		addClass.add();
		
	}
	public static void add() {
		
	}

}
