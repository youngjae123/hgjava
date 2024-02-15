package com.yedamhotel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

public class HotelApp {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("yy-mm-dd");
		HotelDAO hdao = new HotelDAO();
		boolean run = true;
		int menu = 0;

		while (run) {
			boolean run3 = true;
			while(run3) {
				System.out.println("welcom yedam hotel");
				System.out.println("1.고객페이지 2.관리자페이지");
				System.out.println("번호입력>>");
				menu = scn.nextInt();
	        if(!(menu ==1 || menu ==2)) {
	        	System.out.println("다시 입력해 주세요");
	        }else {
	        	run3 = false;
	        }
			}
			switch (menu) {
			 case 1:
				while (run) {
					System.out.println("1.객실정보, 2.예약하기, 3.예약취소 4.종료 5");
					System.out.print("번호 입력>>");
					menu = scn.nextInt();
					scn.nextLine();
					switch (menu) {
					case 1: // 객실정보
						System.out.println("객실 번호  ||  객실 타입  ||  객실 가격  ||  객실 상태  ||  잔여 객실 수  ");
						System.out.println("================================================================");
						List<Room> list = hdao.getList();
						for (Room rm : list) {
							System.out.println("   " + rm.getRoomno() + "    ||   " + rm.getRoomtp() + "  ||  "
									+ rm.getRoomm() + "   ||   " + rm.getRoomnow() + "    ||    (" + rm.getMax() + ")");
						}
						break;

					case 2:// 예약하기
						System.out.println("이름>>");
						String name = scn.nextLine();
						System.out.println("연락처 >>");
						String phone = scn.nextLine();
						System.out.print("아이디 입력>>");
						String id = scn.nextLine();
						System.out.print("방 번호>>");
						String rno = scn.nextLine();
						System.out.print("체크인 날짜>>");
						String ci = scn.nextLine();
						System.out.print("체크아웃 날짜>>");
						String co = scn.nextLine();
						System.out.print("투숙인원>>");
						String pr = scn.nextLine();

						try {
							Customer cus = new Customer(name, phone, id, Integer.parseInt(rno), sdf.parse(ci),
									sdf.parse(co), Integer.parseInt(pr));
							if (hdao.insertCus(cus)) {
								System.out.println("예약이 완료되었습니다.");
							} else {
								System.out.println("다시 입력해주세요");
							}
						} catch (NumberFormatException e) {
							e.printStackTrace();
						} catch (ParseException e) {
							e.printStackTrace();
						}
						break;

					case 3:// 예약취소
						System.out.println("아이디를 입력해주세요.");
						String did = scn.nextLine();
					
						if(hdao.deleteCus(did)) {
						   System.out.println("예약이 취소되었습니다.");
						}else {
							System.out.println("예약된 내역을 찾지 못하였습니다.\n !**아이디를 확인해주세요**!");
						}
						break;
						
					case 4:// 종료
						System.out.println("종료합니다.");
						run = false;
						break;
					}// switch 2
				} // while2
			 case 2://관리자 페이지
				 boolean run4 = true;
				 while(run4) {
					 System.out.println("===================메뉴================================");
					System.out.println("     1.예약확인              2.회원정보 수정\n     3.체크인                4.체크아웃\n     5.예약내역조회(날짜별)      6.객실 정보 보기 \n     7.종료");
					System.out.println("======================================================");
					System.out.println("메뉴선택>>");
					menu = scn.nextInt();
					scn.nextLine();
					switch(menu) {
					case 1://예약 확인

						System.out.print("아이디 입력>>");
						String id1 = scn.nextLine();
						List<Customer> list1 = hdao.getList2(id1);
						if (list1.size() > 0) {
							System.out.println("=======================================================================================");
							System.out.println("  이름   ||      연락처      ||      체크인      ||      체크아웃      ||  방 번호  ||  인원   ||");
							System.out.println("=======================================================================================");
							for (Customer cus : list1) {
								System.out.println("  " + cus.getName() + "  ||  " + cus.getPhone() + "  ||  "
										+ cus.getCi() + "   ||    " + cus.getCo() + "   ||   " + cus.getRoomno()
										+ "    ||  (" + cus.getPr() + ")   ||  ");
							}
							System.out.println("=======================================================================================");
						} else {
							System.out.println("해당하는 아이디의 예약내역이 없습니다.");
						}
						break;
					case 2://예약 정보 수정
						
					case 3://체크인
					case 4://체크아웃(빈방)
					case 5://예약내역조회(날짜)
					case 6://객실 정보 보기
					case 7://종료
						System.out.println("프로그램을 종료합니다.");
						run = false;
						break;
						
					}
				 }
				 
			}// switch 1
		} // while 1
	}// main
}// class
