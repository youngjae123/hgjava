package com.yedam.condition;

public class ArryExe {
	public static void main(String[] args) {
		//
		int[] intAry = {10, 20, 30}; //int intAry
		intAry[2] = 40;
		
		intAry = new int[] {10,20,30,40,50};
		intAry = new int[10];
		System.out.println(intAry[0]+ ", 크기:" + intAry.length);
		intAry[0] = 100;
		
		//배열에 값을 저장.
		for(int i=0; i <10; i++) {
			intAry[i] = (int) (Math.random()*10);
		}//for
		
		// 2, 3의 배수의 값을 각각 int sum2, sum3에 저장
		int sum2, sum3;
		sum2 = sum3 = 0;
		
		for(int i=0; i<10; i++) {
			System.out.println(intAry[i]);
		// 2배수와 3의배수를 출력해보세요 (6은 중복된다)
		if (intAry[i] % 2 ==0 && intAry[i] % 3 == 0) {
			sum2 += intAry[i];
			sum3 += intAry[i];
		}else if (intAry[i] % 2 == 0 ) {
			sum2 += intAry[i];
		}else if (intAry[i] % 3 == 0) {
			sum3+= intAry[i];
		}
		}
		System.out.printf("2의 배수합: %d, 3의 배수합: %d\n", sum2, sum3);
		
		
//		String[] strAry = {"Hong","park", "kim", "20" };
//		for(int i =0; i < strAry.length; i++) {
//			System.out.println(strAry[i]);
//		}
	}//main
}//class
