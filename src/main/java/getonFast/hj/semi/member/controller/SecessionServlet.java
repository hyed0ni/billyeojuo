package getonFast.hj.semi.member.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import getonFast.hj.semi.member.service.MemberService;
import getonFast.hj.semi.member.vo.Member;



@WebServlet("/member/secession")
public class SecessionServlet extends HttpServlet{
	
	

	
	// POST 방식 요청 시 회원 탈퇴 수행
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 파라미터, 회원번호 얻어오기
		
		Member member = new Member();
		
		HttpSession session = req.getSession();
		
		Member loginMember = (Member) session.getAttribute("loginMember");
		
		
		
		
		try {
			
			// 회원 탈퇴 서비스 수행 후 결과 반환 받기
			int result = new MemberService().secession(loginMember);
			
			String message = null; // 결과 메세지
			String path = null; // 리다이렉트 경로
			
			if(result > 0) { // 성공
				
				message = "회원탈퇴가 완료되었습니다.";
				path = req.getContextPath(); // 메인 페이지
				session.invalidate(); // 로그아웃 (세션 무효화)
				// -> 기존 session 변수에 저장된 세션객체가 무효화 되었기 때문에
				//    이후 새로운 세션 객체를 얻어와야 된다.
				
				
			}else { // 실패
				message = "비밀번호가 일치하지 않습니다.";
				path = "secession";
			}
			
			req.getSession().setAttribute("message", message);
			
			resp.sendRedirect(path);
			
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("errorMessage", "회원 탈퇴과정에서 문제가 발생했습니다.");
			req.setAttribute("e", e);
			
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
			
			
		}
		
		
		
	}
	
}
