package getonFast.hj.semi.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(filterName = "loginFilter", urlPatterns
= {"/member/updatePwd", "/my/favorites", "/my/qna", "/my/review", "/res/reserve", "/res/reservation_detail", "/space/reservation", "/member/certify"})

public class LoginFilter implements Filter {
   public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

      // 1. Session을 얻어오기 위한 request 다운 캐스팅
      HttpServletRequest req = (HttpServletRequest)request;
      HttpServletResponse resp = (HttpServletResponse)response;
      
      // 2. Session 얻어오기
      HttpSession session = req.getSession();
      
      // 3. Session에서 loginMember를 얻어와 null인지 확인
      if (session.getAttribute("loginMember") == null) {
         
         // 4. null == 로그인 X --> 로그인페이지로 강제 이동
    	 resp.sendRedirect(req.getContextPath() + "/member/login");
         
      } else {
         // 5. 로그인이 된 상태 -> 정상 수행
         chain.doFilter(request, response);
      }
   }
   
   public void init(FilterConfig fConfig) throws ServletException {   }
   public void destroy() {   }

}
