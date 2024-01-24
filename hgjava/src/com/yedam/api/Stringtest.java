package com.yedam.api;

public class Stringtest {

	public static void main(String[] args) {
		//1
		String[] jumins = { "970101-1234567","970101-2234567","9701011234567","970101 1234567","030101 4234567"};
		for (String ssn : jumins) {
			checkGender(ssn);
		}
		
		//2번문제 길동 몇번
		int gil =0;
		String[] names = { "김길동" , "홍길동","이상민","김민수","길동이"};
		for(int i = 0; i < names.length; i++) {
		if(names[i].indexOf("길동") != -1) {
			gil++;
	}
	}//for
		System.out.printf("길동은 %d번 나왔습니다.",gil);
	}	
	
	//if(names[i]==names[i].indexOf("길동"){
	//System.out.printf("길동은 %d번 나왔습니다.",name);

static void checkGender(String ssn) {
	
	
	if(ssn.length()==13) {
	char sex = ssn.charAt(6);
	switch (sex) {
	case '1':
	case '3':
		System.out.println("남자입니다.");
		break;
	case '2':
	case '4':
		System.out.println("여자입니다.");
		break;
	}
	
	}
	if(ssn.length()==14) {
		char sex = ssn.charAt(7);
	switch (sex) {
	case '1':
	case '3':
		System.out.println("남자입니다.");
		break;
	case '2':
	case '4':
		System.out.println("여자입니다.");
		break;
	}
	}
	
}
}
