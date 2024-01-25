package com.yedam.collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapExe {
	public static void main(String[] args) {
		//키: 값.
		Map<Integer, String> map = new HashMap<>();
		map.put(1, "홍길동");
		map.put(2, "김길동");
		map.put(3, "박길동");
		map.put(4, "홍길동");
		map.put(3, "최길동");
		map.put(3, "최길동");

		map.remove(3); // 삭제
		
		System.out.println("크기: " + map.size());
		
		//키 값만 set.
		Set<Integer> keyset = map.keySet();
		Iterator<Integer> iter = keyset.iterator();
		while(iter.hasNext()) {
			Integer key = iter.next();
			String val = map.get(key); // 키의 값을 반환.
			System.out.printf("키: %d, 값:%s \n", key, val);
		}
		
		//키, 값 = > set.
		Set<Entry<Integer, String>> entry = map.entrySet();
		Iterator<Entry<Integer, String>> eiter = entry.iterator();
		while(eiter.hasNext()) {
			Entry<Integer, String> ent = eiter.next();
			System.out.printf("키: %d, 값: %s \n", ent.getKey(), ent.getValue());
		}
		
	}
}
