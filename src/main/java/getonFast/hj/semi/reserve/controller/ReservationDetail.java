package getonFast.hj.semi.reserve.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/my/reservation_detail")
public class ReservationDetail extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("css",	"reservation_detail");
		
		String path = "/WEB-INF/views/my/reservation_detail.jsp";
		req.getRequestDispatcher(path).forward(req, resp);
		
	}
}

