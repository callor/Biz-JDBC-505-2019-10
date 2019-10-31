package com.biz.hello;

/*
 * AddClass 이름으로 클래스를 선언하고
 * 그 클래스 내부에 add() 라는 이름으로 method를 선언한 것
 */
public class AddClass {

	/*
	 * 그냥 호출만 하면
	 * 대한민국...Repulic of Korea까지 
	 * 문자열을 console에 보이기
	 */
	public void add() {
		System.out.println("대한민국만세");
		System.out.println("우리나라만세");
		System.out.println("Republic of Korea");
	}
	
	
	/*
	 * 2개의 정수형 값을 주입받고
	 * 그냥 무시하고
	 * console에 30+40은 70입니다 라고 출력
	 */
	public void add(int n1, int n2) {
		System.out.println("30+40은 70입니다");
	}
	
	/*
	 * 2개의 문자열형 값을 주입받고
	 * 그냥 무시하고
	 * 30+40의 계산값을
	 * 호출한 곳으로 return(되돌려준다)
	 * ==> 호출한 곳에서는 return 값을 int 형 변수에
	 * 		저장 해두고 사용할 수 있다
	 */
	public int add(String s1, String s2) {
		return 30+40;
	}
	
}
