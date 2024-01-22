package com.yedam.reference;

import java.util.Scanner;

public class 복습 {
	public static void main(String[] args) {//main 메서드 생성
		Scanner scn = new Scanner(System.in);//스캐너 만듬
		
		Friend[] friends = new Friend[5];//friends라는 배열에 5개 방을 만듦
		
		boolean run = true;

		while(run) {
			System.out.println("1.등록 2.조회 3.수정 4.삭제 5.점수조회 6.분석 9.종료");//""출력
			int menu = Integer.parseInt(scn.nextLine());//입력받은 ""를 menu에 저장
			switch(menu) {//스위치 조건문 시작
			case 1:  //등록
				System.out.println("이름을 입력해주세요;");//이름을 입력해 달라는 문구 출력
				String name = scn.nextLine();// 입력받은 이름을 name에 저장
				if(name.equals("")) {//sweight의 인덱스값이 ""이 아닐때 실행
					System.out.println("빈칸입니다.");
					break;
				}
				System.out.println("몸무게를 입력해주세요");//몸무게 입력 문구 출력
				double weight = Double.parseDouble(scn.nextLine());//입력받은 몸무게를 weight에 저장
				System.out.println("점수를 입력해주세요");//점수 입력 문구 출력
				int score = Integer.parseInt(scn.nextLine());// 입력받은 점수를 score에 저장
				
				Friend friend = new Friend();//friend라는 배열 생성
				friend.name = name;// friend.name에 이름 저장
				friend.weight = weight;//friend.weight에 몸무게 저장
				friend.score = score;//friend.score에 점수 저장
				
				for(int i = 0; i < friends.length; i++) {//i가 0번방에서 4번방까지 반복					
					if(friends[i] == null) {//friends[i]에 값이 없으면 실행한다
						friends[i] = friend;//friend값을 [i]번 방에 저장한다.
						break;
					}//if
				}//for
				System.out.println("정상적으로 등록되었습니다.");
				break;
				
			case 2:  //조회
				for(int i = 0; i < friends.length; i++) {//반복시작
					if(friends[i] != null) {//friend[i]안에 값이 있으면
						System.out.printf("이름: %s, 몸무게: %.1f 점수: %d\n", friends[i].name, friends[i].weight, friends[i].score);
					}//이름, 몸무게, 점수를 출력한다.
				}
				break;
			case 3:  //수정
				score = 0;
				weight = 0;
				boolean isExit = false;
				System.out.println("찾을 이름을 입력하세요.");//찾을 이름 출력
				name =scn.nextLine();// 입력값을 name에 저장
				for(int i = 0; i < friends.length; i++) { //반복문 실행
					if(friends[i] !=null && friends[i].name.equals(name)) {// 값이 있고 인덱스 안에 값이 입력한 값과 같을때 실행
					System.out.println("수정할 몸무게를 입력하세요");//수정할 몸무게 입력문 출력
					String sweight = scn.nextLine();//입력 받은 몸무게를  sweight에 저장
					if(!sweight.equals("")) {//sweight의 인덱스값이 ""이 아닐때 실행
						weight = Integer.parseInt(sweight);//weight의 값을 입력받은 sweight의 값으로 변환
					}
					System.out.println("수정할 점수를 입력하세요");//수정할 점수 입력문 출력
					String sscore = scn.nextLine();//입력받은 점수를 sscore에 저장
					if(!sscore.equals("")) {//sscore의 값이 "" 아닐때 실행
						score = Integer.parseInt(sscore);//score의 값을 입력받은 sscore의 값으로 변환
					}
					friends[i].score = (score != 0) ? score : friends[i].score;//score가 -1이 아니면 score의 값을 배열.score에 저장
					friends[i].weight = (weight != 0) ? weight : friends[i].weight;//weight가 0이 아니면 weight의 값을 배열.weight에 저장
					isExit = true;
				}
			}
				if(!isExit) {
					System.out.println("찾는 친구가 없습니다.");
					break;
				}
				
				System.out.println("수정이 완료되었습니다.");
				break;
			case 4:  //삭제
				System.out.println("삭제할 이름을 입력해주세요");//삭제할 이름입력 문구 출력
				name = scn.nextLine();//입력 받은 값을 name에 저장
				for(int i = 0; i < friends.length; i++) { //반복문 실행
					if(friends[i] !=null && friends[i].name.equals(name)) {//조건문 실행- 배열이 null이 아니고 배열의 이름이 입력한 이름과 같을때 실행
						friends[i] = null;//배열에 null 저장
						break;
					}
				}
				System.out.println("삭제되었습니다.");
				break;
			case 5:  //점수조회 = ~점 이상인 친구는 ~입니다.
				System.out.println("찾고싶은 점수대를 입력하세요.");
				score = Integer.parseInt(scn.nextLine());
				for(int i = 0; i < friends.length; i++) {
					if(friends[i] !=null &&friends[i].score >= score) {
						System.out.printf("%d점 이상인 친구는 %s 입니다.\n",score,friends[i].name);
					}
				}
				break;
				
			case 6:  //분석 = 등록된 친구들의 평균점수는 ~~이고 그 중 최고점수는 ~~ 입니다.
				int sum = 0;
				int cnt = 0;
				int max = 0;
				for(int i = 0; i < friends.length; i++) {
					if(friends[i] != null) {
						sum = sum + friends[i].score;
						cnt++;
						if(max < friends[i].score) {
							max = friends[i].score;
						}
					}
				}
				System.out.printf("등록된 친구들의 평균점수는 %d 이고 그 중 최고점수는 %d 입니다.\n",sum/cnt,max);
				break;
			case 9:  //종료
				run = false;
				System.out.println("프로그램을 종료합니다.");
			}//switch
			
		}//while
	}//main
}//class
