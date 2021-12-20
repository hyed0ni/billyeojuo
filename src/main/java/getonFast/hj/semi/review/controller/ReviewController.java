package getonFast.hj.semi.review.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import getonFast.hj.semi.review.model.service.ReviewService;
import getonFast.hj.semi.review.model.vo.Review;

@WebServlet("/my/review")
public class ReviewController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ReviewService service = new ReviewService();
		
		try {
			int memberNo = 1;
			
			List<Review> reviewList = service.reviewList(memberNo);
			
			req.setAttribute("reviewList", reviewList);
			
			req.setAttribute("css", "review");
			
			String path = "/WEB-INF/views/review/review.jsp";
			req.getRequestDispatcher(path).forward(req, resp);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
