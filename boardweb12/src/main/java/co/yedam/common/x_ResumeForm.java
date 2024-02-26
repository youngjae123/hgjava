package co.yedam.common;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class x_ResumeForm implements Control {

	
	
	
	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path="WEB-INF/resume.html";
		req.getRequestDispatcher(path).forward(req, resp);
										//forward = FrontController클래스의 "/resume.do"를 호출하면 WEN-INF/resume.html 의 정보를 재지정해서 보여줌
		
	}

}
