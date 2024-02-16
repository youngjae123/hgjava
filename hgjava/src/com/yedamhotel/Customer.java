package com.yedamhotel;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
	final static int MAX = 25;
	public static Customer box[] = new Customer[MAX];
	Date date = new Date();
	public Customer(String name2, String phone2, String id2, int rno, Date date, Date date2, int pr2) {
	}
	 String name;// 고객명
	 String phone;// 연락처
	 String id;// 아이디
	 String roomno;// 방번호
	 Date ci;// 체크인
	 String co;// 체크아웃
	 int pr;// 투숙인원

//	public long in_time = System.currentTimeMillis();
//	public long out_time = System.currentTimeMillis();
	int carge = 0;
}