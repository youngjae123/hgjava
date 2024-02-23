package co.yedam.board.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.board.Board;
import co.yedam.board.service.BoardService;
import co.yedam.board.service.BoardServiceImpl;
import co.yedam.common.Control;

public class RemoveForm implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String bno = req.getParameter("bno");
		
		// WEB-INF/view/deleteForm.jsp
		BoardService svc = new BoardServiceImpl();
		Board board = svc.getBoard(Integer.parseInt(bno));
		System.out.println(board);
		req.setAttribute("board", board);
		
		String path = "WEB-INF/view/deleteForm.jsp";
		req.getRequestDispatcher(path).forward(req, resp);
		
	}

}
