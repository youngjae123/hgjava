package com.yedamhotel;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class HotelApp {
	final static int MAX = 12;

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		HotelDAO hdao = new HotelDAO();

		boolean run = true;
		int menu = 0;

		while (run) {
			boolean run1 = true;
			while (run1) {
				System.out.println("welcom yedam hotel");
				System.out.println("1.고객페이지 2.관리자페이지");
				System.out.println("번호입력>>");
				menu = scn.nextInt();
				if (!(menu == 1 || menu == 2)) {
					System.out.println("다시 입력해 주세요");
				} else {
					run1 = false;
				}
			}
			switch (menu) {
			case 1://고객페이지
				boolean run2 = true;
				while (run2) {
					System.out.println("1.객실정보, 2.예약하기, 3.예약취소 4.종료 ");
					System.out.print("번호 입력>>");
					menu = scn.nextInt();
					scn.nextLine();
					switch (menu) {
					case 1: // 객실정보
						System.out.println("객실 번호  ||  객실 타입  ||  객실 가격  ||  객실 상태  ||  최대 인원 수  ");
						System.out.println("================================================================");
						List<Room> list = hdao.getList();
						for (Room room : list) {
							System.out.println("   " + room.getRoomno() + "    ||     " + room.getRoomtype()
									+ "     ||  " + room.getRoommoney() + "   ||   " + room.getRoomstate()
									+ "    ||    (" + room.getMaxperson() + ")");
						}
						break;

					case 2:// 예약하기

						System.out.print("예약할 객실 번호를 입력해주세요>>>>");
						int rno = scn.nextInt();

						System.out.print("이름>>");
						String name = scn.next();
						System.out.print("연락처 >>");
						String phone = scn.next();
						System.out.print("아이디 입력>>");
						String id = scn.next();
						System.out.print("체크인 날짜>>");
						String ci = scn.next();
						System.out.print("체크아웃 날짜>>");
						String co = scn.next();
						System.out.print("투숙인원>>");
						int pr = scn.nextInt();
						scn.nextLine();

						if (hdao.insertCus(name, phone, id, ci, co, pr, rno)) {
							System.out.println(" ( " + rno + " )번 객실에 예약이 완료되었습니다.");
						} else {
							System.out.println("이미 예약되었거나 예약할 수 없는 객실을 입력하였습니다.\n!** 객실 번호를 확인해주세요");
						}
						break;
					case 3:// 예약취소
						System.out.println("객실 번호를 입력해주세요");
						int rmno = scn.nextInt();
						scn.nextLine();

						if (hdao.deleteCus(rmno)) {
							System.out.println(" ( " + rmno + " )번 객실에 예약이 취소되었습니다.");
						} else {
							System.out.println("이미 취소되었거나 예약된 정보가 없습니다..\n!** 객실 번호를 확인해주세요**!");
						}
						break;
					case 4:// 종료
						System.out.println("종료합니다.");
						run2 = false;
//						break;
					}// switch 2
				} // while2
				break;
				
			case 2:// 관리자 페이지
				boolean run3 = true;
				while (run3) {
					System.out.println("===================메뉴================================");
					System.out.println("     1.예약확인   2.회원정보 수정    3.체크아웃           7.종료");
					System.out.println("======================================================");
					System.out.println("메뉴선택>>");
					menu = scn.nextInt();
					scn.nextLine();
					switch (menu) {
					case 1:// 예약 확인
						List<Customer> list1 = hdao.getList2();
						if (list1.size() > 0) {
							System.out.println(
									"=======================================================================================");
							System.out.println(
									"  이름   ||      연락처      ||      체크인      ||      체크아웃      ||  방 번호  ||  인원   ||");
							System.out.println(
									"=======================================================================================");
							for (Customer cus : list1) {
								System.out.println("  " + cus.getName() + "  ||  " + cus.getPhone() + "  ||  "
										+ cus.getCi() + "   ||    " + cus.getCo() + "   ||   " + cus.getRoomno()
										+ "    ||  (" + cus.getPr() + ")   ||  ");
							}
							System.out.println(
									"=======================================================================================");
						} else {
							System.out.println("예약된 내역이 없습니다.");
						}
						break;

					case 2:// 예약 정보 수정

					case 3:// 체크아웃(빈방)
//						System.out.println("체크아웃 할 객실 번호를 입력하세요");
//						int rno = scn.nextInt();
//						scn.nextLine();
//
//						if (box[rno].getState() == " ■ ") {
//							Date date = new Date();
//							box[rno].setCo(date.toString());
//							System.out.println("(" + rno + ")번 객실에서 체크아웃하였습니다.");
//
//							box[rno].setName("");
//							box[rno].setPhone("");
//							box[rno].setState("(" + rno + ")");
//							box[rno].setId("");
//							box[rno].setPr(0);
//						} else {
//							System.out.println("이미 체크아웃 되었거나, 잘못된 객실 번호 입니다.\n!**객실 번호를 확인해주세요**!");
//						}

					case 6:// 객실 정보 보기
					case 7:// 종료
						System.out.println("프로그램을 종료합니다.");
						run3 = false;

					}
				}

			}// switch 1
		} // while 1
	}// main
}// class
