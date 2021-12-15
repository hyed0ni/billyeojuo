package getonFast.hj.semi.favorites;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/my/favorites")
public class FavoritesServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("css",	"favorites");
		
		String path = "/WEB-INF/views/my/favorites.jsp";
		req.getRequestDispatcher(path).forward(req, resp);
	}
}
