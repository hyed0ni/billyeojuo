package getonFast.hj.semi.admin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;

import getonFast.hj.semi.admin.model.Service.AdSpaceService;
import getonFast.hj.semi.admin.model.vo.AdSpaceOption;
import getonFast.hj.semi.admin.model.vo.AdSpaceType;
import getonFast.hj.semi.common.MyRenamePolicy;



@WebServlet("/adminSpace/*")
public class AdminRegisterController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	      // 데이터 전달 방식 저장용 변수
	      String method = req.getMethod();
	      
	      // 요청 주소 뒷부분을 잘라내어 구분 방법 만들기
	      String uri = req.getRequestURI();
	      String contextPath = req.getContextPath();
	      
	      String command = uri.substring((contextPath + "/adminSpace/").length());

		String path1 = null;
		RequestDispatcher dispatcher =null;
		String message = null;
		
		AdSpaceService service = new AdSpaceService();
		
		try {
			
			if(command.equals("insert")) {
				
				//Get 방식 요청시 
				if(method.equals("GET")) {
					System.out.println("GGG");
					//공간 타입, 공간옵션  조회
					List<AdSpaceType> AdSpaceType = service.selectSpaceType();
					List<AdSpaceOption> AdSpaceOption = service.selectSpaceOption();
					
					req.setAttribute("AdSpaceType", AdSpaceType);
					req.setAttribute("AdSpaceOption", AdSpaceOption);
					
					path1 = "/WEB-INF/views/adminSpace/spaceInsert.jsp";
					
					System.out.println(path1);
					
					dispatcher = req.getRequestDispatcher(path1);
					dispatcher.forward(req, resp);
					
				}else {
					
					int maxSize = 1024 * 1024 *100;
					
					
					//2. 업로드 파일 저장 경로 ->특정 폴더의 컴퓨터 절대경로 작성 
					// ex) D:\ ~~ 
					 HttpSession session = req.getSession();
					 String root = session.getServletContext().getRealPath("/");
					 //webapp폴더의 절대경로 (컴퓨터 상)  - properties -> location
					 
					 String filePath = "/resources/images/space_img/"; //DB에 저장, 주소경로 사용 
					 
					 String realPath = root+filePath;
					 
					//3. 저장되는 파일의 이름을 변경 
					 // MyRenamePolicy
					 
					//객체생성
					 MultipartRequest mReq = new MultipartRequest(req, realPath, maxSize, "UTF-8", new MyRenamePolicy());
					
					 // 객체가 생성된 경우 지정된 파일경로에 파일이 바로 업로드 
					 // 저장이 안되는 경우 Servers -> 해당 서버 클릭 -> OverView 
					 
					
				}
				
			}
			else if(command.equals("list")) {
				
			}else if (command.equals("update")) {
				
			}else if(command.equals("delete")){
				
			}
			
			
		}catch (Exception e) {
		}
		
		
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
