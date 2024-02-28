package com.yedam.common;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FrontController extends HttpServlet{
   Map<String, Control> controls;
	
	public FrontController() {
		controls = new HashMap();
	}
	
	public void init(ServletConfig config) throws ServletException {
		//controls.put("/resume.do", new x_ResumeForm());
		controls.put("/main.do", new MainControl());
		
		//자바스크립트 연슨.
		controls.put("/userList.do", new UserListControl()) ;		
		
	}
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		
		String uri = req.getRequestURI();
		String context = req.getContextPath();
		String path = uri.substring(context.length());
		System.out.println("path:  " + path);
		
		Control control = controls.get(path);
		control.exec(req, resp); //요청 url에 따른 실행컨트롤을 호출.
	}

}
