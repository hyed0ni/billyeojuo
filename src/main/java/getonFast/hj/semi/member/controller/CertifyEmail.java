package getonFast.hj.semi.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import getonFast.hj.semi.member.service.MemberService;

@WebServlet("/member/certify")
public class CertifyEmail extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setAttribute("css", "style");

		String path = "/WEB-INF/views/member/certify.jsp";
		req.getRequestDispatcher(path).forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String certifyPwd = req.getParameter("certifyPwd");

		String email = req.getParameter("email");

		

		try {

			MemberService service = new MemberService();

			int result = service.certifyEmail(certifyPwd, email);

			if (result > 0) {

				req.setAttribute("message", "이메일이 인증되었습니다.");

				resp.sendRedirect(req.getContextPath());
			} else {

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
