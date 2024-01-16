package com.yedam.variable;

public class VariableExe4 {
	public static void main(String[] args) {
		// true/false.
		boolean isTrue = 10 > 20;
		
		isTrue = update(10);
		
		if(isTrue) {
			System.out.println("참값.");
		}else {
			System.out.println("거짓값.");
		}
		
		Member m1 = new Member();
		m1.name = "홍길동";
		m1.age = 20;
		m1.height = 167.8;
		
		Member m2 = new Member();
		m2.name ="홍길동";
		m2.age = 20;
		m2.height = 167.8;
		
		
		isTrue = m1.height > m2.height;
		isTrue = m1.age == m2.age;
		isTrue = m1 == m2;
//		System.out.println(m1);
//		System.out.println(m2);
		
		byte a = 10;
		int b = (int) a;
		System.out.println(b);
		
	}//end of main
	
	public static boolean update(int arg) {
		return arg % 2 == 0; 
	}//end of update.
}//end of class.
