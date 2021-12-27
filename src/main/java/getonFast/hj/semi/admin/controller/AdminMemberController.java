package getonFast.hj.semi.admin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import getonFast.hj.semi.admin.model.Service.AdminMemberService;
import getonFast.hj.semi.admin.model.vo.AdminMember;


@WebServlet("/admin/member/*")
public class AdminMemberController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setCharacterEncoding("UTF-8");
		
		String method = req.getMethod();
		String uri = req.getRequestURI();
		String contextPath = req.getContextPath();
		
		int contextLength = (contextPath+"/admin/member/").length();
		int checkLength = ((uri.length() - contextLength) <= 0) ? uri.length() : contextLength;  
		String command = uri.substring( checkLength );
		
		String path = null;
		RequestDispatcher dispatcher = null;
		String message = null;
		
		try {
			AdminMemberService service = new AdminMemberService();
			System.out.println(command);
			System.out.println(method);
			
			if (command.equals("list")) {
				if (method.equals("GET")) {
					
					req.setAttribute("css", "admin_member");
					
					path = "/WEB-INF/views/admin/member.jsp";
					dispatcher = req.getRequestDispatcher(path);
					dispatcher.forward(req, resp);	
					
				} else {
					String search = req.getParameter("search");
					System.out.println(search);
					
					List<AdminMember> memberList = service.selectMemberList(search);
					System.out.println(memberList);
					
					new Gson().toJson(memberList, resp.getWriter());
				
				}
				
			}
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
