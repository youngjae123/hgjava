package com.yedamhotel;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
 private String name;//고객명
 private String phone;//연락처
 private String id;//아이디
 private int roomno;//방번호
 private Date ci;//체크인
 private Date co;//체크아웃
 private int pr;//투숙인원
}
