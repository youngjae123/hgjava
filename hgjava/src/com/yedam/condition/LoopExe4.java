package com.yedam.condition;

public class LoopExe4 {
 public static void main(String[] args) {
	 //j,i =>
 
	 for(int j=2; j<=5; j++) {
		 //start
	 	
	 for (int i=1; i<j; i++) {
		 System.out.print("*");
	 	}//end
	 System.out.println();
	 }
	 
	 }//main
// 4개에서부터 하나씩 줄어들면서 점찍기
 public static void method3() {
 for (int j=4; j>0; j--){
 for(int i=1; i<=j; i++){
 System.out.print("*");
 }
 System.out.println();
 }
 }
 


 	//구구단 출력.
 	public static void method2() {
	 for(int j=1; j<=9; j++) {
		 //시작.
	 //int num =j; // 단 정보.
		 for(int i=2; i<=9; i++) {
		 //3*1=3
		 System.out.printf("%2d * %d = %2d\t", i, j, (i*j));
	 }//for end
	 System.out.println();
	 }//for end
 	}//method end
 	public static void method1() {
 		for(int j=1; j<=9; j++) {
 			//시작
 			for(int i=2; i<=9; i++) {
 				System.out.printf("%d * %d = %d\t", i, j, (i*j)); /*<= 곱하기니까 순서가 상관이 없다*/
 			}//for
 			System.out.println();
 			//끝.
 		}//for
 	}
 	}//class
//교수님 풀이

