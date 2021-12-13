package getonFast.hj.semi.review;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/my/review")
public class ReviewController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setAttribute("css", "review");
		
		String path = "/WEB-INF/views/review/review.jsp";
		req.getRequestDispatcher(path).forward(req, resp);
	}

}
