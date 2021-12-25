package getonFast.hj.semi.my.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.google.gson.Gson;
import com.google.gson.JsonObject;

import com.oreilly.servlet.MultipartRequest;

import getonFast.hj.semi.common.MyRenamePolicy;
import getonFast.hj.semi.member.controller.loginServlet;
import getonFast.hj.semi.member.service.MemberService;
import getonFast.hj.semi.member.vo.Member;
import getonFast.hj.semi.my.model.service.MyService;

@WebServlet("/my")
public class MyController extends HttpServlet {

	loginServlet loginServelt = new loginServlet();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("css", "my");

		String path = "/WEB-INF/views/my/my.jsp";
		req.getRequestDispatcher(path).forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String inputName = req.getParameter("nickName");
		
		String inputPhone = req.getParameter("inputPhone");
		
		String inputPwd = req.getParameter("prepassword");
		
		String inputNewPwd = req.getParameter("newPwd1");
		
		System.out.println(inputName);

		Member member = new Member();

		member.setMemberName(inputName);
				
		member.setMemberPhone(inputPhone);
		
		member.setMemberPw(inputNewPwd);


		HttpSession session = req.getSession();

		Member loginMember = (Member) session.getAttribute("loginMember");

		member.setMemberNo(loginMember.getMemberNo());
		
		HashMap<String, Integer> map = new HashMap();
		
		try {

			MyService service = new MyService();
			
			

			if (inputName != null) {
				

				int result = service.updateNickName(member);
				

				if (result > 0) {
					session.setAttribute("message", "회원 닉네임이 수정 되었습니다.");

					loginMember.setMemberName(inputName);
					
					map.put("result", 1);

				} else { 
					session.setAttribute("message", "회원 정보 수정 실패");
					map.put("result", 0);
				}
				
				new Gson().toJson(map, resp.getWriter());
				
			}else if(inputPhone != null) {
				
				int result = service.updatePhone(member);

				if (result > 0) {
					session.setAttribute("message", "회원 전화번호가 수정 되었습니다.");

					loginMember.setMemberPhone(inputPhone);
					map.put("result", 1);

				} else { 
					session.setAttribute("message", "회원 정보 수정 실패");
					map.put("result", 0);
				}
				new Gson().toJson(map, resp.getWriter());
				
			}
			
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
