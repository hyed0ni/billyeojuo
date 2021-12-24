package getonFast.hj.semi.admin.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
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
import getonFast.hj.semi.admin.model.vo.AdRoomtype;
import getonFast.hj.semi.admin.model.vo.AdSpaceImage;
import getonFast.hj.semi.admin.model.vo.AdSpaceOption;
import getonFast.hj.semi.admin.model.vo.AdSpaceRoomOption;
import getonFast.hj.semi.common.MyRenamePolicy;

@WebServlet("/adminSpace/addRoomType")
public class AdminRoomTypeController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
	      String path = null;
	      RequestDispatcher dispatcher = null;
	      String message = null;
		
	      int rn = Integer.parseInt(req.getParameter("rn")) ;
	    		
	      
	      int cp = req.getParameter("cp") == null ? 1: Integer.parseInt(req.getParameter("cp"));

	      
			// 요청 주소 뒷부분을 잘라내어 구분 방법 만들기
			String uri = req.getRequestURI();
			String contextPath = req.getContextPath();
	
			String command = uri.substring((contextPath + "/adminSpace/").length());
			
	      // 데이터 전달 방식 저장용 변수
	      String method = req.getMethod();

	      AdSpaceService service = new AdSpaceService();

		try {
			
			if (method.equals("GET")) {
				List<AdSpaceOption> adSpaceOption = service.selectSpaceOption();
				req.setAttribute("adSpaceOption", adSpaceOption);
				
				path = "/WEB-INF/views/adminSpace/addRoomtype.jsp";

				System.out.println(path);

				dispatcher = req.getRequestDispatcher(path);
				dispatcher.forward(req, resp);
				
			}else {
				int maxSize = 1024 * 1024 * 100;
				
				
				HttpSession session = req.getSession();
				String root = session.getServletContext().getRealPath("/");
				String filePath = "/resources/images/space_room_img/"; // DB에 저장, 주소경로 사용
				String realPath = root + filePath;
				
				MultipartRequest mReq = new MultipartRequest(req, realPath, maxSize, "UTF-8", new MyRenamePolicy());
				
				// 룸타입
				String roomName = mReq.getParameter("roomName");
				String roomDesc = mReq.getParameter("roomDesc");
				String roomFit = mReq.getParameter("roomFit");
				int optionNo = Integer.parseInt(mReq.getParameter("roomPrice"));
				int roomPrice = Integer.parseInt(mReq.getParameter("roomPrice"));
			
				AdRoomtype roomType = new AdRoomtype();
				roomType.setSpaceNo(rn);
				roomType.setRoomName(roomName);
				roomType.setRoomDesc(roomDesc);
				roomType.setRoomFit(roomFit);
				roomType.setOptionNo(optionNo);
				roomType.setRoomPrice(roomPrice);
				
				
				// 룸 옵션
				String[] roomOption = mReq.getParameterValues("roomOption");

				List<AdSpaceRoomOption> optionList = new ArrayList<AdSpaceRoomOption>();

				for (String ro : roomOption) {
					AdSpaceRoomOption spaceRoomOption = new AdSpaceRoomOption();
					int RoomOptionNo = Integer.parseInt(ro);
					spaceRoomOption.setOptionNo(RoomOptionNo);

					optionList.add(spaceRoomOption);
					
				
				//사진
				Enumeration<String> files = mReq.getFileNames();
				// Enumeration<String> == iterator(ResultSet과 유사): 반복 접근자
				// form에서 전달된 input type="file" name속성 모두 반환
				// 파일이 업로드 되지 않아도 모든 요소를 얻어옴
				
				if (files.hasMoreElements()) {
					// 다음 요소(name)가 있으면 true

					String name = files.nextElement(); // 다음요소 내려오기

					// 업로드된 파일이 존재할 경우(변경된 name 있음)
					if (mReq.getOriginalFileName(name) != null) {
						AdSpaceImage temp = new AdSpaceImage();
						temp.setImgName(mReq.getFilesystemName(name));
						temp.setImgOriginal(mReq.getOriginalFileName(name));
						temp.setImgPath(filePath); // root는 이미 작성 되어있음

						// name img0~ img3에서 숫자를 제외한 img문자열을 제거 후 imgLevel set
						temp.setImgLevel(Integer.parseInt(name.replace("img", "")));

						// imgList에 추가
					
					}

				}
					
					
				// 서비스 호출
				int result = service.insertRoom(roomType, roomOption, rn);
				
				// 결과반환
				if (result > 0) {
					message = "게시글 작성이 등록 되었습니다. ";
					
					// 상세조회 redirect 주소
//					path = "view?no=" + result + "&cp=1";
					path = "/WEB-INF/views/adminSpace/list.jsp";
					
				} else {
					message = "게시글 등록 중 문제 발생";
					// 게시글 화면으로 redirect
					path = "/WEB-INF/views/adminSpace/addRoomtype.jsp";
				}
				
				session.setAttribute("message", message);
				resp.sendRedirect(path);
		
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doGet(req, resp);
	}
	
}
