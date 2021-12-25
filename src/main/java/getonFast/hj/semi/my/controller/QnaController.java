package getonFast.hj.semi.my.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import getonFast.hj.semi.member.vo.Member;
import getonFast.hj.semi.my.model.service.QnaService;
import getonFast.hj.semi.my.model.vo.Qna;

@WebServlet("/my/qna/*")
public class QnaController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setCharacterEncoding("UTF-8");
		
		String method = req.getMethod();
		String uri = req.getRequestURI();
		String contextPath = req.getContextPath();
		
		int contextLength = (contextPath+"/my/qna/").length();
		int checkLength = ((uri.length() - contextLength) <= 0) ? uri.length() : contextLength;  
		String command = uri.substring( checkLength );
		
		String path = null;
		RequestDispatcher dispatcher = null;
		String message = null;
		
		Member loginMember = (Member)req.getSession().getAttribute("loginMember");
		
		try {
			
			QnaService service = new QnaService();
			
			if (command.equals("space")) {
				int spaceNo = Integer.parseInt(req.getParameter("spaceNo"));
				
				List<Qna> qnaList = service.qnaSpaceList(spaceNo);
				
				new Gson().toJson(qnaList, resp.getWriter());
			
			} else if (loginMember != null) {
				int memberNo = loginMember.getMemberNo();
				
				String sort = "all";
				
				if (command.equals("list") || command.equals("")) {
					List<Qna> qnaList = service.qnaList(memberNo, sort);
					
					req.setAttribute("qnaList", qnaList);
					
					req.setAttribute("css", "qna");
					
					path = "/WEB-INF/views/qna/qnaList.jsp";
					req.getRequestDispatcher(path).forward(req, resp);
				} else if (command.equals("sort")) {
					sort = req.getParameter("sort");
					
					List<Qna> qnaList = service.qnaList(memberNo, sort);	
					
					new Gson().toJson(qnaList, resp.getWriter());
					
				} else if (command.equals("insert")) {
					
					int spaceNo = Integer.parseInt(req.getParameter("spaceNo"));
					String queContent = req.getParameter("queContent");
					
					Qna qna = new Qna();
					qna.setMemberNo(memberNo);
					qna.setSpaceNo(spaceNo);
					qna.setQueContent(queContent);
					
					int result = service.qnaInsert(qna);
					
					resp.getWriter().print(result);
					
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
