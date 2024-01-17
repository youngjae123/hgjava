package com.yedam.todo;

import java.util.Scanner;

public class Todo0117 {
 public static void main(String[] args) {
	//친구 3명의 이름과 연락처를 입력하도록..메세지 출력
	//입력완료
	 
	 //이름: 홍길동
	 //연락처: 010-1111-2222
	 //===================
	 //이름: 김길동
	 //연락처: 010-1111-2222
	 //===================
	 //이름: 박길동
	 //연락처: 010-1111-2222
	 //===================
	 Scanner scn = new Scanner(System.in);
	 int n;
	 do {
		 System.out.println("입력 처리 할 학생 수 입력(명):");
		 n = scn.nextInt();
	 }
	 while(n<1||n>10);
	 
	 String names[] = new String[n];
	 String phon[] = new String[n];
	 
	 for (int i=0; i<n; i++) {
		 System.out.println("이름 전화번호 입력("+ (i+1) +"):");
		 names[i] = scn.next();
		 phon[i]=scn.next();
	 }
	 
	 System.out.println("=========================");
	 System.out.println("전체 학생 수: " + n + "명");
	 System.out.println("=========================");
	 System.out.println(" 이름    전화번호");
	 for(int i =0; i < n; i++) 
		 System.out.printf("%4s %14s\n", names[i], phon[i]);
	 	System.out.println("======================");
	 
	
 }//main
}//class
