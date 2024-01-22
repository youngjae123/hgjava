package com.yedam.classes;

//학생번호, 이름, 점수, 키
//소개(학생번호, 이름, 점수)
public class Student {
	// 필드
	private String sno; //초기값 null
	private String sname;
	private int score; ///0
	private double height;// 0.0
	private boolean onSchool;
	
	public boolean isOnSchool() {
		return onSchool;
	}
	public void setOnSchool(boolean onSchool) {
		this.onSchool = onSchool;
	}
	//생성자:new Student()
	public Student(){
	}
	public Student(String no, String name) {
		sno = no;
		sname =name;
	}
	public Student(String no, String name, int score) {
//		sno =no;
//		sname = name;
		this(no,name);
		this.score = score;
	}
	public Student(String sno, String sname, int score, double height) {
		this.sno = sno;
		this.sname = sname;
		this.score = score;
		this.height = height;
	}
	
	
	//메소드
	public void showInfo() {
		System.out.printf("번호는 %s, 이름은 %s, 점수는 %d 키는 %.1f, 입니다.\n", sno, sname, score, height);
	}
//	String showInfoStr() {
//		return "번호는" + sno;
//	}
	
	
	
	
	
	
	
	public void setHeight(double height) {
		if(height <0) {
			this.height = 160;
		}else {
		this.height = height;
		}
	}
	public double getHeight() {
		return this.height;
	}
	//sno, sname, score
	public String getSno() {
		return sno;
	}
	public void setSno(String sno) {
		this.sno = sno;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
	
	
	
	
	
}
