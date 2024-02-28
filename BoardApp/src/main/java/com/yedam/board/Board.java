package com.yedam.board;

import java.util.Date;

import lombok.Data;

@Data
public class Board {
	private int boardNo;
	private String title;
	private String content;
	private String writer;
	private String viewCnt;
	private Date createDate;
}
