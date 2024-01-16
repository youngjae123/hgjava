package com.yedam.variable;

public class VariableExe5 {
 public static void main(String[] args) {
	
	 double d1 = 10;
	 double result = d1 + (double) 20.0f;
//	 System.out.println(result);
	 
	 int sum = 60;
	 result =  sum*1.0 / 7 ; //80.0
//	 System.out.print(result);
	 
	 String str = "1"+3;
	 System.out.print(str);
	 
	 sum = Integer.parseInt("1") +3 +5;
	 
	 //char 65536개에
	 for (int i =0; i<10; i++) {
	 int temp = (int) (Math.random() * 25) + 97;
	 System.out.println((char)temp);
  }
 }
 
}
