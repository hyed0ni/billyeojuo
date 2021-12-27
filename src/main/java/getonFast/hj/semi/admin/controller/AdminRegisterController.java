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
import getonFast.hj.semi.admin.model.vo.AdSpace;
import getonFast.hj.semi.admin.model.vo.AdSpaceImage;
import getonFast.hj.semi.admin.model.vo.AdSpaceOption;
import getonFast.hj.semi.admin.model.vo.AdSpaceRoomOption;
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

		String path = null;
		RequestDispatcher dispatcher = null;
		String message = null;

		AdSpaceService service = new AdSpaceService();

		try {

			if (command.equals("insert")) {

				// Get 방식 요청시
				if (method.equals("GET")) {
					// 공간 타입, 공간옵션 조회
					List<AdSpaceType> adSpaceType = service.selectSpaceType();
					
					req.setAttribute("adSpaceType", adSpaceType);

					path = "/WEB-INF/views/adminSpace/spaceInsert.jsp";

					dispatcher = req.getRequestDispatcher(path);
					dispatcher.forward(req, resp);

				} else {

					int maxSize = 1024 * 1024 * 100;

					// 2. 업로드 파일 저장 경로 ->특정 폴더의 컴퓨터 절대경로 작성
					// ex) D:\ ~~
					HttpSession session = req.getSession();
					String root = session.getServletContext().getRealPath("/");
					// webapp폴더의 절대경로 (컴퓨터 상) - properties -> location

					String filePath = "/resources/images/space_img/"; // DB에 저장, 주소경로 사용

					String realPath = root + filePath;

					// 3. 저장되는 파일의 이름을 변경
					// MyRenamePolicy

					// 객체생성
					MultipartRequest mReq = new MultipartRequest(req, realPath, maxSize, "UTF-8", new MyRenamePolicy());

					// 객체가 생성된 경우 지정된 파일경로에 파일이 바로 업로드
					// 저장이 안되는 경우 Servers -> 해당 서버 클릭 -> OverView

					// MultipartRequest 다루기
					// 1. 텍스트 형식의 파라미터

					// 공간등록
					String spaceName = mReq.getParameter("spaceName");
					String spaceSubName = mReq.getParameter("spaceSubName");

					String spaceIntro = mReq.getParameter("spaceIntro");
					String spaceGuide = mReq.getParameter("spaceGuide");
					String precautions = mReq.getParameter("precautions");
					String refundPolicy = mReq.getParameter("refundPolicy");

					String spaceAddr = mReq.getParameter("spaceAddr");
					String spacePhone = mReq.getParameter("spacePhone");
					String spaceTime = mReq.getParameter("spaceTime");
					String spaceClosedDt = mReq.getParameter("spaceClosedDt");
					int spaceTypeNo = Integer.parseInt(mReq.getParameter("spaceTypeNo"));

					
					AdSpace space = new AdSpace();
					space.setSpaceName(spaceName);
					space.setSpaceSubName(spaceSubName);

					space.setSpaceIntro(spaceIntro);
					space.setSpaceGuide(spaceGuide);
					space.setPrecautions(precautions);
					space.setRefundPolicy(refundPolicy);

					space.setSpaceAddr(spaceAddr);
					space.setSpacePhone(spacePhone);
					space.setSpaceTime(spaceTime);
					space.setSpaceClosedDt(spaceClosedDt);
					space.setSpaceTypeNo(spaceTypeNo);

					
					Enumeration<String> files = mReq.getFileNames();
					// Enumeration<String> == iterator(ResultSet과 유사): 반복 접근자
					// form에서 전달된 input type="file" name속성 모두 반환
					// 파일이 업로드 되지 않아도 모든 요소를 얻어옴

					// 업로드된 이미지 정보를 담을 List생성
					List<AdSpaceImage> imgList = new ArrayList<AdSpaceImage>();

					while (files.hasMoreElements()) {
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
							imgList.add(temp);
						}

						
						
					}
					// board, imgList DB에 저장 (Service 호출)
					int result = service.insertSpace(space, imgList);
					
					// 결과반환
					if (result > 0) {
						// 상세조회 redirect 주소
//						path = "view?no=" + result + "&cp=1";
						path = "addRoomType?rn="+result;

					} else {
						message = "게시글 등록 중 문제 발생";
						// 게시글 화면으로 redirect
						path = "insert";
					}
					session.setAttribute("message", message);
					resp.sendRedirect(path);
				}
				
			} else if (command.equals("list")) {
				
				resp.sendRedirect("insert");
				
				// 공간 타입, 공간옵션 조회
//				List<AdSpace> adSpaceList = service.selectAdSpaceList();
				
//				req.setAttribute("adSpaceList", adSpaceList);
//				System.out.println(adSpaceList);
//
//				path = "/WEB-INF/views/adminSpace/list.jsp";
//
//				dispatcher = req.getRequestDispatcher(path);
//				dispatcher.forward(req, resp);
				
			} else if (command.equals("addRoomType")) {
				
			} else if (command.equals("view")) {

			} else if (command.equals("update")) {

			} else if (command.equals("delete")) {

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
