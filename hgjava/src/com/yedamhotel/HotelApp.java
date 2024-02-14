package com.yedamhotel;

import java.util.List;
import java.util.Scanner;

public class HotelApp {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		HotelDAO hdao = new HotelDAO();
		boolean run = true;
		int menu = 0;

		while (run) {
			//System.out.println("welcom yedam hotel");
			System.out.print("1.고객 2.직원");
			menu = scn.nextInt();

			if (menu == 1) {
				while (true) {
					System.out.print("1.객실정보, 2.예약하기, 3.예약확인 4.예약취소 5.종료");
					menu = scn.nextInt();
					if (menu == 1) {// 객실정보
						System.out.println("객실 번호  ||  객실 타입  ||  객실 가격  ||  객실 상태  ||  잔여 객실 수  ");  
						System.out.println("================================================================");
						List<Room> list = hdao.getList();
						for (Room rm : list) {
							System.out.println("   "+rm.getRoomno() + "    ||   " + rm.getRoomtp()+ "  ||  " + rm.getRoomm()+ "   ||   " +rm.getRoomnow()+ "    ||    (" + rm.getMax() +")" );
						}
						
					} else if (menu == 2) {// 예약하기
						System.out.print("아이디 입력>>");

						System.out.print("체크인 날짜>>");
						System.out.print("체크아웃 날짜>>");
						System.out.print("방 번호>>");
						System.out.print("투숙인원>>");
					} else if (menu == 3) {// 예약확인
						System.out.print("아이디 입력>>");
					} else if (menu == 4) {//예약취소
						
					} else if (menu == 5) {//종료
						System.out.println("종료합니다.");
						run = false;
					}
				}
			} else if (menu == 2) {

			}

		}
	}
}
