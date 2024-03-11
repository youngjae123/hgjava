package co.yedam;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


// 서블릿 
@WebServlet("/booklist.do")
public class BookListControl extends HttpServlet {// expends Servlet
//bookList.do 호출 ...json 문자열 생성
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/json;charset=utf-8");
		// [ {"bookCode":"B001","bookName":"이것이자바다"},{}]
		BookService svc = new BookServiceImpl();
		List<BookVO> list = svc.bookList();
		String json = "[";
		for (int i = 0; i < list.size(); i++) {
			json += "{\"bookCode\":\"" + list.get(i).getBookCode() //
					+ "\",\"bookName\":\"" + list.get(i).getBookName()//
					+ "\",\"author\":\"" + list.get(i).getAuthor()//
					+ "\",\"press\":\"" + list.get(i).getPress()//
					+ "\",\"price\":\"" + list.get(i).getPrice()//
					+ "\"}";
			if (i != list.size() - 1) {
				json += ",";
			}
		}
		json += "]";

		resp.getWriter().print(json);
	}
}
