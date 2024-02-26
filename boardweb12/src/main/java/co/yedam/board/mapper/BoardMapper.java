package co.yedam.board.mapper;

import java.util.List;

import co.yedam.board.Board;
import co.yedam.common.SearchVO;


public interface BoardMapper { // 인터페이스 -> 기능만 있음. 실행x
	
	//
	List<Board> boardList(SearchVO search);
	int getTotalCnt(SearchVO search);
	
	// 상세화면에 사용될 데이터.
	Board selectBoard(int bno);
	// BoardMapper
	// <select id="selectBoard" resultType="board" parameterType="int"> 을 매칭시켜줌.
	
	// 조회수 증가.
	int updateCount(int bno);
	// updateCount < id 값
	
	// 글 수정
	int updateBoard(Board board);
					//Board 가 가지고 있는 각각의 속성들을 들고옴
	
	// 글 삭제
	int deleteBoard(int bno);
	
	// 글 등록
	int insertBoard(Board board);
}

