package com.yedam.operator;

import java.util.Scanner;

public class OperatorExe1 {
	
	public static void main(String[] args) {
	//		method1();
		//문제1
		int result =0;
		Scanner scn = new Scanner(System.in);
		while (true) {
			System.out.println("수를 입력하세요");
			String input = scn.nextLine();
			if(input.equals("quit")) {
				break;
			}//if end
			try {
				result += Integer.parseInt(input);
			}//try end
			catch (Exception e) {
				System.out.println("잘못된 값을 입력.");
			}//catch end
			//사용자 값을 입력: 정수입력.
			result += Integer.parseInt(input);
		}//while end
		//누적값은 (15) 입니다
		System.out.printf("누적값은 %d 입니다.\n", result);
		System.out.println("end of prog.");
	}//main end
	
	
	
	
	public static void method1() {
		int sum = 1+2*3;
		sum = sum +5;
		sum += 5;
			String str = "";
		Scanner scn = new Scanner(System.in);
		while (true) {
			System.out.println("문자열을 입력하세요>>");
			String input = scn.nextLine();
			if(input.equals("quit")) {
				break;
			}//if end
			str += input + "";
		}// while end
		System.out.printf("누적내용: %s\n", str);
	}//method1 end
}//class end
