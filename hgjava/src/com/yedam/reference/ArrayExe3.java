package com.yedam.reference;

import java.util.Scanner;

public class ArrayExe3 {
	public static void main(String[] args) {
		Friend f1 = new Friend();//초기화
		f1.name = "홍길동";
		f1.weight= 67.8;
		f1.score = 80;
		
		Friend f2 = new Friend();
		f2.name = "김길동";
		f2.weight= 77.8;
		f2.score = 86;
		
		Friend f3 = new Friend();
		f3.name = "김민석";
		f3.weight= 79.8;
		f3.score = 88;
		
		//새로운 친구
		
		String name = "김말숙";
		double weight =55.5;
		int score = 88;
		
		Friend f4 = new Friend();
		f4.name = "김말숙";
		f4.weight= 55.5;
		f4.score = 88;
		
		
		Friend[] friends = {f1, f2, f3,f4 };
		friends = new Friend[5];// {null,null,null,null}
		friends[0]=f1;
		friends[1]=f2;
		friends[2]=f3;
		friends[3]=f4;
		
		//김말숙 => 88 -> 90점 변경.
		Scanner scn = new Scanner(System.in);
		System.out.println("찾을 친구>>");// 찾을 친구>> 라는 문구 출력
		String fname = scn.nextLine();// 값 입력
		System.out.println("변경점수입력>>");// 변경 점수 입력>> 문구 출력
		int fscore = Integer.parseInt(scn.nextLine());// 점수는 정수이니까 변수를 scn을 int로하고 정수타입으로 변경시킨다
		
		for (int i = 0; i < friends.length; i++) {//i를 0에서 friends의 길이보다 -1 작을때까지 i를 1씩 더하면서 값을 찾는다
			if(friends[i] !=null && friends[i].name.equals(fname)) {// friends[i]의 값이 null이 아니고 friends[i]의 name과 fname(찾을 친구 입력한 값)이 일치하면
				//if(friends[i].name == "김말숙") {}
					friends[i].score = fscore; //friends[i]의 score값을 fscore(변경 점수 입력에서 입력한값)으로 바꾼다
				
			}
		}
				for (int i = 0; i< friends.length; i++) {
					if(friends[i] != null)
				System.out.printf("%s의 몸무게는 %.1fkg 점수는 %d 입니다.\n",name,friends[i].weight,friends[i].score);
				}
	}
}
