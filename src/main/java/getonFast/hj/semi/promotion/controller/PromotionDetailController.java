package getonFast.hj.semi.promotion.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import getonFast.hj.semi.main.model.vo.SpaceList;
import getonFast.hj.semi.promotion.model.service.PromotionService;
import getonFast.hj.semi.promotion.model.vo.Promotion;
import getonFast.hj.semi.space.model.vo.Space;

@WebServlet("/promotion_detail")
public class PromotionDetailController extends HttpServlet{
	@Override
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			//프로모션 글번호 얻어오기 
			int exNo = Integer.parseInt(req.getParameter("no"));
			
			
			PromotionService service = new PromotionService();
			List<SpaceList> proDetailList = service.selectProDetailList(exNo);
			
			Promotion title = service.ProDetailTitle(exNo);
			
			req.setAttribute("proDetailList", proDetailList);
			req.setAttribute("title", title);
			
			req.setAttribute("css",	"promotion_detail");
			
			String path = "/WEB-INF/views/promotion/promotion_detail.jsp";
			req.getRequestDispatcher(path).forward(req, resp);
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
