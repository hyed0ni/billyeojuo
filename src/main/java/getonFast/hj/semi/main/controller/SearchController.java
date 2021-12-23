package getonFast.hj.semi.main.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import getonFast.hj.semi.common.Pagination;
import getonFast.hj.semi.main.model.service.MainService;
import getonFast.hj.semi.main.model.vo.SpaceList;

@WebServlet("/space/search")
public class SearchController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	      String path = null;
	      RequestDispatcher dispatcher = null;
	      String message = null;
		
	      String sv = req.getParameter("sv");
	      
	      int cp = req.getParameter("cp") == null ? 1: Integer.parseInt(req.getParameter("cp"));
		
		try {
			
			MainService service = new MainService();

			int limit = 12; 
		

			Pagination pagination  = service.getPagination(cp, limit, sv);
			
			List<SpaceList> searchList = service.selectSeacrhList(sv, pagination);
			
			req.setAttribute("searchList", searchList);
			req.setAttribute("pagination", pagination);
			
			
			req.setAttribute("css", "space-search");
			
            path = "/WEB-INF/views/space/space_search.jsp";
            dispatcher = req.getRequestDispatcher(path);
            dispatcher.forward(req, resp);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
