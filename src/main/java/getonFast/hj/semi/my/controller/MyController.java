package getonFast.hj.semi.my.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;

import getonFast.hj.semi.common.MyRenamePolicy;
import getonFast.hj.semi.member.controller.loginServlet;
import getonFast.hj.semi.member.service.MemberService;
import getonFast.hj.semi.member.vo.Member;
import getonFast.hj.semi.my.model.service.MyService;

@WebServlet("/my")
public class MyController extends HttpServlet {

	loginServlet loginServelt = new loginServlet();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("css", "my");

		String path = "/WEB-INF/views/my/my.jsp";
		req.getRequestDispatcher(path).forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String inputName = req.getParameter("inputName");

		String inputPhone = req.getParameter("inputPhone");
		
		String inputPwd = req.getParameter("prePwd1");
		
		String inputNewPwd = req.getParameter("newPwd1");

		Member member = new Member();

		member.setMemberName(inputName);
				
		member.setMemberPhone(inputPhone);
		
		member.setMemberPw(inputNewPwd);


		HttpSession session = req.getSession();

		Member loginMember = (Member) session.getAttribute("loginMember");

		
		member.setMemberNo(loginMember.getMemberNo());

		try {

			MyService service = new MyService();
			

			if (inputName != null) {
				

				int result = service.updateNickName(member);

				if (result > 0) {
					session.setAttribute("message", "회원 닉네임이 수정 되었습니다.");

					loginMember.setMemberName(inputName);

				} else { 
					session.setAttribute("message", "회원 정보 수정 실패");
				}
				
			}else if(inputPhone != null) {
				
				int result = service.updatePhone(member);

				if (result > 0) {
					session.setAttribute("message", "회원 전화번호가 수정 되었습니다.");

					loginMember.setMemberPhone(inputPhone);

				} else { 
					session.setAttribute("message", "회원 정보 수정 실패");
				}
				
				
			}
			
			if(inputNewPwd != null) {
			
				
				 int result = service.pwdUpdate(member, inputPwd);
				
				 String message = null; // 성공 실패 메세지
					String path = null; // 마이페이지, 비밀번호 변경페이지

					if (result > 0) { // 성공
						
						
						message = "비밀번호가 수정 되었습니다.";
						path = "my";

					} else { // 실패
						message = "현재 비밀번호가 일치하지 않습니다.";
						path = "my";
					}

					req.getSession().setAttribute("message", message);
					/*
					 * resp.sendRedirect(path);
					 */
				
				
			}
			
				
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
  			  
  			  System.out.println(mReq);
 
  			  // 로그인한 회원 번호
  			  int memberNo = member.getMemberNo();
  			  
  			  System.out.println(member);
  			System.out.println(memberNo);
  			System.out.println("**************************");

  			  
  			  
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
 						 
 						 req.setAttribute("message", "upload");
 						 
 					 }else {
 						 
 						req.setAttribute("message", "fail");
 					 }
 					  
  				  }
			}

			// 내 정보 페이지 재요청
			resp.sendRedirect("my");
			
			}

		} catch (Exception e) {
			e.printStackTrace();

			req.setAttribute("errorMessage", "회원 정보 수정 과정에서 오류 발생");
			req.setAttribute("e", e);

			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}

	}

}
