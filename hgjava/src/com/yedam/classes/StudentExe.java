package com.yedam.classes;

//실행
public class StudentExe {
	public static void main(String[] args) {
		Student s1 = new Student("S001","홍길동",80,178.9); //생성자. ->인스턴스생성.
//		System.out.println(s1.sno);
//		s1.height = -167;
		s1.setHeight(-167);
		System.out.println(s1.getHeight());
		s1.showInfo();
		
		Student s2 = new Student("S002", "김길동");
//		s2.score =  85;
		s2.showInfo();
		
		Student s3 = new Student("S003","박길동",90);
		s3.showInfo();
	}
}
