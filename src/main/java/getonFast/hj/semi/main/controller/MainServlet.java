package getonFast.hj.semi.main.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import getonFast.hj.semi.main.model.service.MainService;
import getonFast.hj.semi.main.model.vo.SpaceType;

@WebServlet("/main")
public class MainServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 메인 페이지 요청 시 필요한 비지니스 로직 처리
		
		try {
			MainService service = new MainService();
			List<SpaceType> spaceTypeList = service.selectSpaceType();
			
			String uri = req.getRequestURI();
			String contextPath = req.getContextPath();
			
			req.setAttribute("spaceTypeList", spaceTypeList);
			
			// jsp로 요청 위임
			req.setAttribute("css", "main");
			
			String path = "/WEB-INF/views/common/main.jsp";
			RequestDispatcher dispatcher = req.getRequestDispatcher(path);
			dispatcher.forward(req, resp);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
}
