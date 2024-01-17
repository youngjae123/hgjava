package com.yedam.todo;

import java.util.Scanner;

public class Todo0116 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		while(true) {
			System.out.println("값을 입력>>>");
			String input = scn.nextLine();
			//input.equals("quit")
		
			//입력값은 홍길동 입니다.
			//quit 값이 들어오면 console에 <<end of prog>> 출력  
			if(input.equals("quit")) {
//				System.out.println("end of prog");
				break;
			}
//			}else{//if end
			System.out.print("입력값은 " +input + " 입니다.");
			System.out.println();
//			}
		}//while end
	  }
}


 