package com.yedam.api;

import java.util.ArrayList;
import java.util.List;

public class WrapperExe {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(Integer.valueOf(1));// 기본타입 <-> 래퍼클래스
		
		Double d1 = Double.valueOf("2.3");
		
		System.out.print(Math.round(2.1));
	}
}
