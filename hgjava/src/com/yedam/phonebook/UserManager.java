package com.yedam.phonebook;

import java.util.Scanner;

//기능은 c:/temp/userList.txt 에 저장된 아이디/비번을 이용
public class UserManager {

		String id;
		String pass;
		String name;
		
	public UserManager(String id, String pass, String name) {
		this.id = id;
		this.pass = pass;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
//	public class UserApp{
//		private User[] users;
//		
//	}
//		public User logi(String id, String pw) {
//			for(int i = 0; i < users.lenght; i++) {
//				if(users[i] != null) {
//					
//				}
//			}
//		}
}
