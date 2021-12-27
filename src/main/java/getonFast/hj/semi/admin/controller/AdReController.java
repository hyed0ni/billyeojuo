package getonFast.hj.semi.admin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import getonFast.hj.semi.admin.model.Service.AdReService;
import getonFast.hj.semi.admin.model.vo.AdRe;
import getonFast.hj.semi.review.model.vo.Review;

@WebServlet("/admin/review/*")
public class AdReController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		String uri = req.getRequestURI();
		
		String contextPath = req.getContextPath();
		String command = uri.substring((contextPath + "/admin/review/").length());
		
		String path = null;
		RequestDispatcher dispatcher = null;
		String message = null;
		
		AdReService service = new AdReService();
		
		try {
			if(command.equals("list")) {
				//List<Review> reviewList = service.reviewList();
				//req.setAttribute("reviewList", reviewList);
				
				req.getRequestDispatcher("/WEB-INF/views/adminAnswer/review_reply.jsp").forward(req, resp);
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
