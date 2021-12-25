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
import getonFast.hj.semi.main.model.vo.SpaceList;
import getonFast.hj.semi.main.model.vo.SpaceType;
import getonFast.hj.semi.promotion.model.service.PromotionService;
import getonFast.hj.semi.promotion.model.vo.Promotion;
import getonFast.hj.semi.space.model.vo.Space;

@WebServlet("/main")
public class MainServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 메인 페이지 요청 시 필요한 비지니스 로직 처리
		
		try {
			MainService service = new MainService();
			
			// 공간 타입
			List<SpaceType> spaceTypeList = service.selectSpaceType();
			req.setAttribute("spaceTypeList", spaceTypeList);
			
			
			PromotionService promotionService = new PromotionService();
			
			List<Promotion> promotionList = promotionService.selectPromotionList();
			
			req.setAttribute("promotionList", promotionList.subList(0, 4));
			
			
			//추천공간
			
			List<SpaceList> recommendList = service.selectRecommendList();
			
			req.setAttribute("recommendList", recommendList.subList(0, 6));
			
			
			
			// jsp로 요청 위임
			req.setAttribute("css", "main");
			
			String path = "/WEB-INF/views/main/main.jsp";
			RequestDispatcher dispatcher = req.getRequestDispatcher(path);
			dispatcher.forward(req, resp);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doGet(req, resp);
	}
	
	
	
	
}
