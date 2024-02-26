package co.yedam;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.board.Board;
import co.yedam.board.x_BoardDAO;

// 서블릿 실행: http://localhost:8080/boardweb/welcome.do
// 프로젝트의 환경파일 web.xml에 등록.
// 서블릿 컨테이너: 서블릿의 생명주기(init -> service -> destroy) 메소드. 관리. *
// init() : 최초 요청 때 한번만 실행.
// service() : 서버가 실행이 되고 나서 요청이 있을 때마다 실행.
// destroy() : 서비스 종료...

public class x_WelcomeServlet extends HttpServlet {
	public x_WelcomeServlet() {
		System.out.println("WelcomeServlet 실행..");
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init 실행..");
	}

	@Override // HttpServletRequest 사용자의 요청정보를 파악해서 http에
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8"); // 웹브라우저에 전송되는 컨텐츠 타입을 알려줌.
		System.out.println("service 실행..");

		String html = "<h3>여기는 servlet </h3>";
		html += "<a href='index.html'>인덱스로 이동 </a>"; // 같은경로(이름만).

		// 글목록 출력추가.
		x_BoardDAO dao = new x_BoardDAO();
		List<Board> list = dao.boardList();

		html += "<table border='1'><thead></tr><th>글번호</th><th>제목</th><th>작성자</th></tr></thead>";
		html += "<tbody>";

		for (Board board : list) {
			html += "<tr><td>" + board.getBoardNo() //
			+ "</td><td>" + board.getTitle()  //
			+ "</td><td>" + board.getWriter() //
			+ "</td></tr>";
		}
		html += "</tbody></table>";

		// 요청에 대한 응답값을 받아서 클라이언트에 보냄.
		PrintWriter out = resp.getWriter(); // 클라이언트 쪽으로 출력스트림을 만듦.
		out.print(html);
	}

	@Override
	public void destroy() {
		System.out.println("destroy 실행..");
	}
}
