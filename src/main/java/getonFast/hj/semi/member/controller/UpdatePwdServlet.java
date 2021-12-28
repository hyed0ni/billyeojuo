package getonFast.hj.semi.member.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import getonFast.hj.semi.member.vo.Member;
import getonFast.hj.semi.my.model.service.MyService;

@WebServlet("/member/updatePwd")

public class UpdatePwdServlet extends HttpServlet{

	loginServlet loginServelt = new loginServlet();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("css", "my");

		String path = "/WEB-INF/views/my/my.jsp";
		req.getRequestDispatcher(path).forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

				
		
		String inputPwd = req.getParameter("prepassword");
		
		String inputNewPwd = req.getParameter("newPwd1");
		
	

		Member member = new Member();

		
		member.setMemberPw(inputNewPwd);


		HttpSession session = req.getSession();

		Member loginMember = (Member) session.getAttribute("loginMember");

		member.setMemberNo(loginMember.getMemberNo());
		
		HashMap<String, Integer> map = new HashMap();
		
		
		try {
			MyService service = new MyService();
			
			if(inputNewPwd != null) {
				
				
				
				 int result = service.pwdUpdate(member, inputPwd);
				
				 

					if (result > 0) { // 성공

						map.put("result", 1);

					} else { // 실패
						map.put("result", 0);
					}
					new Gson().toJson(map, resp.getWriter());
					
					/*
					 * resp.sendRedirect(path);
					 */
				
				
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();

			req.setAttribute("errorMessage", "회원 정보 수정 과정에서 오류 발생");
			req.setAttribute("e", e);

			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}
		
	
	}
	
	
}
