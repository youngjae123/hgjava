package com.yedam.classes.singleton;

import java.util.Scanner;

public class EmployeeList {
 //싱글턴
	private static EmployeeList instance = new EmployeeList();
	
	Employee[] list; // 사원배열.
	int empNum; // 현재사원수
	Scanner scn = new Scanner(System.in);
	
	private EmployeeList() {
		
	}
	public static EmployeeList getInstance() {
		return instance;
	}
	
	//사원수 입력 초기화
	public void init() {
		System.out.print("사원수>>");
		int num = scn.nextInt();
		list = new Employee[num];
//		empNum= 0; //초기화
	}
	
	//사원정보 입력 => 배열추가.
	public void input() {
		if(empNum == list.length) {
			System.out.println("입력초과");
			return;
		}
		System.out.printf("%d 사번", empNum);
		int no = scn.nextInt();
		
		System.out.print("이름>");
		String name = scn.next();
		
		System.out.print("급여>");
		int sal = scn.nextInt();
		
		list[empNum++] = new Employee(no, name, sal);
	}
//사번에 해당하는 이름 출력.
	public String search(int empId) {
		//해당사번이 있으면 이름 반환. 없으면 "".
		for(int i = 0; i < empNum; i++) {
			if(list[i].getEmployeeId()== empId) {
			return list[i].getName();
			}
			}
		return "";
	}
	//전체출력.
	public void print() {
		//사원번호, 이름, 급여 출력.
		for(int i = 0; i < empNum; i++) {
			System.out.printf("%4d %10s %7d\n", list[i].getEmployeeId(), list[i].getName(), list[i].getSalary());
			}
	}
	
	//급여합계
	public int sum() {
		int total =0;
		for(int i = 0; i< empNum; i++) {
			total =+ list[i].getSalary();		
	}
		return total;
}
}