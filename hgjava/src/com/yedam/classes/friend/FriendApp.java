package com.yedam.classes.friend;

//등록기능, 수정기능, 삭제기능, 목록, 단건조회 기능

public class FriendApp {
//필드: 친구정보를 저장할 수 있는 배열.
	Friend[] friends;
	
	//생성자.
	public FriendApp() {
		friends = new Friend[10];
	}
	
	//메소드
	//등록
	public boolean add(Friend frd) {
		for(int i = 0 ; i < friends.length;i++) {
			if(friends[i] ==null) {
				friends[i]=frd;
				return true;
			}
		}
		return false;
	}
	
	//목록
	public Friend[] list() {
		return friends;
	}
	//수정
	public boolean modify(String sname, String snum) {
		for(int i = 0; i < friends.length; i++) {
			if(friends[i] != null && friends[i].getSname().equals(sname)) {
				friends[i].setSnum(snum);
				return true;
			}
		}
		return false;
	}
}
