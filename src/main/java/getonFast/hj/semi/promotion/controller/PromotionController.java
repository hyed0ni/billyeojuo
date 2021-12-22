package getonFast.hj.semi.promotion.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import getonFast.hj.semi.promotion.model.service.PromotionService;
import getonFast.hj.semi.promotion.model.vo.Promotion;

@WebServlet("/promotion")
public class PromotionController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			HttpSession session = req.getSession(); 
			
			PromotionService service = new PromotionService();

			
			List<Promotion> promotionList = service.selectPromotionList();
			req.setAttribute("promotionList", promotionList);
			
			req.setAttribute("css",	"promotion");
			
			String path = "/WEB-INF/views/promotion/promotion.jsp";
			req.getRequestDispatcher(path).forward(req, resp);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}




