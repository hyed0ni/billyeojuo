package getonFast.hj.semi.admin.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import getonFast.hj.semi.admin.model.Service.AdQService;
import getonFast.hj.semi.admin.model.Service.AdReService;

@WebServlet("/admin/question/*")
public class AdQController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		String uri = req.getRequestURI();
		
		String contextPath = req.getContextPath();
		String command = uri.substring((contextPath + "/admin/question/").length());
		
		String path = null;
		RequestDispatcher dispatcher = null;
		String message = null;
		
		AdReService service = new AdReService();
		
		try {
			if(command.equals("list")) {
				
				req.getRequestDispatcher("/WEB-INF/views/adminAnswer/question_answer.jsp").forward(req, resp);
				
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
