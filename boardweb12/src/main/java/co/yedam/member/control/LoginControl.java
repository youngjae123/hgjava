package co.yedam.member.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.yedam.common.Control;
import co.yedam.member.Member;
import co.yedam.member.service.MemberService;
import co.yedam.member.service.MemberServiceImp1;

public class LoginControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		
		Member member = new Member();
		member.setId(id);
		member.setPw(pw);
		
		MemberService svc = new MemberServiceImp1();
		member = svc.loginCheck(member);
		
		if(member != null) { // 아이디, 비번 확인 후 정상이면 = resp.sendRedirect("boardList.do"); 로 이동
			
			HttpSession session = req.getSession(); // 사용자별로 다른 세션 값.
			session.setAttribute("logid", member.getId()); // attribute를 활용.
			session.setAttribute("logName", member.getName());
			resp.sendRedirect("boardList.do");
		}else {
			req.setAttribute("message", "아이디와 비밀번호를 확인하세요.");
			String path = "WEB-INF/view/member/loginForm.jsp";
			req.getRequestDispatcher(path).forward(req, resp);
			// 보내버림
		}
		
	}

}
