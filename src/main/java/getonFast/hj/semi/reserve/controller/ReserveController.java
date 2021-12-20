package getonFast.hj.semi.reserve.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import getonFast.hj.semi.reserve.model.service.ReserveService;
import getonFast.hj.semi.reserve.model.vo.Reserve;

@WebServlet("/my/reserve")
public class ReserveController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			ReserveService service = new ReserveService();
			
			int memberNo = 1;
			
			List<Reserve> reserveList = service.selectReserveList(memberNo);
			
			req.setAttribute("reserveList", reserveList);
			
			req.setAttribute("css", "reserve");
			
			String path = "/WEB-INF/views/my/reserve.jsp";
			req.getRequestDispatcher(path).forward(req, resp);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
