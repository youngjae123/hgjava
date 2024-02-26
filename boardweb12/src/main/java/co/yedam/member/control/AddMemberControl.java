package co.yedam.member.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import co.yedam.common.Control;

public class AddMemberControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1)요청정보 2)저장경로 3) 최대크기 4)인코딩 5)리네임정책
		String savePath = req.getServletContext().getRealPath("images");
		int maxSize = 1024 * 1024 * 5;// 5메가바이트
		String enc = "utf-8";
		MultipartRequest multi = new MultipartRequest(req, savePath, maxSize , enc, new DefaultFileRenamePolicy());
		
		String id = multi.getParameter("id");
		String pw = multi.getParameter("pw");
		String name = multi.getParameter("name");
		String img = multi.getFilesystemName("image"); // 변경된 파이르이 이름
		
		// mapper : insertMember
		// service : addMember
		// 게시글목록 이동/ 에러페이지로 이동.
		
	}

}
