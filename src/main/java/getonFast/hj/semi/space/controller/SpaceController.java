package getonFast.hj.semi.space.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
      // -> 요청 주소에서 /semi/board/의 길이만큼 잘라낸 후 나머지 문자열을 command 변수에 저장
      
      String path = null;
      RequestDispatcher dispatcher = null;
      String message = null;
   
      SpaceService service = new SpaceService();
      
      try {
         
         if (command.equals("detail")) {
        	 
        	int spaceNo = Integer.parseInt(req.getParameter("no"));
        	
        	Space space = service.selectSpace(spaceNo);
            
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
            
            path = "/WEB-INF/views/space/space_reservation.jsp";
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
