package com.yedam.interfaces.emp;

import java.util.Scanner;

import com.yedam.classes.singleton.EmployeeList;

public class EmployeeListApp {
	public static void main(String[] args) {
		EmployeeList app = EmployeeList.getInstance();
		
		Scanner scn = new Scanner(System.in);
		boolean run = true;
		int menu = 0;
		
		while(run) {
			System.out.println("1.사원수 2.사원입력 3.사원리스트 4.검색 5.급여합계 9.종료");
			System.out.print("선택> ");
		menu = scn.nextInt();
		
		if(menu == 1) {
			app.init();
		}else if(menu == 2) {
			app.input();
		}else if(menu == 3) {
			app.print();
		}else if(menu == 4) {
			System.out.print("조회한 사번>> ");
			int no = scn.nextInt();
			String name = app.search(no);
			if(name.equals("")) {
				System.out.println("없는 사번입니다.");
			}else
				System.out.printf("%s\n",name);
		}else if(menu == 5) {
			//app.sum()
			System.out.printf("급여의 합계는 %d 입니다\n", app.sum());
		}
		else if(menu == 9) {
			run = false;
		}else {
			System.out.println("잘못된 번호입니다.");
		}
		}
	}
}
