package co.yedam.common;

import java.util.List;

import co.yedam.board.Board;
import co.yedam.board.service.BoardService;
import co.yedam.board.service.BoardServiceImp1;

public class T_MainExe { //에러 확인용 클래스
	public static void main(String[] args) {
		
		//SqlSessionFactory factory = DateSource.getInstance();
		//SqlSession session = factory.openSession();
		
		SearchVO search = new SearchVO();
		search.setPage(1);
		search.setSearchCondition("T");
		search.setKeyword("테스트");
		BoardService svc = new BoardServiceImp1();
		List<Board> list = svc.boardList(search);
		
		
		//밑에 주석처리된거랑 결과값은 같음.
		//BoardMapper mapper = session.getMapper(BoardMapper.class);
		//List<Board> list = mapper.boardList();
		//List<Board> list = session.selectList("co.yedam.board.mapper.BoardMapper.boardList");
		for(Board board : list) {
			System.out.println(board.toString());
		}
	
	}
}
