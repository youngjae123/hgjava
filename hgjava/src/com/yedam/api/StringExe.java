package com.yedam.api;

public class StringExe {
	public static void main(String[] args) {
		
	String str = "Hello";
	str = new String("Hello");
	byte[] bytes = str.getBytes();
	for(byte b : bytes) {
		System.out.println(b);
		}
	str = new String(new byte[] {72, 101, 108, 108, 111});
	
	int pos = str.indexOf("1");
	System.out.println("1은 " + pos + "위치에 있음.");
	
	char chr = str.charAt(0);
	System.out.println(chr);
	}
}