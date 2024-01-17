package com.yedam.condition;

public class IFcCondition {
	public static void main(String[] args) {
		boolean isTrue = true;
		isTrue = isTrue != true;
		
		if(!!isTrue) {
			//실행구문.
			System.out.println("참값입니다.");
		}//if end
		else {
			System.out.println("거짓값입니다.");
		}//else end 
		
		int score = 80;
		if (score >= 90) {
			System.out.println("A학점");
		}//if end
		if/*else if*/ (score >=80) {
			System.out.println("B학점");
		}//else if end
		else {
			System.out.println("C학점");
		}//else end
		System.out.println("end of prog");
	}//main end
}//class end
