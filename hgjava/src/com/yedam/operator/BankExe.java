package com.yedam.operator;

import java.util.Scanner;

//은행계좌. 예금 한도액 10만원
public class BankExe {
	public static void main(String[] args) {
		//입금, 출금, 잔고, 종료
		Scanner scn = new Scanner(System.in);
		int balance =0;
		boolean run = true;
		
		while(run) {
			System.out.println("1. 입금 2.출금 3.잔고 4.종료 .");
			int menu = Integer.parseInt(scn.nextLine());
			switch(menu) {
			case 1:System.out.println("입금액>>");
//					balance += Integer.parseInt(scn.nextLine());
					int val = Integer.parseInt(scn.nextLine());
					if (balance + val > 100000) {
						System.out.println("입금액 초과!!");
					}
					else {
						balance += val;
						System.out.println("입금완료");
					}
					break;
			case 2:System.out.println("출금액>>");
					val = Integer.parseInt(scn.nextLine());
					if (balance < val) {
						System.out.println("출금액 초과");
					}
//					balance -= Integer.parseInt(scn.nextLine());
					else{balance -= val;
					System.out.println("출금완료!");
					break;
					}
			case 3:System.out.printf("잔액 : %d\n", balance);
				    break;
			case 4:
					run = false;
			}//switch end
		}//while end
		System.out.println("end of prog");
	}//main end
}//class end
