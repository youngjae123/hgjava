package com.yedam.classes.friend;

//친구이름, 연락처(문자), 나이(정수)
public class Friend {
	//필드
	String sname;
	String snum;
	int age =0;
	
	//생성자: new Friend
	public Friend() {
		
	}
	public Friend(String name, String num){
		this.sname = name;
		this.snum = num;
	}
	public Friend(String name, String num, int age) {
		sname=name;
		snum=num;
		this.age=age;
	}
	
	//메소드
	void showInfo() {
		System.out.printf("이름은 %s, 연락처는 %s, 나이는 %d 입니다.\n",sname,snum,age);
	}
	String showInfoStr() {
		return "이름은" + sname;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSnum() {
		return snum;
	}
	public void setSnum(String snum) {
		this.snum = snum;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}
