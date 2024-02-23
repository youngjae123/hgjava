package co.yedam.board.mapper;

import java.util.List;

import co.yedam.board.Board;
import co.yedam.common.SearchVO;

public interface BoardMapper {

	List<Board> boardList(SearchVO search);
	int getTotalCnt(SearchVO search);
	
	// 상세화면에 사용될 데이터.
	Board selectBoard(int bno);
	// 조회수 증가.
	int updateCount(int bno);
	// 글 수정
	int updateBoard(Board board);
}
