package getonFast.hj.semi.favorites.controller;

import static getonFast.hj.semi.common.JDBCTemplate.*;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import getonFast.hj.semi.common.Pagination;
import getonFast.hj.semi.favorites.model.service.FavoritesService;
import getonFast.hj.semi.main.model.vo.SpaceList;
import getonFast.hj.semi.member.vo.Member;

@WebServlet("/my/favorites")
public class FavoritesServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("css",	"favorites");
		

	      String path = null;
	      String message = null;
		
	      
	      int cp = req.getParameter("cp") == null ? 1: Integer.parseInt(req.getParameter("cp"));
	      
	      FavoritesService service = new FavoritesService();
	      
	      try {
	    	  HttpSession session = req.getSession();
	    	  Member loginMember = (Member)session.getAttribute("loginMember");
	    	  int memberNo = loginMember.getMemberNo();

	    	  int limit = 12;
	    	  Pagination pagination  = service.getPagination(cp, limit, memberNo);
	    	  
	    	  List<SpaceList> likeList = service.selectLikeList(memberNo, pagination);
	    	  
	    	  req.setAttribute("pagination", pagination);
	    	  req.setAttribute("likeList", likeList);
	    	  
	    	  path = "/WEB-INF/views/my/favorites.jsp";
	    	  req.getRequestDispatcher(path).forward(req, resp);
	      }catch (Exception e) {
	    	  e.printStackTrace();
	      }
	}
}
