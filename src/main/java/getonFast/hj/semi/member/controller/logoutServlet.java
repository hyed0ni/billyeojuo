package getonFast.hj.semi.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/member/logout")
public class logoutServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 로그인 == session에 회원 정보를 추가
		// 로그아웃 == session에 회원 정보를 제거
		
		// session 객체 얻어오기
		HttpSession session = req.getSession();
		
		// session.removeAttribute("loginMember");
		// -> 현재 session에서 loginMember 정보만 제거
		// --> 부분적 제거보다 만료(무효화) 시키는 것이 더 바람직하다.
		session.invalidate(); // 세션 만료(무효화)
		
		
		// redirect를 이용해 메인 페이지 재요청
		resp.sendRedirect(req.getContextPath());
		
		
		
	}
	
}
