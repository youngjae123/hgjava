package com.yedamhotel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Room {
 private int roomno;//방 번호
 private String roomtype;//방 타임
 private int roommoney;//방 가격
 private String roomstate;//방 상태
 private int maxperson;//쵀대 인원
public int getRoomno() {
	return roomno;
}
public void setRoomno(int roomno) {
	this.roomno = roomno;
}
public String getRoomtype() {
	return roomtype;
}
public void setRoomtype(String roomtype) {
	this.roomtype = roomtype;
}
public int getRoommoney() {
	return roommoney;
}
public void setRoommoney(int roommoney) {
	this.roommoney = roommoney;
}
public String getRoomstate() {
	return roomstate;
}
public void setRoomstate(String roomstate) {
	this.roomstate = roomstate;
}
public int getMaxperson() {
	return maxperson;
}
public void setMaxperson(int maxperson) {
	this.maxperson = maxperson;
}
 
 
}


