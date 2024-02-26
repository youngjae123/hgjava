package co.yedam.board.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.board.Board;
import co.yedam.board.service.BoardService;
import co.yedam.board.service.BoardServiceImp1;
import co.yedam.common.Control;

public class BoardControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String bno = req.getParameter("bno");
		
		BoardService svc = new BoardServiceImp1();
		
		Board board = svc.getBoard(Integer.parseInt(bno));
		
		req.setAttribute("board", board);
		//사용자의 요청정보를 담고 있는 정보. board라는 이름으로 담겨짐. 
		//String path = "WEB-INF/view/board.jsp";에 전달.
		// "board", board 굳이 통일 x 이름 헷갈리지만 않으면 됨.
		
		
		String path = "board/board.tiles";
		req.getRequestDispatcher(path).forward(req, resp);
											//요청정보와 응답정보를 같이 전달.
		
	}

}
