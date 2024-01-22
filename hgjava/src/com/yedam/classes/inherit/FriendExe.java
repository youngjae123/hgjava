package com.yedam.classes.inherit;

import java.util.Scanner;

public class FriendExe {
	// 사용자입력/처리결과 출력 => 컨트롤.
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		boolean run = true;
		
		FriendApp app = new FriendApp();
		
		while(run) {
			System.out.println("1.등록 2.조회 3.수정 4.삭제 9.종료");
			int menu = Integer.parseInt(scn.nextLine());
			
			switch(menu) {
			case 1://등록 1)이름 연락처 2)학교친구 3)회사친구
				System.out.println("1.친구 2.학교 3.회사");
				int subMenu = Integer.parseInt(scn.nextLine());
				
				System.out.println("이름>>");
				String name = scn.nextLine();
				System.out.println("연락처>>");
				String phone = scn.nextLine();
				
				Friend friend = null;
				if(subMenu == 1) {
					friend = new Friend();
					friend.setName(name);
					friend.setPhone(phone);
					
				}else if(subMenu == 2) {
					UnivFriend ufriend = new UnivFriend();
					ufriend.setName(name);
					ufriend.setPhone(phone);
					System.out.println("학교 입력>>");
					String univ = scn.nextLine();
					System.out.println("전공 입력>>");
					String major = scn.nextLine();
					ufriend.setUniv(univ);
					ufriend.setMajor(major);
					friend = ufriend;
				}else if(subMenu == 3) {
					CompFriend cfriend = new CompFriend();
					cfriend.setName(name);
					cfriend.setPhone(phone);
					System.out.println("회사 입력>>");
					String company = scn.nextLine();
					System.out.println("부서입력>>");
					String dept = scn.nextLine();
					cfriend.setCompany(company);
					cfriend.setDept(dept);
					friend = cfriend;
				}
				
				if(app.add(friend)){
					System.out.println("정상 등록");
				}else {
					System.out.println("등록 안됨");
				}
				break;
				
			case 2:// 목록(이름)
				System.out.println("조회할 이름>>");
				String fname = scn.nextLine();
				Friend[] list = app.list(fname);
				for(int i=0; i < list.length; i++) {
					if(list[i] != null) {
						System.out.println(list[i]);
					}
				}
				break;
				
			case 3:
				System.out.println("수정할 대상 전화번호를 입력하세요");
				phone = scn.nextLine();
				System.out.println("변경메뉴: 1.학교 2.회사");
				int smenu = Integer.parseInt(scn.nextLine());
				
				if(smenu == 1) {
				System.out.println("변경할 학교 입력");
				String info1 = scn.nextLine();
				System.out.println("변경할 전공 입력");
				String info2 = scn.nextLine();
				if(app.modify(phone, info1, info2)) {
					System.out.println("수정완료");
				}else {
					System.out.println("잘못된 번호입니다.");
				}
				break;
				}
				
				if(smenu == 2){
					System.out.println("변경할 회사 입력");
					String info1 = scn.nextLine();
					System.out.println("변경할 부서 입력");
					String info2 = scn.nextLine();
					if(app.modify(phone, info1, info2)) {
						System.out.println("수정완료");
					}else {
						System.out.println("잘못된 번호입니다.");
					}
					break;
					}
				break;
				
			case 4:
				System.out.println("삭제할 전화번호 입력>>");
				phone = scn.nextLine();
				if(app.remove(phone)) {
					System.out.println("삭제완료");
				}
				break;
				
			case 9:
				System.out.println("종료합니다.");
				run = false;
			}//switch
		}//while
		System.out.println("end of prog");
		
	}
}
