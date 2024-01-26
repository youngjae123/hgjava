package com.yedam.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StudentApp {
	//초기화(text.dat) => 컬렉션에 저장.  
	//추가			=> 컬렉션에 추가
	//목록
	//종료			=> 컬렉션 -> 파일저장(text.dat).
	
	List<Student> storage = new ArrayList<>();
	
	public StudentApp() {
		init();
	}
	
	//초기화 컬렉션에다가 파일에 있는 정보들을 담아주는 것
	
	public void init() {
		try {
			FileReader fr = new FileReader("c:/temp/text.dat");
			BufferedReader br = new BufferedReader(fr);
			
			while(true) {
				String read = br.readLine();// 학생번호 이름 점수
				if(read == null) {
					break;
				}
				String[] readAry = read.split(" ");
				Student std = new Student(Integer.parseInt(readAry[0]), readAry[1], Integer.parseInt(readAry[2]));
				storage.add(std);
			}
			br.close();
			fr.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}//end of init
	
	//추가.
	public boolean add(Student std) {
		return storage.add(std);
	}
	
	
	//목록 반환.
	public List<Student> list() {
		return storage;
	}
	
	
	//종료
	public void save() {
	try {
		FileWriter fw = new FileWriter("c:/temp/text.dat");
		BufferedWriter bw = new BufferedWriter(fw);

		//반복
		for(Student std : storage) {
			String str = std.getSno() + " " + std.getSname() + " " + std.getScore();
			bw.write(str + "\n");
		}
		bw.flush(); fw.flush(); 
		bw.close(); fw.close();
		 
		
	} catch (IOException e) {
		e.printStackTrace();
	}
	}
}//class
