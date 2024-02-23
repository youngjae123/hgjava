package co.yedam.board.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.yedam.board.Board;
import co.yedam.board.mapper.BoardMapper;
import co.yedam.common.DataSource;
import co.yedam.common.SearchVO;

// 업무로직을 담고 있는 프로세스.
// 데이터처리는 mapper 기능.
public class BoardServiceImpl implements BoardService{

	SqlSession session = DataSource.getinstance().openSession(true);
	BoardMapper mapper = session.getMapper(BoardMapper.class);
	@Override
	public List<Board> boardList(SearchVO search) {
		System.out.println(search);
		return mapper.boardList(search);
	}
	@Override
	public int boardTotalCnt(SearchVO search) {
		return mapper.getTotalCnt(search);
	}
    @Override
    public Board getBoard(int bno) {
    	mapper.updateCount(bno);
    	return mapper.selectBoard(bno);
    }
    
    @Override
    public boolean modifyBoard(Board board) {
    	if(mapper.modifyBoard(board)) {
    		return true;
    	}
    	return false;
    }
    
    @Override
    public boolean removeBoard(int bno) {
    	if(mapper.deleteBoard(bno)) {
    		return true;
    	}
    	return false;
    }
    
    public boolean addBoard(Board board) {
    	return mapper.addBoard(board) ==1;
    }
}
