package co.yedam.board.service;

import java.util.List;

import co.yedam.board.Board;
import co.yedam.common.SearchVO;

public interface BoardService { //기능만.
	List<Board> boardList(SearchVO search);
	int boardTotalCnt(SearchVO search);
	
	//단건조회.
	Board getBoard(int bno);
	
	//수정
	boolean ModifyBoard(Board board);
	
	//삭제
	boolean removeBoard(int bno);
	
	//추가
	boolean addBoard(Board board);
}
