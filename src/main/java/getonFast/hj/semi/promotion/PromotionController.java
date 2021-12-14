package getonFast.hj.semi.promotion;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/promotion")
public class PromotionController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("css",	"promotion");
		
		String path = "/WEB-INF/views/promotion/promotion.jsp";
		req.getRequestDispatcher(path).forward(req, resp);
	}
}




