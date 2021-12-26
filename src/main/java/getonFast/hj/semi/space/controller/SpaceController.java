package getonFast.hj.semi.space.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import getonFast.hj.semi.member.vo.Member;
import getonFast.hj.semi.my.model.service.QnaService;
import getonFast.hj.semi.my.model.vo.Qna;
import getonFast.hj.semi.res.model.service.ResService;
import getonFast.hj.semi.review.model.service.ReviewService;
import getonFast.hj.semi.review.model.vo.Review;

import getonFast.hj.semi.space.model.service.SpaceService;
import getonFast.hj.semi.space.model.vo.Space;

@WebServlet("/space/*")
public class SpaceController extends HttpServlet {

   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	   
	  String method = req.getMethod();
      String uri = req.getRequestURI();
      
      String contextPath = req.getContextPath();
      String command = uri.substring((contextPath + "/space/").length());
      
      String path = null;
      RequestDispatcher dispatcher = null;
      String message = null;
   
      SpaceService service = new SpaceService();
      
      try {
         if (command.equals("detail")) {
        	int spaceNo = Integer.parseInt(req.getParameter("no"));
        	
        	Space space = service.selectSpace(spaceNo);
        	req.setAttribute("space", space);
        	
        	Space spaceImg = service.selectSpaceImg(spaceNo);
        	req.setAttribute("spaceImg", spaceImg);
        	
        	List<Space> spaceRoomList = service.selectSpaceRoom(spaceNo);
        	req.setAttribute("spaceRoomList", spaceRoomList);
        	
        	Space spaceType = service.selectSpaceType(spaceNo);
        	req.setAttribute("spaceType", spaceType);
        	
        	Map<Integer, List<Space>> spaceOptionMap = service.selectSpaceOption(spaceRoomList);
        	req.setAttribute("spaceOptionMap", spaceOptionMap);
        	
        	QnaService qnaService = new QnaService();
        	List<Qna> qnaSpaceList = qnaService.qnaSpaceList(spaceNo);
        	req.setAttribute("qnaSpaceList", qnaSpaceList);
        	
        	ReviewService reviewService = new ReviewService();
        	List<Review> reviewSpaceList = reviewService.reviewSpaceList(spaceNo);
        	req.setAttribute("reviewSpaceList", reviewSpaceList);
        	
        	Member loginMember = (Member)req.getSession().getAttribute("loginMember");
        	
        	if (loginMember != null) {
        		ResService resService = new ResService();
        		
        		Map<String, String> resMap = resService.selectResReview(spaceNo, loginMember.getMemberNo());
        		
        		// 예약 내용 있고 글이 없는 경우
        		if (!resMap.isEmpty() && resMap.get("revNo").equals("0")) {
        			req.setAttribute("reviewUse", resMap.get("resNo"));
        		}
        		
        	}
        	
        	req.setAttribute("css", "space-style");
        	
            path = "/WEB-INF/views/space/space_detail.jsp";
            dispatcher = req.getRequestDispatcher(path);
            dispatcher.forward(req, resp);
            
         }
         
         else if (command.equals("reservation")) {
        	
        	int spaceRoomNo = Integer.parseInt(req.getParameter("spaceRoomNo"));
        	
        	Space spaceRoom = service.selectSpaceRoomRes(spaceRoomNo);
        	req.setAttribute("spaceRoom", spaceRoom);
        	
        	Space space = service.selectSpaceRes(spaceRoomNo);
        	req.setAttribute("space", space);
        	
        	Space spaceType = service.selectSpaceTypeRes(spaceRoomNo);
        	req.setAttribute("spaceType", spaceType);
        	
        	Space spaceImg = service.selectSpaceImgRes(spaceRoomNo);
        	req.setAttribute("spaceImg", spaceImg);
            
            path = "/WEB-INF/views/space/space_reservation.jsp";
            dispatcher = req.getRequestDispatcher(path);
            dispatcher.forward(req, resp);
            
         }
         
         // 찜한공간 등록, 삭제
         else if (command.equals("heart")) {
        	 int memberNo = ((Member)req.getSession().getAttribute("loginMember")).getMemberNo();
        	 int spaceNo = Integer.parseInt(req.getParameter("spaceNo"));
        	 int heart = service.heartSpace(spaceNo, memberNo);
        	 
        	 resp.getWriter().print(heart);
         }
         
         // 찜한공간 조회
         else if (command.equals("selectHeart")) {
        	 int memberNo = ((Member)req.getSession().getAttribute("loginMember")).getMemberNo();
        	 int spaceNo = Integer.parseInt(req.getParameter("spaceNo"));
        	 int spaceHeart = service.selectHeart(spaceNo, memberNo);
        	 
        	 resp.getWriter().print(spaceHeart);
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
