package com.yedam.interfaces.emp;

import java.util.Scanner;

import com.yedam.classes.singleton.Employee;

//배열:  Employee[]
public class EmployeeArray implements EmployeeList {
	//싱글턴
	private static EmployeeArray instance = new EmployeeArray();
	Employee[] list;
	int empNum;
	Scanner scn = new Scanner(System.in);
	
	private EmployeeArray () {
		
	}
	public static EmployeeArray getInstancce() {
		return instance;
	}
	
	@Override
	public void init() {
			System.out.print("사원수>>");
			int num = scn.nextInt();
			list = new Employee[num];
			empNum= 0; //초기화
	}

	@Override
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
	

	@Override
	public String search(int empId) {
		for(int i = 0; i < empNum; i++) {
			if(list[i].getEmployeeId()== empId) {
			return list[i].getName();
			}
			}
		return "";
	}

	@Override
	public void print() {
		for(int i = 0; i < empNum; i++) {
			System.out.printf("%4d %10s %7d\n", list[i].getEmployeeId(), list[i].getName(), list[i].getSalary());
			}
	}

	@Override
	public int sum() {
		int total =0;
		for(int i = 0; i< empNum; i++) {
			total =+ list[i].getSalary();		
	}
		return total;
	}
		
}

