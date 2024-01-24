package com.yedam.exceptions;

public class RuntimeExe {
	public static void main(String[] args) {

		
		// 일반예외.
		try {
			Class.forName("java.lang.String");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		// 실행예외.
		String str = null;
		
//		System.out.println(str.toString());
		try {
			System.out.println(str.toString());
		} catch (NullPointerException e) {
			System.out.println("참조값이 없음.");
			str = "10";
		}
		
		try {
		int num = Integer.parseInt(str);
		System.out.println(num);
		} catch (NumberFormatException e) {
			System.out.println("숫자로 변경 불가.");
		}
		System.out.println("end of prog");
	}
}
