package com.yedam.io.emp;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

public class EmpExe {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		boolean run = true;
		EmpApp app = new EmpApp();
		
		while(run) {
			System.out.println("1.등록 2.목록 9.종료");
			System.out.print("선택>> ");
			
			int menu = Integer.parseInt(scn.nextLine());
			switch(menu) {
			case 1:// 사원번호 이름 입사일자 급여. ' yy-MM-dd
				
				
				System.out.print("사원번호 이름 입사일자 급여 >>");
				String std = scn.nextLine();
				String[] sstd = std.split(" ");
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				Employee emp = null;
				try {
					emp = new Employee(Integer.parseInt(sstd[0]), sstd[1], sdf.parse(sstd[2]), Integer.parseInt(sstd[3]));
				} catch(Exception e) {
					System.out.println("날짜포맷 오류");
				}
				if(app.add(emp)) {
				System.out.println("등록완료");
				} else {
					System.out.println("등록에러");
				}
				break;
				
			case 2:
				List<Employee> list = app.list();
				for(Employee std1 : list) {
					System.out.println(std1.toString());
				}
				break;
				
			case 9:
				System.out.println("프로그램 종료.");
				app.save();
				run = false;
			}
		}
	}
}
