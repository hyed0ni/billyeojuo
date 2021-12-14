package getonFast.hj.semi.reserve;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/my/reserve")
public class ReserveServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("css", "reserve");
		
		String path = "/WEB-INF/views/my/reserve.jsp";
		req.getRequestDispatcher(path).forward(req, resp);
	}
	
	

}
