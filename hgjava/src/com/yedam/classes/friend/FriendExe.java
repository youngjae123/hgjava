package com.yedam.classes.friend;

import java.util.Scanner;

public class FriendExe {
	public static void main(String[] args) {
		//메뉴: 1.등록 2.목록 3.수정 4.삭제 5단건조회 9.종료
		//사용자의 입력/ 처리결과 콘솔출력.
		FriendApp app = new FriendApp();
		
		Scanner scn = new Scanner(System.in);
		boolean run = true;
		String sname ="";
		String snum ="";
		int age =0;
		while (true) {
			UserApp uapp = new UserApp();
			System.out.println("id>>");
			String id = scn.nextLine();
			System.out.println("pw>>");
			String pw = scn.nextLine();
			
			User user = uapp.login(id, pw);
			
			if(user != null){
				System.out.printf("%s 님, 환영합니다\n", user.getName());	
				break;
			}
			System.out.println("id와 pw를 확인하세요");
		}
		
		while(run){
			System.out.println("1.등록 2.목록 3.수정 4.삭제 5.단건조회 9.종료");
			int menu = Integer.parseInt(scn.nextLine());

			switch(menu) {
			case 1://등록
				System.out.println("등록할 이름을 입력하세요");
				sname=scn.nextLine();
				System.out.println("연락처를 입력하세요");
				snum=scn.nextLine();
				System.out.println("나이를 입력하세요");
				age=Integer.parseInt(scn.nextLine());
				
				Friend frd = new Friend(sname,snum,age);
				
				if(app.add(frd)) {
					System.out.println("입력성공");
				}else {
					System.out.println("입력실패");
				}
				break;
				
			case 2://목록
				Friend[] list = app.list();
				
				for(int i =0; i < list.length; i++) {
					if(list[i] != null) {
						list[i].showInfo();
					}
				}
				break;
			case 3://수정
				System.out.println("이름을 입력하세요.");
				sname=scn.nextLine();
				System.out.println("변경할 번호를 입력하세요.");
				snum=scn.nextLine();
				if(app.modify(sname,snum)) {
					System.out.println("수정완료");
				}else {
					System.out.println("잘못된 번호입니다");
				}
				break;
			case 4:
			case 5:
			case 9://종료
				run = false;
			}
		}	
		
  }

}

























