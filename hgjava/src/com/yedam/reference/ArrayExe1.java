package com.yedam.reference;

public class ArrayExe1 {
	public static void main(String[] args) {
		//선언.
		int[] intAry= {10, 20, 30};// intAry !==int  / intAry[0] === int
		int[][] intArray = { {10,20},{30,40},{50}};
		//intArray[0] !==int / intArray[0] === int , intArray[0][0] === int
		
		String[] strAry = new String[5]; // 크기 선언
		strAry = new String[] {"Hello","World","Nice"};
		
		for(String elem : strAry) {
			System.out.println(elem);
		}
	}
}
