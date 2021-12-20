package getonFast.hj.semi.my.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import getonFast.hj.semi.my.model.service.QnaService;
import getonFast.hj.semi.my.model.vo.Qna;
import getonFast.hj.semi.review.model.service.ReviewService;
import getonFast.hj.semi.review.model.vo.Review;

@WebServlet("/my/qna/*")
public class QnaController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
//		String method = req.getMethod();
		String uri = req.getRequestURI();
		String contextPath = req.getContextPath();
		String command = uri.substring( (contextPath+"/my/qna/").length() );
		
//		String path = null;
//		RequestDispatcher dispatcher = null;
//		String message = null;
		
		try {
			QnaService service = new QnaService();
			
			if (command.equals("list") || command.equals("")) {
				int memberNo = 1;
				
				List<Qna> qnaList = service.qnaList(memberNo);
				
				req.setAttribute("qnaList", qnaList);
				
				
				
				req.setAttribute("css", "qna");
				
				String path = "/WEB-INF/views/qna/qna.jsp";
				req.getRequestDispatcher(path).forward(req, resp);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
	}
}
