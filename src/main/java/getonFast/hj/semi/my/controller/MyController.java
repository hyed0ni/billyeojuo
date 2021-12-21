package getonFast.hj.semi.my.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import getonFast.hj.semi.member.controller.loginServlet;
import getonFast.hj.semi.member.service.MemberService;
import getonFast.hj.semi.member.vo.Member;
import getonFast.hj.semi.my.model.service.MyService;



@WebServlet("/my")
public class MyController extends HttpServlet {
	
	loginServlet loginServelt = new loginServlet();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("css",	"my");
		
		String path = "/WEB-INF/views/my/my.jsp";
		req.getRequestDispatcher(path).forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println(req.getParameter("inputName"));
				
		String inputName = req.getParameter("inputName");
		
		
		Member member = new Member();
		
		member.setMemberName(inputName);
		
		HttpSession session = req.getSession();
		
		Member loginMember =  (Member)session.getAttribute("loginMember");
		
		member.setMemberNo(  loginMember.getMemberNo() );
		
		System.out.println(loginMember.getMemberNo());
		
		try {
			
			MyService service = new MyService();

			int result = service.updateNickName(member);
			

			if(result > 0) { 
				session.setAttribute("message", "회원 닉네임이 수정 되었습니다.");

				
				loginMember.setMemberName(inputName);
								

			}else { // 실패
				session.setAttribute("message", "회원 정보 수정 실패");
			}


			// 내 정보 페이지 재요청
			resp.sendRedirect("my");

		}catch(Exception e){
			e.printStackTrace();

			req.setAttribute("errorMessage", "회원 정보 수정 과정에서 오류 발생");
			req.setAttribute("e", e);

			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}
			
			
		
		
		
		
		
		
	}
	
	
}
