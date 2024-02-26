package co.yedam.board.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.board.Board;
import co.yedam.board.service.BoardService;
import co.yedam.board.service.BoardServiceImp1;
import co.yedam.common.Control;

public class RemoveForm implements Control{ // FrontControl 의 controls.put("/removeForm.do", new RemoveForm()); // 삭제화면으로 이동 (삭제 처리x)
											// 을 만들기 위해서
	
	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String bno = req.getParameter("bno"); //bno > int타입 나중에 파싱해야함
		
		BoardService svc = new BoardServiceImp1();
		Board board = svc.getBoard(Integer.parseInt(bno));
		// WEB-INF/view/deleteForm.jsp 로
		req.setAttribute("board", board);
		
		String path = "WEB-INF/view/deleteForm.jsp";
		req.getRequestDispatcher(path).forward(req, resp);
		


	
		
		
	}
	
}
