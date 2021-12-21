package getonFast.hj.semi.my.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
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
		
		String method = req.getMethod();
		String uri = req.getRequestURI();
		String contextPath = req.getContextPath();
		
		int contextLength = (contextPath+"/my/qna/").length();
		int checkLength = ((uri.length() - contextLength) <= 0) ? uri.length() : contextLength;  
		String command = uri.substring( checkLength );
		
		String path = null;
		RequestDispatcher dispatcher = null;
		String message = null;
		
		try {
			QnaService service = new QnaService();
			
			if (command.equals("list") || command.equals("")) {
				int memberNo = 14;
				
				List<Qna> qnaList = service.qnaList(memberNo);
				
				req.setAttribute("qnaList", qnaList);
				
				req.setAttribute("css", "qna");
				
				path = "/WEB-INF/views/qna/qnaList.jsp";
				req.getRequestDispatcher(path).forward(req, resp);
			} else if (command.equals("insert")) {
				
				int memberNo = 14;
				int spaceNo = Integer.parseInt(req.getParameter("spaceNo"));
				String queContent = req.getParameter("queContent");
				
				Qna qna = new Qna();
				qna.setMemberNo(memberNo);
				qna.setSpaceNo(spaceNo);
				qna.setQueContent(queContent);
				
				int result = service.qnaInsert(qna);
				System.out.println("result : " + result);
				
				resp.getWriter().print(result);
				
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
