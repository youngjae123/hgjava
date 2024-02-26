package co.yedam;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.board.Board;
import co.yedam.board.x_BoardDAO;

				// name = "methodServ" > url호출
@WebServlet(name = "methodServ", urlPatterns = { "/methodServ", "/method" })
public class x_MethodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public x_MethodServlet() {
		super();

	}

	// HttpServletRequest request 사용자가 값을 넘겨주면 요청값을 분석해서 가지고 있는객체
	// init -> service -> destroy
	// 서비스가 없으면 -> 요청방식 : get요청방식 = url직접입력, 링크
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// 등록기능: 제목, 내용, 작성자
		String title = request.getParameter("title"); // 요청정보의 값중에서 title에 저장된 값을 읽음.
		String content = request.getParameter("content"); // 요청정보의 값중에서 content에 저장된 값을 읽음.
		String writer = request.getParameter("writer"); // 요청정보의 값중에서 writer에 저장된 값을 읽음.

		Board board = new Board();
		board.setTitle(title);
		board.setContent(content);
		board.setWriter(writer);

		x_BoardDAO dao = new x_BoardDAO();
		if (dao.insertBoard(board)) {
			response.getWriter().print("OK");
		} else {
			response.getWriter().print("NG");
		}
	}
	
	// post요청 = form태그의 method="post" -> 페이지를 직접 만들어야됨.
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		String bno = request.getParameter("bno");
		String title = request.getParameter("title"); // 요청정보의 값중에서 title에 저장된 값을 읽음. => 파라미터
		String content = request.getParameter("content"); // 요청정보의 값중에서 content에 저장된 값을 읽음.
		String writer = request.getParameter("writer"); // 요청정보의 값중에서 writer에 저장된 값을 읽음.
		
		Board board = new Board();
		board.setBoardNo(Integer.parseInt(bno));
		board.setTitle(title);
		board.setContent(content);
		board.setWriter(writer);
		
		
		//파라미터 4개를 가져와서 게시글번호의 값을 변경.
		x_BoardDAO dao = new x_BoardDAO();
		if (dao.updateBoard(board)) {
			response.getWriter().print("OK");
		} else {
			response.getWriter().print("NG");
		}
		
	}
	
}
