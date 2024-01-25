package com.yedam.collection;

import java.util.ArrayList;
import java.util.List;

public class ListExe {
	public static void main(String[] args) {
		List<String> names = new ArrayList<>();
		names.add("홍길동");
		names.add("김민석");
		names.add("김민석");
		names.add(1,"이만수");
		names.add(1,"이만우");
		names.set(1,"김만우");
		names.remove(1); //한건삭제
//		names.clear();
	
//		System.out.println(names.size());// 크기확인.
//		if (names.size() >2) {
//			System.out.println(names.get(1));// names[1]
//		}
		
		// 반복문
		for(String name : names) {
		System.out.println(name);	
		}
	
	List<Member> members = new ArrayList<>();
	members.add(new Member(1,"홍길동"));
	members.add(new Member(2,"김민석"));
	members.add(new Member(3,"이충희"));
	
	
	for(int i = 0; i < members.size(); i++) {
		String name = members.get(i).getName();
		int id = members.get(i).getMid();
//		System.out.printf("이름: %s, 아이디: %d\n", name, id);
		System.out.printf("%s\n", members.get(i).toString());
	}
	
	for(int i =0; i<members.size(); i++) {
		if(members.get(i).getName().equals("김민석")) {
		members.set(i,new Member(4,"김길동"));
		System.out.println(members);
		}
	}
	}
}
