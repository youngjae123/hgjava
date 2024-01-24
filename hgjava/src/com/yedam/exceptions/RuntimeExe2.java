package com.yedam.exceptions;

public class RuntimeExe2 {
	public static void main(String[] args) {
		
		//실행예외.
		String str = "10";
		
		str = null;
		try {
			str = "ten";
		System.out.println(str.toString()); // NullPointer
		int num = Integer.parseInt(str); // NumberFormat
//		} catch(NullPointerException ne) {
//			//ne.printStackTrace();
//			System.out.println("참조값이 없음.");
//		} catch(NumberFormatException ne2) {
//			//ne2.printStackTrace();
//			System.out.println("숫자 값이 아님");
		
			}catch (Exception e) {
				System.out.println("알수없는 예외.");
				
			}
	}
}
