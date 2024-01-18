package com.yedam.reference;

public class RefExe1 {
	public static void main(String[] args) {
		int n1 = 100;
		int n2 = 100;
		System.out.println(n1 == n2);
		
		String str1 = new String("홍길동");
		String str2 = new String("홍길동");
		System.out.println(str1 == str2);
		System.out.println(str1.equals(str2));
		
		int[] intAry = new int[10];
		//intAry = null;
		System.out.println(intAry[0]);
	}
}
