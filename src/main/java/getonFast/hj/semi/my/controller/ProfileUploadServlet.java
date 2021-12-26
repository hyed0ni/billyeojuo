package getonFast.hj.semi.my.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.oreilly.servlet.MultipartRequest;

import getonFast.hj.semi.common.MyRenamePolicy;
import getonFast.hj.semi.member.vo.Member;
import getonFast.hj.semi.my.model.service.MyService;

@WebServlet("/profile")
public class ProfileUploadServlet extends HttpServlet{

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Member member = new Member();
		
		HttpSession session = req.getSession();

		Member loginMember = (Member) session.getAttribute("loginMember");

		member.setMemberNo(loginMember.getMemberNo());
		
		HashMap<String, Integer> map = new HashMap();
		
		
		try {
			
			MyService service = new MyService();
			
			// ***** 주의 *****
			  // encType="multipart/form-data" 형식의 form태그에서
			  // 전달된 파라미터는 
			  // HttpServletRequest 객체로는 다룰 수 없다!
			  // --> cos.jar에서 제공하는 MultipartRequest를 사용해야 한다.
			  
			  // System.out.println(req.getParameter("boardTitle"));
			  // System.out.println(req.getParameter("boardContent"));
			  
			  // ***** MultipartRequest 사용을 위한 준비 *****
			  
			  // 1. 업로드 되는 파일 전체 합의 최대 용량 지정(byte 단위)
			  int maxSize = 1024 * 1024 * 100; // 100MB
			  
			  // 2. 업로드 되는 파일을 서버 컴퓨터에 어디에 저장할지 경로 지정
			  // -> 특정 폴더의 컴퓨터 내부 절대 경로
			  // /WEB-INF/views/board/            파일경로
			  // ${contextPath}/board/insert      주소경로

			  
			  // 프로젝트의 webapp폴더의 컴퓨터랑 실제 경로
			  String root = session.getServletContext().getRealPath("/");
			  
			  // 나머지 파일경로 (DB에 저장되어 주소 경로로 사용할 예정)
			  String filePath = "/resources/images/profile/";
			  
			  // 실제 경로 
			  String realPath = root + filePath;
			  
			  
			  // 3. 저장되는 파일의 이름을 변경
			  //  -> 중복되는 파일명을 방지하기 위해서
			  //  -> MyRenamePolicy 클래스
			  
			  // ********************************************************
			  // MutipartRequest 객체 생성
			  MultipartRequest mReq = 
					  new MultipartRequest(req, realPath, maxSize, "UTF-8", new MyRenamePolicy());
			  

			  // 로그인한 회원 번호
			  int memberNo = member.getMemberNo();
			  
			  

			  
			  
			  // 2) 파일 형식의 파라미터
			  
			  Enumeration<String> files = mReq.getFileNames();
			  // Enumeration == iterator (ResultSet과 비슷)
			  // -> 폼에서 전달된 모든 input type="file" 모든 요소의 name 속성을 반환
			  // -> 파일이 업로드되지 않아도 모든 요소를 얻어옴
			  
		  
			  if(files != null) {
				  // 업로드된 이미지 정보를 담을 List 생성
			  List<Member> imgList = new ArrayList<Member>();
			  
			  while(files.hasMoreElements()) {
				  // 다음 요소(name)가 있으면 true
				  
				  String name = files.nextElement(); // 다음 요소 값(name) 얻어오기
				  System.out.println("얻어온 name : " + name);
				  System.out.println("변환된 파일명 : "+ mReq.getFilesystemName(name));
				  System.out.println("원본 파일명 " + mReq.getOriginalFileName(name));
				  
				  // 현재 요소에 업로드할 파일이 있는 경우
				  if(mReq.getFilesystemName(name) != null) {
					  
					Member temp = new Member();
					  
					  temp.setImgName(mReq.getFilesystemName(name));
					  temp.setImgOrg(mReq.getOriginalFileName(name));
					  temp.setImgPath(filePath);
					  
					  // imgList에 추가
					  imgList.add(temp);
					  
					 int result = service.updateProfile(temp, memberNo);
					 
					 
					
					 if(result > 0) {

						 loginMember.setImgName(temp.getImgName());
						 loginMember.setImgOrg(temp.getImgOrg());
						 
						 map.put("result", 1);

						 
						 
					 }else {
						 
						 map.put("result", 0);
					 }
					 new Gson().toJson(map, resp.getWriter());
					  
				  }
				  
				  
				  
			}

			
			
			}
		} catch (Exception e) {
			e.printStackTrace();

			req.setAttribute("errorMessage", "회원 정보 수정 과정에서 오류 발생");
			req.setAttribute("e", e);

			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		
		}
		
		
		
		
		
	}
	
}
