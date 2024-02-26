package co.yedam.board.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.board.Board;
import co.yedam.board.service.BoardService;
import co.yedam.board.service.BoardServiceImp1;
import co.yedam.common.Control;

public class RemoveBoard implements Control {
	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String bno = req.getParameter("bno");
		
		BoardService svc = new BoardServiceImp1();
		
		if(svc.removeBoard(Integer.parseInt(bno))) {
			resp.sendRedirect("boardList.do"); // 맞으면 이동.
		} else {
			req.setAttribute("message", "삭제 중 에러가 발생했습니다.");
			String path = "WEB-INF/view/error.jsp"; // 원래페이지로 이동.
			req.getRequestDispatcher(path).forward(req, resp);
		}
		
		// mapper -> deleteBoard (int)
		// service -> removeBoard (int)
		// 잘 삭제되면 목록. 안되면 에러페이지
		
		
	}
}
