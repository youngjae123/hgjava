package co.yedam.common;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.board.control.AddBoard;
import co.yedam.board.control.AddForm;
import co.yedam.board.control.BoardControl;
import co.yedam.board.control.BoardListControl;
import co.yedam.board.control.ModifyBoard;
import co.yedam.board.control.RemoveBoard;
import co.yedam.board.control.RemoveForm;
import co.yedam.board.control.updateForm;
import co.yedam.member.control.AddMemberControl;
import co.yedam.member.control.AddMemberForm;
import co.yedam.member.control.LoginControl;
import co.yedam.member.control.LoginForm;
import co.yedam.member.control.LogoutControl;
import co.yedam.member.control.MemberList;

// init -> service -> destroy
public class FrontController extends HttpServlet {
	
	
	// Map 타입으로 url과 실행할 클래스를 등록.
	//String 타입인 Control 클래스의 값
	Map<String, Control> controls;
	
	public FrontController(){
		controls = new HashMap<>();
	}
	
	
	// init. 최초한번 실행.
	@Override
	public void init(ServletConfig config) throws ServletException {
		//controls.put("/resume.do", new x_ResumeForm());
		controls.put("/main.do", new T_MainControl());
		//System.out.println("init 실행.");
		//controls.put("/a.do", new Acontrol());
		//controls.put("/b.do", new Bcontrol());
	
		//게시글목록 이동 컨트롤
		controls.put("/boardList.do", new BoardListControl());
		controls.put("/board.do", new BoardControl());
		controls.put("/updateForm.do" , new updateForm()); //수정화면으로 이동
		controls.put("/modifyBoard.do", new ModifyBoard()); // 수정처리 후 목록
		controls.put("/removeForm.do", new RemoveForm()); // 삭제화면으로 이동 (삭제 처리x)
		controls.put("/removeBoard.do", new RemoveBoard()); // 삭제처리
		controls.put("/addForm.do", new AddForm()); // 등록화면
		controls.put("/addBoard.do", new AddBoard());
	
		//회원관련
		controls.put("/loginForm.do", new LoginForm());
		controls.put("/login.do", new LoginControl());
		controls.put("/Logout.do", new LogoutControl());
		
		// 회원등록.
		controls.put("addmember.do", new AddMemberControl());
		controls.put("addmemberForm.do", new AddMemberForm());
		
		// 회원리스트
		controls.put("memberlist.do", new MemberList());
		
		
	}
	
	
	// service. 요청떄마다 실행.
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	//	System.out.println("service 실행.");
		String uri = req.getRequestURI();
	//	System.out.println("uri: " + uri);
		String context = req.getContextPath();
	//	System.out.println("context:  " + context);
		String path = uri.substring(context.length());
		System.out.println("path:  " + path);
		
		Control control = controls.get(path);
		control.exec(req, resp); //요청 url에 따른 실행컨트롤을 호출.
	}
	
	
	// destroy
	
}
