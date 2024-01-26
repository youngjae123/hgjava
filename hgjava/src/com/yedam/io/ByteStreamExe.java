package com.yedam.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStreamExe {
	
	public static void main(String[] args) {
		// 입력출력 => 복사.
		try {
			FileInputStream fis = new FileInputStream("c:/temp/npp.exe");
			FileOutputStream fos = new FileOutputStream("c:/temp/copy2.exe");
			//byte[] byteAry = new byte[100];
			
			//보조스트림. Buffered
			BufferedInputStream bis = new BufferedInputStream(fis);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			
			
			
			
			
			
			while(true) {
			int buf = bis.read();//fis.read(byteAry);
			if(buf == -1) {
				break;// 종료.
			}
			//fos.write(byteAry);
			bos.write(buf);
			}
			
//			fos.flush(); fos.close();
//			fis.close();
			bos.flush();
			bos.close();
			fos.flush();
			fos.close();
			bis.close();
			fis.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		System.out.println("end of file");
	}
	
	
	static void read() {
		try {
			FileInputStream fis = new FileInputStream("c:/temp/sample.dat");
			
			while (true) {
			int bytes = fis.read(); // eof => -1 반환
			if(bytes == -1) {
				break;
			}
			System.out.println(bytes);
		}
			fis.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	static void write() {
		//바이트 출력 스트림.
				try {
					FileOutputStream fos = new FileOutputStream("c:/temp/sample.dat");
					fos.write(10);
					fos.write(20);
					fos.write(30);
					fos.flush();
					fos.close(); // 자원환원.
					
				} catch (IOException e) {
					e.printStackTrace();
				}
	}
}
