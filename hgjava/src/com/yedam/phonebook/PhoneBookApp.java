package com.yedam.phonebook;

//연락처 app

public class PhoneBookApp {

	public static void main(String[] args) {
		PhoneBookManager manager = PhoneBookManager.getInstance();
		// 사용자권한 체크
		// UserManager => userCheck(아이디,비번)
		// 3번 연속으로 인증이 실패할 경우 프로그램 종료

		int menu = 1;
		while (true) {
			try {
				MenuViewer.showMenu();
				menu = MenuViewer.keyboard.nextInt();

				if (menu < InitMenu.INPUT || menu > InitMenu.EXIT) {
					throw new MenuChoiceException(menu);
				}

				if (menu == InitMenu.INPUT) {
					manager.inputData();
				} else if (menu == InitMenu.SEARCH) {
					 manager.searchData();
				} else if (menu == InitMenu.DELETE) {
					manager.deleteData();
				} else if (menu == InitMenu.EXIT) {
					System.out.println("종료");
					manager.storeToFile();
					break;
				}
			} catch (MenuChoiceException e) {
				e.showWrongChoice();
			}
		}
		System.out.println("end of prog");
	}
}
