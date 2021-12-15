package getonFast.hj.semi.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member/signup")
public class signupServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("css","style");
		
		String path = "/WEB-INF/views/member/signup.jsp";
		req.getRequestDispatcher(path).forward(req, resp);
	}
}