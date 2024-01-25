package com.yedam.collection.emp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class EmpApp {
	public static void main(String[] args) {
		List<Employee> storage = new ArrayList<>();

		Scanner scn = new Scanner(System.in);
		boolean run = true;
		boolean isOk = true;
		while (run) {
			System.out.println("1.등록 2.조회(입사일자) 9.종료");
			int menu = Integer.parseInt(scn.nextLine());
			SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
			switch (menu) {
			case 1:
				System.out.print("사번 이름 입사일 급여를 입력하세요>>");
				String no = scn.nextLine();
				String[] sno = no.split(" ");
				for (String num : sno) {
					System.out.println(num);
				}
				try {
					storage.add(new Employee(Integer.parseInt(sno[0]), sno[1], sdf.parse(sno[2]), Integer.parseInt(sno[3])));
				} catch (NumberFormatException e) {
					e.printStackTrace();
				} catch (ParseException e) {
					System.out.println("날짜 포맷이 부정확.");
				}
				System.out.println("등록 완료");
				break;

			case 2:
				Date searchCondition = null;
				while (true) {
				System.out.print("조회일 입력>>");
				try {
					searchCondition = sdf.parse(scn.nextLine());
					break;
				} catch (Exception e) {
					System.out.println("날짜 포맷이 부정확.");
					isOk = false;
				}
				if(isOk) {
					System.out.println("추가되었습니다.");
				}
				}
				for(int i =0; i < storage.size(); i++) {
					if(storage.get(i).getHireDate().after(searchCondition) || storage.get(i).getHireDate().equals(searchCondition)) {
						System.out.println(storage.get(i).toString());
					}//if
					}//for
				break;
			case 9:
				run = false;
				System.out.println("프로그램 종료");
			}//switch
		}//while
	}//main
				
	

	void method() {

		// "101 홍길동 23-05-08 100"
		String val = "101 홍길동 23-05-08 100";

		String[] valAry = val.split(" ");// val의 값을 공백을 기준으로 구분
		SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
		for (String value : valAry) {
			System.out.println(value);
		}
		try {
			new Employee(Integer.parseInt(valAry[0]), valAry[1], sdf.parse(valAry[2]), Integer.parseInt(valAry[3]));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
