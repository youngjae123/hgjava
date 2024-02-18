package com.yedamhotel;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
	String name;// 고객명
	String phone;// 연락처
	String id;// 아이디
	String roomno;// 방번호
	String ci;// 체크인
	String co;// 체크아웃
	int pr;// 투숙인원
	int carge = 0;

	public static Customer[] getBox() {
		return box;
	}

	public static void setBox(Customer[] box) {
		Customer.box = box;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRoomno() {
		return roomno;
	}

	public void setRoomno(String roomno) {
		this.roomno = roomno;
	}


	public String getCo() {
		return co;
	}

	public void setCo(String co) {
		this.co = co;
	}

	public int getPr() {
		return pr;
	}

	public void setPr(int pr) {
		this.pr = pr;
	}

	public int getCarge() {
		return carge;
	}

	public void setCarge(int carge) {
		this.carge = carge;
	}

	public static int getMax() {
		return MAX;
	}

	final static int MAX = 25;
	public static Customer box[] = new Customer[MAX];
	Date date = new Date();

	public Customer(String name2, String phone2, String id2, int rno, Date date, Date date2, int pr2) {
	}

	public Customer() {
	}

	public Customer(String name2, String phone2, String id2, String ci2, String co2, int pr2) {
	}

	public String getRoomno(String string) {
		return null;
	}

	public String getCi() {
		return null;
	}


	public void setCi(String string) {
		
	}

	public void setRoomno(int co2) {
		
	}

	public void setPr(Object object) {
		
	}

//	public long in_time = System.currentTimeMillis();
//	public long out_time = System.currentTimeMillis();
}