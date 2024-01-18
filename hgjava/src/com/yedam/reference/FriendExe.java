package com.yedam.reference;

import java.util.Scanner;

//친구 정보를 저장하고 변경하고 관리.
//Create, Read, Update, Delete.
public class FriendExe {
	public static void main(String[] args) {//메인 메서드 생성
		Scanner scn = new Scanner(System.in);
		boolean run = true;
		Friend[] friends = new Friend[5];//{null,null,null,null,null}
		
		int score = 0;
		double weight = 0;
		while(run) {
			System.out.println("1.등록 2.조회 3.수정 4.삭제 5.점수조회 6.분석 9.종료");
			// 점수조회 = 입력한 점수 이상인 친구들 출력
			// 분석 = 친구들의 평균점수:00, 평균점수 속 최고점수:00
			int menu = Integer.parseInt(scn.nextLine());
			switch(menu) {
			case 1: //등록
				System.out.println("이름을 입력하세요.");
				String name = scn.nextLine();
				System.out.println("몸무게를 입력하세요.");
				weight = Double.parseDouble(scn.nextLine());
				System.out.println("점수를 입력하세요.");
				score = Integer.parseInt(scn.nextLine());
				
				Friend friend = new Friend();
				friend.name = name;
				friend.weight = weight;
				friend.score = score;
				
				//비어있는 위치를 찾아서 한건이력 후 종료
				for(int i=0; i < friends.length; i++) {//length= 배열의 크기
					if(friends[i] == null) {//비어있는값(null)의 위치를 찾는다 -> 비어있는 위치가 있으면 
						friends[i] = friend;//friend의 값을 넣는다
						break;
					}//if
				}//for
				System.out.println("정상적으로 등록되었습니다.");
				break;
				
			case 2: //조회
				//전체 목록 -> 이름:000, 몸무게:00, 점수:00
				for(int i = 0; i < friends.length; i++) {
					if(friends[i] != null) {
						System.out.printf("이름: %s, 몸무게: %.1f, 점수:%d 입니다\n", friends[i].name, friends[i].weight, friends[i].score);	
					}//if
				}//for
				break;
			case 3: //수정
				// 친구이름 ->점수 수정
				weight =0;
				score =0;
				System.out.println("찾을 이름을 입력하세요.");
				name = scn.nextLine();
		
				//존재 여부 체크
				boolean isExist = false;
				for(int i = 0; i < friends.length; i++) {
					if(friends[i] !=null && friends[i].name.equals(name)) {
						System.out.println("수정할 몸무게를 입력하세요.");
						String sweight = scn.nextLine();
						if(!sweight.equals("")) {
							weight = Double.parseDouble(sweight);
						}//if
						System.out.println("수정할 점수를 입력하세요.");
						String sscore = scn.nextLine();
						if(!sscore.equals("")) {
							score = Integer.parseInt(sscore);
						}//if
						friends[i].score = (score != -1) ? score : friends[i].score;
						friends[i].weight = (weight != -1) ? weight : friends[i].weight;
						isExist = true;
					}//if
				}//for
				if (!isExist) {
					System.out.println("찾는 친구가 없습니다.");
				}//if
				System.out.println("수정되었습니다.");
				break;
				
			case 4: //삭제
				System.out.println("삭제할 이름을 입력해 주세요.");
				name = scn.nextLine();
				for(int i = 0; i < friends.length; i++) {
					if(friends[i] !=null && friends[i].name.equals(name)) {
						friends[i] = null;
						break;
					}//if
				}//for
				System.out.println("삭제되었습니다.");
				break;
			case 5://점수 조회 = ~점 이상인 친구는 ~~입니다.
				System.out.println("찾고있는 점수대를 입력하세요");
				score = Integer.parseInt(scn.nextLine());
				for(int i = 0; i < friends.length ; i++) {
					if(friends[i] !=null && friends[i].score >= score) {
						System.out.printf("%d이상인 친구는 %s 입니다.\n", score,friends[i].name);
					}//if
					
				}//for
				break;
				
				
				
			case 6://분석= 등록된 친구들의 평균점수는 ~~이고 그 중 최고점수는 ~~ 입니다.
				int sum = 0;
				int avg = 0;
				int cnt = 0;
				int max = 0;
				for(int i = 0; i < friends.length; i++) {
					if(friends[i] != null) {
						sum+=friends[i].score;
						cnt++;
						if(max < friends[i].score) {
							max = friends[i].score;
						}//if
					}//if
				}//for
				System.out.printf("등록된 친구들의 평균 점수는 %d 이고 그 중 최고점수는 %d 입니다.\n",sum/cnt,max);
				break;
				
			case 9: //종료
				run = false;
				System.out.println("프로그램을 종료합니다.");
			}//switch
		}//while
		System.out.println("end of prog");
	}//main
}//class
