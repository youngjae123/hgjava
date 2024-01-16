package com.yedam.variable;

public class VariableExe1 {
	public void sum() {
		int n2;
	}
	public static void main(String[] args) {
		// let n ='10';
		// const obj = {name:"홍길동", age:20, showInfo(){} }
		int n1 = 2147483647; // int(기본데이터타입) wrapper클래스: Integer.
		n1 = -2147483647;
		
		System.out.println(Integer.MAX_VALUE);
		
		long n2 = 2147483647L;
		n2 = -2147483647L;
		
		double m3 = Math.random(); // 0~1임의 실수.
		
		int n4 = (int)(Math.random()* 10); //0~10 임의실수.
		
		String str = "홍길동";
		
//		int n2; 두번 선언이 불가.		
		byte b1 = 127;
		System.out.println(Short.MAX_VALUE);
		short s1 =32767;
		
		short s3 =(short) (s1 - 30); // int
		//왼쪽항 = 오른쪽항 : 항상 타입이 동일.
		double d1 = (double) 40;
	}
}
