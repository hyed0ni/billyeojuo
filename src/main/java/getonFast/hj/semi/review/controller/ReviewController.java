package getonFast.hj.semi.review.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import getonFast.hj.semi.review.model.service.ReviewService;
import getonFast.hj.semi.review.model.vo.Review;

@WebServlet("/my/review/*")
public class ReviewController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
//		String method = req.getMethod();
		String uri = req.getRequestURI();
		String contextPath = req.getContextPath();
		String command = uri.substring( (contextPath+"/my/review/").length() );
		
//		String path = null;
//		RequestDispatcher dispatcher = null;
//		String message = null;
		
		
		try {
			ReviewService service = new ReviewService();
			
			if (command.equals("list")) {
				int memberNo = 1;
				
				List<Review> reviewList = service.reviewList(memberNo);
				
				req.setAttribute("reviewList", reviewList);
				
				req.setAttribute("css", "review");
				
				String path = "/WEB-INF/views/review/review.jsp";
				req.getRequestDispatcher(path).forward(req, resp);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
