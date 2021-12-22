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
import getonFast.hj.semi.space.model.service.SpaceService;
import getonFast.hj.semi.space.model.vo.Space;

@WebServlet("/space/*")
public class SpaceController extends HttpServlet {

   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      // 데이터 전달 방식 저장용 변수
      String method = req.getMethod();
      
      // 요청 주소 뒷부분을 잘라내어 구분 방법 만들기
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
        	
            path = "/WEB-INF/views/space/space_detail.jsp";
            dispatcher = req.getRequestDispatcher(path);
            dispatcher.forward(req, resp);
            
         }
         
         else if (command.equals("search")) {
            req.setAttribute("css",   "space-search");
            
            path = "/WEB-INF/views/space/space_search.jsp";
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
