package com.yedam.variable;

import java.util.Scanner;

public class variableExe2 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
//		System.out.println("나이를 입력>>>");
//		String result = scn.nextLine(); //입력값을 문자열로 반환.
//		int result = scn.nextInt();
//		System.out.println("당신의 이름은 "+ result + " 입니다.");
		//이름(=name) , 연락처(=phone) : scn.nextLine()
		
		System.out.println("이름을 입력하세요");
		String name = scn.nextLine();
		System.out.println("연락처를 입력하세요");
		String phone = scn.nextLine();
		//영어(=eng), 수학(=mat) => 합계(sum) : scn.nextInt()
		
		System.out.println("영어 점수?");
		int eng = scn.nextInt();
		System.out.println("수학 점수?");
		int mat = scn.nextInt();
		int sum = eng + mat;
		
		
		// 이름: 홍길동, 연락처: 010-1111-2222
		// 영어: 80, 수학:85, 합계: 165.
		System.out.println("이름: " + name + ", 연락처: " + phone);
		System.out.println("영어: " + eng +", 수학: " + mat + ", 합계: " + sum);
		
		scn.close();
	}

}
		
		
