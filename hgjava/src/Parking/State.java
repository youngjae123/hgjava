package Parking;

import java.util.Date;


public class State {//dao
		final static int MAX = 8;
		Date date = new Date();

		public Box box[] = new Box[MAX];

		public State() {
			this.create(MAX);
		}

		public void create(int a) {//박스 만드는 메서드
			for (int i = 0; i < a; i++) {
				box[i] = new Box();
			}//8개 인덱스 생성

			for (int i = 0; i < a; i++) {
				box[i].setNum("(" + i + ")");
				//box 클래스의 num값에 를 넣음
			}
		}

		public void print_state() {//메뉴 보여주는 메서드
			System.out.println("==============================================\n << 현재 주차장 상태 >>");
			for (int i = 0; i < MAX / 2; i++) {
				System.out.print("[" + box[i].getNum() + "]");
			}

			System.out.println();

			for (int i = MAX / 2; i < MAX; i++) {
				System.out.print("[" + box[i].getNum() + "]");
			}

			System.out.println();
		}//위에 그림 4개 밑에 그림 4개 보여줘

		public void init(int a) {//퇴실때 빈값만드는 메서
			box[a].setNum("(" + a + ")");//num에 a값이 들어감
			box[a].setName("");
			box[a].setCar_num("");
			box[a].setIn("");
			box[a].setOut("");
			box[a].setCharge(0);
		}

		public void charges(int a) {
			if (box[a].getNum() == " ■ ") {//box배열에 a인덱스에 getNum값이 네모이면 실행해라
				box[a].charge = ((int) ((box[a].out_time - box[a].in_time) / 100)) * 10;//
			}
		}

		public void charge_inform(int i) {
			System.out.println("==============================================\n [ " + i + " ]");
			System.out.println("주차시간 : " + box[i].getIn());//i번 박스에 in
			System.out.println("출차시간 : " + box[i].getOut());//i번 박스에 out
			if (box[i].getNum() == " ■ ") {
				box[i].out_time = System.currentTimeMillis();
			}
			charges(i);//값 넣기
			System.out.println("주차요금 : " + box[i].getCharge() + "원");
		}

		public void clear() {
			for (int i = 0; i < 25; i++)
				System.out.println();
		}
	}

