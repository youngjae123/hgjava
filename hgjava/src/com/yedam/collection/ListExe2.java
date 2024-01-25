package com.yedam.collection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListExe2 {
	public static void main(String[] args) {
		List<String> list1 = new ArrayList<>();
		long start = System.currentTimeMillis();
		for(int i =0; i < 100000; i++) {
			list1.add(String.valueOf(i));
		}
		long end = System.currentTimeMillis();
		System.out.println("결과1: " + (end - start));
		
		List<String> list2 = new LinkedList<>();
		start = System.currentTimeMillis();
		for(int i =0; i < 100000; i++) {
			list2.add(String.valueOf(i));
		}
		end = System.currentTimeMillis();
		System.out.println("결과2: " + (end - start));
	}
}
