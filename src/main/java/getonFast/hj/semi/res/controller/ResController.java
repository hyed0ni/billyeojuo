package getonFast.hj.semi.res.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
				
				int result = service.insertRes(res);

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
