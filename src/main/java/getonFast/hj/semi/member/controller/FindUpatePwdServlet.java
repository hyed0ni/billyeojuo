package getonFast.hj.semi.member.controller;

import java.io.IOException;
import java.security.Provider.Service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import getonFast.hj.semi.member.service.MemberService;

@WebServlet("/member/findUpdatePwd")
public class FindUpatePwdServlet extends HttpServlet{

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("css","style");
		
		String path = "/WEB-INF/views/member/findUpdatePwd.jsp";
		req.getRequestDispatcher(path).forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String findUpdatePwd1 = req.getParameter("findUpdatePwd1");
		
		String email = req.getParameter("email");
		
		System.out.println(findUpdatePwd1);
		System.out.println(email);
		
		try {
			
			MemberService service = new MemberService();
					
			int result = service.findPwdUpdate(findUpdatePwd1, email);	
			
			if(result > 0 ) {
				
				req.setAttribute("message", "비밀번호가 변경되었습니다.");
				
				resp.sendRedirect(req.getContextPath());
			}else {
				
				req.setAttribute("message", "오류가 발생했습니다.");
			}
			
			
		} catch (Exception e) {
			
			e.printStackTrace();

			req.setAttribute("errorMessage", "오류 발생");
			req.setAttribute("e", e);

			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
			
			
		}
		
		
		
		
	}
}
