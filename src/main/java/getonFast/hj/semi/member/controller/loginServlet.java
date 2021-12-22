package getonFast.hj.semi.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import getonFast.hj.semi.member.service.MemberService;
import getonFast.hj.semi.member.vo.Member;






@WebServlet("/member/login")
public class loginServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("css","style");
		
		String path = "/WEB-INF/views/member/login.jsp";
		req.getRequestDispatcher(path).forward(req, resp);
		
		
		

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		
		String memberEmail = req.getParameter("email");
		String memberPw = req.getParameter("pwd1");
		
		
		
		
		
		
	
		
		try {
			
			
			
			MemberService service = new MemberService();
			
			
			Member loginMember = service.login(memberEmail, memberPw);
			
			
			
			HttpSession session = req.getSession();
			
			
			
			if(loginMember != null) {
				
				
				if(loginMember.getStatusCode() == 11) {
					
					
					
					session.setAttribute("loginMember", loginMember);
					
					
					
					session.setMaxInactiveInterval(60*60*24);
					
					
					Cookie cookie = new Cookie("saveId", memberEmail);
					
					if(req.getParameter("save") != null) {
						
						
						cookie.setMaxAge(60*60*24*30);
						
						
					}else { 
						
						
						cookie.setMaxAge(0); 
						
						
					}
					
					
					
					cookie.setPath(req.getContextPath());
					
					resp.addCookie(cookie);
					
					
					
				}else {
					
					session.setAttribute("message", "정지된 회원입니다.");
					
				}
				
			}else { // 로그인 실패한 경우
				
				
				session.setAttribute("message", "아이디 또는 비밀번호를 확인해주세요.");
				
				
			}
			
			
			
			// 메인 페이지로 redirect (메인 페이지 요청 주소 작성)
			resp.sendRedirect(req.getContextPath());
								// Servlet/JSP 요청 주소(주소 경로)
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			
			String errorMessage = "로그인중 문제가 발생했습니다";
			
			req.setAttribute("errorMessage", errorMessage); 
			req.setAttribute("e", e); 
			
			
			String path = "/WEB-INF/views/common/error.jsp";
			
			RequestDispatcher dispatcher = req.getRequestDispatcher(path);
			
			dispatcher.forward(req, resp);
			
		}
		
		
	}
	
	
	
}


