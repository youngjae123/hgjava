package co.yedam.common;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//인터페이스 -> 실행할 코드 x 메소드만 담고 있음.
public interface Control {
	public void exec(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException ,IOException;
	
}
