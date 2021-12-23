package getonFast.hj.semi.res.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.SendResult;

import getonFast.hj.semi.member.vo.Member;
import getonFast.hj.semi.res.model.service.ResService;
import getonFast.hj.semi.res.model.vo.Res;
import getonFast.hj.semi.space.model.vo.Space;

@WebServlet("/res/*")
public class ResController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String method = req.getMethod();
		String uri = req.getRequestURI();
		
		String contextPath = req.getContextPath();
		String command = uri.substring((contextPath + "/res/").length());

		String path = null;
		RequestDispatcher dispatcher = null;
		String message = null;

		ResService service = new ResService();

		try {
			if (command.equals("insertRes")) {

				String resNm = req.getParameter("resNm");
				String[] phone = req.getParameterValues("phone");
				String resPno = String.join("", phone);
				String resEmail = req.getParameter("resEmail");
				String resPurpose = req.getParameter("resPurpose");
				String resReq = req.getParameter("resReq");
				String useDate = req.getParameter("useDate");
				String resPersonnel = req.getParameter("resPersonnel");
				
				int spaceRoomNo = Integer.parseInt(req.getParameter("spaceRoomNo"));
				Member loginMember = (Member)req.getSession().getAttribute("loginMember");

				Res res = new Res();
				
				res.setResNm(resNm);
				res.setResPno(resPno);
				res.setResEmail(resEmail);
				res.setResPurpose(resPurpose);
				res.setResReq(resReq);
				res.setUseDate(useDate);
				res.setResPersonnel(resPersonnel);
				
				res.setSpace(new Space());
				res.getSpace().setSpaceRoomNo(spaceRoomNo);
				res.setMemberNo(loginMember.getMemberNo());

				// 성공 : 예약번호(resSpace) / 실패 : 0
				int resSpace = service.insertRes(res);
				
				if (resSpace > 0) {
					req.getSession().setAttribute("message", "예약이 완료되었습니다.");
					resp.sendRedirect(req.getContextPath() + "/res/reservation_detail?rno=" + resSpace);
					
				} else
					resp.sendRedirect("reservation?spaceRoomNo="+spaceRoomNo);
			}
			
			else if (command.equals("reserve")) {
				
				Member loginMember = (Member)req.getSession().getAttribute("loginMember");
				int memberNo = loginMember.getMemberNo();
				
				List<Res> resList = service.selectResList(memberNo);
	        	req.setAttribute("resList", resList);
	        	
	        	req.setAttribute("css", "reserve");
	        	
	            path = "/WEB-INF/views/my/reserve.jsp";
	            dispatcher = req.getRequestDispatcher(path);
	            dispatcher.forward(req, resp);
			}
			
			else if (command.equals("reservation_detail")) {
				int resNo = Integer.parseInt(req.getParameter("rno"));
				
				Res res = service.selectRes(resNo);
				req.setAttribute("res", res);
				
				req.setAttribute("css",	"reservation_detail");
	        	
	            path = "/WEB-INF/views/my/reservation_detail.jsp";
	            dispatcher = req.getRequestDispatcher(path);
	            dispatcher.forward(req, resp);
			}

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
