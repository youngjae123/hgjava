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

public Room() {
}

public int getRoomno() {
	return roomno;
}

public void setRoomno(int roomno) {
	this.roomno = roomno;
}

public String getRoomtp() {
	return roomtp;
}

public void setRoomtp(String roomtp) {
	this.roomtp = roomtp;
}

public String getRoomct() {
	return roomct;
}

public void setRoomct(String roomct) {
	this.roomct = roomct;
}

public int getRoomm() {
	return roomm;
}

public void setRoomm(int roomm) {
	this.roomm = roomm;
}

public String getRoomnow() {
	return roomnow;
}

public void setRoomnow(String roomnow) {
	this.roomnow = roomnow;
}

public int getMax() {
	return max;
}

public void setMax(int max) {
	this.max = max;
}


}
