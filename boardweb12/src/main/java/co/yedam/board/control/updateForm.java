package co.yedam.board.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.board.Board;
import co.yedam.board.service.BoardService;
import co.yedam.board.service.BoardServiceImp1;
import co.yedam.common.Control;

public class updateForm implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//파라미터
		String bno = req.getParameter("bno");
		
		BoardService svc = new BoardServiceImp1();
		//조회 ->Board board = svc.getBoard(Integer.parseInt(bno));
		Board board = svc.getBoard(Integer.parseInt(bno));
		
		req.setAttribute("board", board);
		//사용자의 요청정보를 담고 있는 정보. board라는 이름으로 담겨짐. 
		//String path = "WEB-INF/view/board.jsp";에 전달.
		// "board", board 굳이 통일 x 이름 헷갈리지만 않으면 됨.
		// board의 조회하여 저장.
		
		
		String path = "WEB-INF/view/updateForm.jsp";
		req.getRequestDispatcher(path).forward(req, resp);
		// 조회된결과가 보여짐.
	}

}
