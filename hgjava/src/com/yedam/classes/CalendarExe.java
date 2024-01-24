package com.yedam.classes;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
public class CalendarExe {
	public static void main(String[] args) {
//		final int num = 10;
//
//		
//		Calendar cal = Calendar.getInstance();
////		System.out.println(Calendar.YEAR);
//		cal.set(2024, 2, 1);
//		System.out.println("year: " + cal.get(Calendar.DAY_OF_WEEK));
//		System.out.println("last Date: " + cal.getActualMaximum(Calendar.DATE));
//		
		//drawCalendar(2022,1);
		
		Date date = new Date();
		//2024-10-5
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			date = sdf.parse("2024-1-1");//String -> Date
		} catch (Exception e) {
			e.printStackTrace();
		}
			System.out.println(date.getMonth());
//		date.setYear(123);
//		date.setMonth(1);
//		System.out.println(date.getYear()+1900);
//		System.out.println(date.getMonth());
//		System.out.println(date.getDate());
			drawcalendar(date);//숙제
	}
	
	//과제
	static void drawcalendar(Date date) {
		//문자열로 날짜
	}
	
	
	
	
	
	static void drawCalendar(int year, int month) {
		//(2024, 1)
		Calendar cal = Calendar.getInstance();
		cal.set(year, month -1, 1);
		
		int pos = cal.get(Calendar.DAY_OF_WEEK)-1;
		int lastDate = cal.getActualMaximum(Calendar.DATE);

		// 요일출력.
//		String[] days = { "Sun" , "Mon", "Tue", "Thr", "Fri", "Sat"};
//		for(int i=0; i <days.length; i++) {
//			System.out.printf("%4s,day[i]");
//		}
		//1일의 요일지정
		System.out.println("");
		for(int i =0; i <pos; i++) {
			System.out.printf("%4s","");
		}
		//날짜출력
		for ( int d= 1; d <= lastDate ; d++) {
			System.out.printf("%4d",d);
			if(d%7 == (7-pos)) {// 수정..
				System.out.println();
			}//if end
		}//for end
		System.out.println();
		System.out.println("========end of pfog=======");
	}
}
