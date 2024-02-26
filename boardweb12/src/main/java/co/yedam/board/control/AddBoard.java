package co.yedam.board.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.board.Board;
import co.yedam.board.service.BoardService;
import co.yedam.board.service.BoardServiceImp1;
import co.yedam.common.Control;

public class AddBoard implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
		BoardService svc = new BoardServiceImp1();
		
//		 String boardNo = req.getParameter("boardNo);
		 String title = req.getParameter("title");
		 String content = req.getParameter("content");
		 String writer = req.getParameter("writer");
		
		 Board board = new Board();
//		 board.setBoardNo(0);
		 board.setTitle(title);
		 board.setContent(content);
		 board.setWriter(writer);
		 
		 if(svc.addBoard(board)) {
				resp.sendRedirect("boardList.do"); // 맞으면 이동.
			} else {
				req.setAttribute("message", "삭제 중 에러가 발생했습니다.");
				String path = "WEB-INF/view/error.jsp"; // 원래페이지로 이동.
				req.getRequestDispatcher(path).forward(req, resp);
			}
	}
}
