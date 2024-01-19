package com.yedam.classes;

//학생정보관리 기능 구현.
public  class StudentApp {
	
	
	//필드.
	static Student[] students;// null.
	
	
	//생성자.
	public StudentApp() {
		students = new Student[10];
	}
	
	
	// 메소드.
	
	
	// 등록
	public static boolean add(Student std) {
		for(int i = 0; i < students.length; i++) {
			if(students[i] == null) {
				students[i]=std;
				return true;
			}
		}
		return false;
//		System.out.println("입력성공!");
	}
	
	
	//목록
	public static Student[] list() {
		return students;
	}
	
	
	   //수정(학생번호-점수)
	public static boolean modify(String sno, int score) {
		for(int i=0; i < students.length; i++) {
			if(students[i] != null && students[i].getSno().equals(sno)) {
				students[i].setScore(score);
				return true;
			}
		}
		return false;
	}
	
	
		//삭제(학생번호)
	public static boolean remove (String sno) {
		for(int i=0; i < students.length; i++) {
			if(students[i] != null && students[i].getSno().equals(sno)) {
				students[i]=null;
				return true;
			}
		}
		return false;
	}
	
	
	
	//단건조회 (학생번호)
	public static Student get(String sno) {
		for(int i=0; i < students.length; i++) {
			if(students[i] != null && students[i].getSno().equals(sno)) {
				return students[i];
			}
		}
		return null;
	}
	
	
}

	

	

