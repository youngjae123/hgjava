package com.yedam;

import com.yedam.classes.Student;

public class StudentExe {
	public static void main(String[] args) {
		
	 	Student std = new Student("S001","홍길동");
		std.setScore(80);
		
		std.showInfo();//접근수준 default -> 접근수준을 public으로 변경하면 사용가능
	}
}
