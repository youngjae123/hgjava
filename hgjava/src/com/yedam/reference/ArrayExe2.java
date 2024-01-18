package com.yedam.reference;

import java.util.Scanner;

public class ArrayExe2 {
	public static void main(String[] args) {
		
		String[] friends = {"홍길동", "김민수", "박석민", "최홍만", "김길동"};
		double[] dblAry = {67.3, 72.5, 88.3, 79.3, 90.4};
		int [] scores = new int[10];
		int max =0;
		scores = new int[5];
		scores[0] = 78;
		scores[1] = 82;
		scores[2] = 95;				
		scores[3] = 90;
		scores[4] = 91;
		
		String name ="";
		double weight =0;
		for(int i =0; i<friends.length; i++) {
			if(max < scores[i]) {
				name = friends[i];
				weight= dblAry[i];
				max = scores[i];
			}		
		}
		System.out.printf("최고 점수 이름: %s, 몸무게: %.1f, 점수: %d ",name,weight,max);
		
	
	

	
	}
	//System.out.printf("친구의 평균 몸무게는 %.1f 입니다.",avg);
	//System.out.println("\nend of prog.");
	
	
	
	
	
	
	
	
	public static void method2() {
		double[] dblAry = {67.3, 72.5, 88.3, 79.3, 90.4};
		double max =0;
		for(int i=0; i<dblAry.length; i++) {
			
			if( max < dblAry[i]) {
				max = dblAry[i];
			}
		}
		System.out.printf(" 제일 무거운 몸무게: %.1f 입니다.", max);
		double avg = 0;
		double sum = 0;
		for(int i =0; i < dblAry.length; i++) {
			sum = sum + dblAry[i];
			avg = sum/(dblAry.length);
		}
	}
	public static void method1() {
		int [] scores = new int[10];
		scores = new int[5];
		scores[0] = 78;
		scores[1] = 82;
		scores[2] = 77;				
		scores[3] = 90;
		scores[4] = 85;
		//80점 이상인 학생은 3명 입니다.
		//90점 이상인 학생은 ?명 입니다."
		//90점 이상인 학생은 없습니다.
		int cnt = 0;
		for(int i = 0 ; i < scores.length; i++) {
			if (scores[i] >= 90) {
				cnt++;
			}else {
				System.out.println("90점 이상인 학생은 없습니다.");
				break;
			}
		}
		System.out.printf("90점 이상인 학생은 %s명 입니다.",cnt);
		
	
//	int cnt =0;
//	for(int i =0; i < scores.length; i++) {
//		//System.out.println("scores["+ i +"]=>" + scores[i]);
//		if (scores[i] >80) {
//			cnt++;
//		}					
//	}
//	System.out.printf("80점 이상인 학생은 %s명 입니다",cnt);
}
	public static void method3() {
		Scanner scn = new Scanner(System.in);
		System.out.println("친구이름 입력>>");
		String name = scn.nextLine();
		String[] friends = {"홍길동", "김민수", "박석민", "최홍만", "김길동"};
		double[] dblAry = {67.3, 72.5, 88.3, 79.3, 90.4};
		double max =0;
		int [] scores = new int[10];
		scores = new int[5];
		scores[0] = 78;
		scores[1] = 82;
		scores[2] = 95;				
		scores[3] = 90;
		scores[4] = 91;
		
		boolean isExist = false;
		for(int i =0; i<friends.length; i++) {
			if(friends[i].equals(name)) {
				System.out.printf("%s의 몸무게는 %dkg 점수는 %.1f점 입니다.", name,scores[i],dblAry[i]);
				isExist = true;
			}
			if( max < dblAry[i]) {
				max = dblAry[i];
			}
		}
		if (!isExist) {
			System.out.println("찾는 친구가 없습니다.");
		}
	}
}
