package com.yedam;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yedam.board.Board;
import com.yedam.board.mapper.BoardMapper;
import com.yedam.common.DataSource;

public class TestMain {
	public static void main(String[] args) {
		
		SqlSession session = DataSource.getInstance().openSession();
		BoardMapper mapper = session.getMapper(BoardMapper.class);
		
		List<Board> list = mapper.boardList();
		for(Board board : list) {
			System.out.println(board.toString());
		}
	}

}
