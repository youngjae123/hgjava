package co.yedam.board.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.yedam.board.Board;
import co.yedam.board.control.ModifyBoard;
import co.yedam.board.mapper.BoardMapper;
import co.yedam.common.DateSource;
import co.yedam.common.SearchVO;

	// 업무로직을 담고 있는 프로세스.
	// 데이터처리는 mapper 기능.
public class BoardServiceImp1 implements BoardService { 
	//BoardService의 기능을 구현하는 클래스.
	//BoardService의 메소드를 반드시 구현해야함.
	
	SqlSession session = DateSource.getInstance().openSession(true);
										//openSession(true) 기본값은 false	//true -> 자동커밋하게 만듦.
	BoardMapper mapper = session.getMapper(BoardMapper.class); 
										// BoardMapper.class 실행되는 시점에 class의 정보를 읽고 객체를 만들어줌.
	
	@Override
	public List<Board> boardList(SearchVO search) {
		System.out.println(search);
		return mapper.boardList(search);	}
	
	@Override
		public int boardTotalCnt(SearchVO search) {
			return mapper.getTotalCnt(search);
		}
	
	//조회 , 조회수카운트
	@Override
	public Board getBoard(int bno) {
		mapper.updateCount(bno); //한번 조회할 떄마다 조회된 카운트를 들고옴.
		
//		if(mapper.updateCount(bno)) {
//			
//		}else {
//			
//		}
		return mapper.selectBoard(bno); //조회
		//구현되는 클래스
	}

	

	@Override
	public boolean ModifyBoard(Board board) {
		return mapper.updateBoard(board) == 1;
	}

	@Override
	public boolean removeBoard(int bno) {
		return mapper.deleteBoard(bno) == 1;
		
	}

	@Override
	public boolean addBoard(Board board) {
		return mapper.insertBoard(board) == 1;
	}
}
