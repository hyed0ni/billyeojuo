package getonFast.hj.semi.admin.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

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
				
				String[] roomName = mReq.getParameterValues("roomName");
				String[] roomDesc = mReq.getParameterValues("roomDesc");
				String[] roomFit = mReq.getParameterValues("roomFit");
				String[] rp = mReq.getParameterValues( "roomPrice" );
				
				//rp int배열로 변경
				int[] roomPrice = null;
				
				if(rp != null) {
					roomPrice = new int[rp.length];
					
					for(int i=0 ; i <rp.length ; i ++) {
						roomPrice[i] = Integer.parseInt( rp[i] );
					}
				}
				
				
				//룸타입 배열 만들기 
				List<AdRoomtype> roomType = new ArrayList<AdRoomtype>();
				ListIterator<AdRoomtype> iter = roomType.listIterator();
				
				while(iter.hasNext()){
					
					int	i = 0;
					
					AdRoomtype rt = new AdRoomtype();
					rt.setSpaceNo(rn);
					rt.setRoomName(roomName[i]);
					rt.setRoomDesc(roomDesc[i]);
					rt.setRoomFit(roomFit[i]);
					/*roomType.setOptionNo(optionNo);*/
					rt.setRoomPrice(roomPrice[i]);
					
					roomType.add(rt);
					
					i++;
				}

				
				
				// 룸 옵션
				String[] roomOption = mReq.getParameterValues("roomOption");

				List<AdSpaceRoomOption> optionList = new ArrayList<AdSpaceRoomOption>();

				for (String ro : roomOption) {
					AdSpaceRoomOption spaceRoomOption = new AdSpaceRoomOption();
					int RoomOptionNo = Integer.parseInt(ro);
					spaceRoomOption.setOptionNo(RoomOptionNo);

					optionList.add(spaceRoomOption);
				}
				
				
				//사진
				
				Enumeration<String> files = mReq.getFileNames();
				
				List<AdRoomtype> imgList = new ArrayList<AdRoomtype>();

				while (files.hasMoreElements()) {
					// 다음 요소(name)가 있으면 true

					String name = files.nextElement(); // 다음요소 내려오기

					// 업로드된 파일이 존재할 경우(변경된 name 있음)
					if (mReq.getOriginalFileName(name) != null) {
						AdRoomtype temp = new AdRoomtype();
						temp.setRoomImg(mReq.getFilesystemName(name));
						
						// imgList에 추가
						imgList.add(temp);
					}
				}

					
				// 서비스 호출
				int result = service.insertRoom(roomType, roomOption, rn, imgList);
				
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


		}catch(Exception e) {
			e.printStackTrace();
		}
	
	}
		
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doGet(req, resp);
	}
	
}
