package com.yedam.classes;

import java.util.Scanner;


//등록메소드
public class MainExe {
	
	static Scanner scn = new Scanner(System.in);
	static String sno ="" , sname ="";
	static int score = 0;
	static double height =0;
	static StudentApp app = new StudentApp();
	public static void insert(){
		System.out.println("학생 번호>>");
		sno=scn.nextLine();
		System.out.println("학생 이름>>");
		sname=scn.nextLine();
		System.out.println("학생 점수>>");
		score=Integer.parseInt(scn.nextLine());
		System.out.println("학생 키>>");
		height= Double.parseDouble(scn.nextLine());
		//매개값으로 사용
		Student std = new Student(sno,sname, score, height);
		
		if(StudentApp.add(std)) {
			System.out.println("입력성공!!");
		}else {
			System.out.println("입력실패 !!");
		}
	}
	
		public static void list() {
			Student[] list =StudentApp.list();
			
			for(int i =0 ; i < list.length; i++) {
				if(list[i] != null) {
					list[i].showInfo();
				}
			}
			System.out.println("조회완료!!");
		}
		
		public static void update() {
			System.out.println(" 학생 번호>>");
			sno=scn.nextLine();
			//정상 학번 체크.
			if(StudentApp.get(sno) == null) {
				System.out.println("학생번호 확인");
				return;//메서드의 break는 return
			}
			//정상 점수 입력.
			while (true) {
				
			System.out.println(" 학생 점수>>");
			score=Integer.parseInt(scn.nextLine());
			if(score <0) {
				System.out.println("점수를 확인하세요");
				continue;
			}
			break;//메서드종료
			}
			if(StudentApp.modify(sno,score)) {
				System.out.println("수정완료");
			}else {
				System.out.println("잘못된 학번입니다.");
			}
			}
		

			

		
		public static void delete() {
			System.out.println("삭제할 학생번호>>");
			sno=scn.nextLine();
			if (StudentApp.remove(sno)) {
				System.out.println("삭제완료");
			}else {
				System.out.println("잘못된 학번입니다");
			}
		}
		
		public static void search() {
			System.out.println("학생번호 조회.");
			sno = scn.nextLine();
			
			Student s1 = StudentApp.get(sno);
			
			if(s1 != null) {
				s1.showInfo();
			}else {
				System.out.println("잘못된 번호!");					
			}
		}
		
	public static void main(String[] args) {
//		StudentApp app = new StudentApp();//인스턴스.만듦
		//static쓰면 인스턴스 필요없이 app대신 StudentApp쓰면 됨
		
		boolean run = true;
		
		while(run) {
			System.out.println("1.등록 2.목록 3.수정 4.삭제 5.조회 9.종료");
			int menu = Integer.parseInt(scn.nextLine());
			
			switch(menu) {
			case 1: //등록기능.
				insert();
				break;
				
			case 2://목록출력
				list();
				break;
				
			case 3://수정.(학생번호 -점수)
				update();
				break;
				
			case 4: //삭제
				delete();
				break;
				
			case 5://조회
				search();
				break;
			
			case 9://종료
				run=false;
				System.out.println("종료합니다.");
		}	
		}
	}
}
