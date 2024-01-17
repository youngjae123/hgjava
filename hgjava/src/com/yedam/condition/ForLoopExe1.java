package com.yedam.condition;

public class ForLoopExe1 {
	public static void main(String[] args) {
		//
		for(int i=1; i<=10; i++) {
			System.out.println(i);
			if(i>5) {
				break;
			}//if end
		}//for end
		
		// 1~10까지 합을 계산
		int sum = 0;
		for(int n =1; n <=10; n++) {
			sum += n;
		}
		System.out.printf("누적값은 %d\n", sum);
		
		//1~10까지 합의 홀수값
		int h = 0;
		for (int m =1; m <=10; m++) {
			if(m%2 == 1) {
				h += m;
			}
		}//for end
		System.out.printf("누적값은 %d\n", h);
		
		//1 ~ 31까지 반복 : 몇번 반복하겟다= for
		System.out.printf("%3s","");
		for ( int d= 1; d <=31 ; d++) {
			System.out.printf("%3d",d);
			if(d%7 == 6) {
				System.out.println();
			}//if end
		}//for end
	}//main end
}//class end
