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
 
 
}


