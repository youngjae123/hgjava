package com.yedam.condition;

import java.util.Scanner;

public class CalendarExe {
		public static void main(String[] args) {
			Scanner scn=new Scanner(System.in);
			System.out.println("월 입력: ");
			int month = scn.nextInt(); //4월달까지 출력.
			// 변수: 월의 1이 위취.
			int pos = 1;
			//변수: 월의 마지막날짜.
			int lastDate = 31;
			
			switch(month) {
			case 1: 
				pos = 1 ;lastDate=31 ; break;
			case 2: 
				pos = 4 ; lastDate=29; break;
			case 3: 
				pos = 5 ; lastDate=31; break;
			}
			
			//수정..월이 변경될때마다 마지막날 계산
			
			// 1 ~ 31까지 반복.
			String[] days = { "Sun" , "Mon", "Tue", "Thr", "Fri", "Sat"};
//			System.out.println("Sum Mon Tue Wed Thr Fri Sat");
					for(int i=0; i <days.length; i++) {
						System.out.printf("%4s,day[i]");
					}
			System.out.println("");
				for(int i =0; i <pos; i++) {
				System.out.printf("%4s","");
			}
			//System.out.printf("%4s","");
			for ( int d= 1; d <= lastDate ; d++) {
				System.out.printf("%4d",d);
				if(d%7 == (7-pos)) {// 수정..
					System.out.println();
				}//if end
			}//for end
			System.out.println();
			System.out.println("========end of pfog=======");
		}//main end
}
