package com.yedam.thread;

import java.awt.Toolkit;

//소리출력  & 문자출력.
public class BeepPrintExe {
 public static void main(String[] args) {
	
//	 Toolkit toolkit = Toolkit.getDefaultToolkit();
//	 for(int i =0; i <5; i++) {
//		 toolkit.beep();
//		 try {
//				Thread.sleep(5000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//	 }
	 
	 Thread thread = new Thread(new BeepTask());
	 thread.start(); // start 호출하면 run() 메소드 실행.
	 
	 // 메인쓰레드가 실행.
	 for(int i = 0; i < 5; i++) {
		 System.out.println("print");
		 try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	 }
}
}
