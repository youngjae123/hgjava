package com.yedam.classes;

public class HighStudentExt {
	public static void main(String[] args) {
		HighStudent hiStd = new HighStudent("T001","홍길동",90,"김쌤");
			
			System.out.println(hiStd.getSno());
			System.out.println(hiStd.getTeacher());
			hiStd.showInfo();
			
			
			System.out.println("=======================");
			// 부모클래스의 참조변수에 자식클래스의 인스턴스를 대입.
			Student std = /*(Student)*/ new HighStudent("T002","박길동",80,"김쌤");
			HighStudent hstd = (HighStudent) std;// Student타입.
			System.out.println(hiStd.getTeacher());			
//			System.out.println(hiStd.getSno());
			
			Student std1 = new Student("S003","박석민",80);
			if(std1 instanceof HighStudent) {
			HighStudent hstd1 = (HighStudent) std1;
			System.out.println(hstd1.getTeacher());	
			}			
			
			System.out.println("=======================");
			Student[] students = new Student[10];
			//HighStudent[] hiStudents = new HighStudent[10];
			
			students[0] = new Student("S001","김민석",90);
			students[1] = hiStd;
			
			for (int i = 0; i< students.length; i++) {
			if(students[i] != null) {
				students[i].showInfo();
			}
			}
			long ln1 =(long) 10; // 자동 형변환(promotion) 큰범위변수 = (큰범위변수) 작은 범위값
			int n1 = (int) ln1;// 강제형변환(casting)
		
	}
}



