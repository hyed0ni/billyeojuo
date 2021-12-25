package getonFast.hj.semi.review.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import getonFast.hj.semi.member.vo.Member;
import getonFast.hj.semi.my.model.vo.Qna;
import getonFast.hj.semi.review.model.service.ReviewService;
import getonFast.hj.semi.review.model.vo.Review;

@WebServlet("/my/review/*")
public class ReviewController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setCharacterEncoding("UTF-8");
		
		String method = req.getMethod();
		String uri = req.getRequestURI();
		String contextPath = req.getContextPath();
		
		int contextLength = (contextPath+"/my/review/").length();
		int checkLength = ((uri.length() - contextLength) <= 0) ? uri.length() : contextLength;  
		String command = uri.substring( checkLength );
		
		String path = null;
		RequestDispatcher dispatcher = null;
		String message = null;
		
		Member loginMember = (Member)req.getSession().getAttribute("loginMember");
		
		try {
			if (loginMember != null) {
				ReviewService service = new ReviewService();
				
				int memberNo = loginMember.getMemberNo();
				
				if (command.equals("list") || command.equals("")) {
					
					List<Review> reviewList = service.reviewList(memberNo);
					req.setAttribute("reviewList", reviewList);
					
					req.setAttribute("css", "review");
					
					path = "/WEB-INF/views/review/review.jsp";
					req.getRequestDispatcher(path).forward(req, resp);
					
				} else if (command.equals("insert")) {
					int spaceNo = Integer.parseInt(req.getParameter("spaceNo"));
					int resNo = Integer.parseInt(req.getParameter("resNo"));
					String reviewContent = req.getParameter("reviewContent");
					
					int result = service.insertReview(spaceNo, reviewContent, memberNo, resNo);
					
					if (result > 0) {
						List<Review> reviewSpaceList = service.reviewSpaceList(spaceNo);
						new Gson().toJson(reviewSpaceList, resp.getWriter());
					}

				}
				
			} else {
				resp.sendRedirect(contextPath + "/member/login");
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
