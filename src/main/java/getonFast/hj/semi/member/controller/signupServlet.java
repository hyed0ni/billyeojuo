package getonFast.hj.semi.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import getonFast.hj.semi.member.service.MemberService;
import getonFast.hj.semi.member.vo.Member;

@WebServlet("/member/signup")
public class signupServlet extends HttpServlet {
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("css", "style");

		String path = "/WEB-INF/views/member/signup.jsp";
		req.getRequestDispatcher(path).forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int memberSMSChk = req.getParameter("sms_check") == null ? 0 : 1;
		int memberEmailChk = req.getParameter("email_check") == null ? 0 : 1;
		
	
		
		String memberName = req.getParameter("name");
		String memberEmail = req.getParameter("email");
		String memberPw = req.getParameter("pwd1");
		
		
	
		

		Member member = new Member(memberName, memberEmail, memberPw, memberSMSChk, memberEmailChk );
		
		try {
			MemberService service = new MemberService();

			int result = service.signUp(member);
			String message = null;

			if (result > 0) { 
				message = "회원가입 성공";
			}

			HttpSession session = req.getSession();

			session.setAttribute("message", message);
			System.out.println("****************************");
			System.out.println(member);
			System.out.println("****************************");
			
			resp.sendRedirect(req.getContextPath());

		} catch (Exception e) {
			e.printStackTrace();

			

			String errorMessage = "회원 가입중 문제가 발생했습니다";

			req.setAttribute("errorMessage", errorMessage); 
			req.setAttribute("e", e); 

			
			String path = "/WEB-INF/views/common/error.jsp";

			RequestDispatcher dispatcher = req.getRequestDispatcher(path);

			dispatcher.forward(req, resp);

		}

	}
}
