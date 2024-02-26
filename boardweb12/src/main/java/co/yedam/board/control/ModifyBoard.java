package co.yedam.board.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.board.Board;
import co.yedam.board.service.BoardService;
import co.yedam.board.service.BoardServiceImp1;
import co.yedam.common.Control;

public class ModifyBoard implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				//파라미터
				String bno = req.getParameter("bno");
				String title = req.getParameter("title");
				String content = req.getParameter("content");
				
				Board board = new Board();
				board.setBoardNo(Integer.parseInt(bno));
				board.setTitle(title);
				board.setContent(content);
				
				
				// boolean modifyBoard(Board)
				BoardService svc = new BoardServiceImp1();
				
				if(svc.ModifyBoard(board)) {
					resp.sendRedirect("boardList.do"); // 맞으면 이동.
				} else {
					req.setAttribute("message", "수정 중 에러가 발생했습니다.");
					String path = "WEB-INF/view/error.jsp"; // 원래페이지로 이동.
					req.getRequestDispatcher(path).forward(req, resp);
				}
				//조회 ->Board board = svc.getBoard(Integer.parseInt(bno));
				
				
				
//				req.setAttribute("board", board);
//				//사용자의 요청정보를 담고 있는 정보. board라는 이름으로 담겨짐. 
//				//String path = "WEB-INF/view/board.jsp";에 전달.
//				// "board", board 굳이 통일 x 이름 헷갈리지만 않으면 됨.
//				// board의 조회하여 저장.
//				
//				
//				String path = "WEB-INF/view/updateForm.jsp";
//				req.getRequestDispatcher(path).forward(req, resp);
//				// 조회된결과가 보여짐.

	}

}
