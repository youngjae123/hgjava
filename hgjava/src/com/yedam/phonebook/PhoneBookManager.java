package com.yedam.phonebook;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;

//기능
// 생성자(초기화), 등록 , 검색, 삭제, 종료(파일저장)
public class PhoneBookManager {

	private File dataFile = new File("C:/temp/phonebook.dat");
	// 컬렉션선언
	HashSet<PhoneInfo> storage = new HashSet<>();

	// 싱글톤.
	private static PhoneBookManager instance; // 초기값 = null.

	private PhoneBookManager() {
		// 초기화작업.
		readFromFile();
	}

	public static PhoneBookManager getInstance() {
		if (instance == null) {
			instance = new PhoneBookManager();
		}
		return instance;
	}

	// 메소드1,2,3,
	private PhoneInfo getFriendInfo() {
		System.out.println("이름>>");
		String name = MenuViewer.keyboard.nextLine();
		System.out.println("연락처>");
		String phone = MenuViewer.keyboard.nextLine();
		return new PhoneInfo(name, phone);
	}

	private PhoneInfo getCompanyFriendInfo() {
		System.out.println("이름>>");
		String name = MenuViewer.keyboard.nextLine();
		System.out.println("연락처>");
		String phone = MenuViewer.keyboard.nextLine();
		System.out.println("회사>");
		String company = MenuViewer.keyboard.nextLine();
		return new PhoneCompanyInfo(name, phone, company);
	}

	private PhoneInfo getunivFriendInfo() {
		System.out.println("이름>>");
		String name = MenuViewer.keyboard.nextLine();
		System.out.println("연락처>");
		String phone = MenuViewer.keyboard.nextLine();
		System.out.println("회사>");
		String company = MenuViewer.keyboard.nextLine();
		System.out.println("학년>");
		int year = MenuViewer.keyboard.nextInt();
		MenuViewer.keyboard.nextLine();
		return new PhoneUnivInfo(name, phone, company, year);
	}

	// 추가
	public void inputData() {
		System.out.println("구분");
		System.out.println("1.일반 2.회사 3.학교");
		System.out.print("선택>>");
		int choice = MenuViewer.keyboard.nextInt();
		MenuViewer.keyboard.nextLine();

		PhoneInfo info = null;
		switch (choice) {
		case InputSelect.NORMAL:
			info = getFriendInfo();
			break;
		case InputSelect.COMPANY:
			info = getCompanyFriendInfo();
			break;
		case InputSelect.UNIV:
			info = getunivFriendInfo();
		}

		if (storage.add(info)) {
			System.out.println("등록완료");
		} else {
			System.out.println("등록오류");
		}

	}

	// 삭제
	public void deleteData() {
		// 이름 검색 후 삭제.
		// Iterator => iter.hasNext, iter.next, itr.remove
		System.out.println("이름>>");
		String name = MenuViewer.keyboard.nextLine();

		Iterator<PhoneInfo> iter = storage.iterator();
		while (iter.hasNext()) {
			PhoneInfo info = iter.next();
			if(info.getName().equals(name)) {
				iter.remove();
				System.out.println("삭제완료");
				return;
			}
		}
		System.out.println("삭제할 이름이 없습니다");
	}
	
	//검색
	public void searchData() {
		MenuViewer.keyboard.nextLine();
		System.out.println("이름>>");
		String name = MenuViewer.keyboard.nextLine();
		
		Iterator<PhoneInfo> iter = storage.iterator();
		while (iter.hasNext()) {
			PhoneInfo info = iter.next();
			if(info.getName().equals(name)) {
				System.out.printf("이름: %s 연락처: %s\n", info.getName(),info.getPhone());
				return;
			}
		}
		System.out.println("검색할 이름이 없습니다.");
		
	}
	
	// 초기화.
	public void readFromFile() {
		if (dataFile.exists() == false) {
			return; // 메소드 종료.
		}

		try {
			// 있으면 => 파일을 읽음
			FileReader fr = new FileReader(dataFile);
			BufferedReader br = new BufferedReader(fr);
			String str = "";
			PhoneInfo info = null;
			while ((str = br.readLine()) != null) {
				String[] record = str.split(",");
				// 컬렉션에 저장.
				int type = Integer.parseInt(record[0]);
				switch (type) {
				case InputSelect.NORMAL:
					info = new PhoneInfo(record[1], record[2]);
					break;
				case InputSelect.COMPANY:
					info = new PhoneCompanyInfo(record[1], record[2], record[3]);
				case InputSelect.UNIV:
					info = new PhoneUnivInfo(record[1], record[2], record[3], Integer.parseInt(record[4]));
				}
				storage.add(info);
			} // end of while.

		} catch (Exception e) {
			e.printStackTrace();
		}
	}// end of readFromFile()

	// 저장.
	public void storeToFile() {
		try {
			FileWriter fr = new FileWriter(dataFile);
			Iterator<PhoneInfo> iter = storage.iterator();

			while (iter.hasNext()) {
				PhoneInfo info = iter.next();
				// toString
				fr.write(info.toString());
			}
			fr.flush();
			fr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}// end of class