package com.yedamhotel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Room {
 private int roomno;//방 번호
 private String roomtp;//방 타임
 private String roomct;//방 갯수
 private int roomm;//방 가격
 private String roomnow;//방 상태
 private int max;//쵀대 인원
 
 public Room(int roomno,String roomtp,String roomct, int roomm, int max) {
	 this.roomno = roomno;
	 this.roomtp = roomtp;
	 this.roomct = roomct;
	 this.max = max;
	 
 }

public Room(String id, String ci, String co, int int1, int int2) {
	// TODO Auto-generated constructor stub
}

}
