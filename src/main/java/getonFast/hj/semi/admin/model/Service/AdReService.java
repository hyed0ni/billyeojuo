package getonFast.hj.semi.admin.model.Service;

import static getonFast.hj.semi.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import getonFast.hj.semi.admin.model.dao.AdReDAO;
import getonFast.hj.semi.admin.model.vo.AdRe;
import getonFast.hj.semi.review.model.vo.Review;

public class AdReService {
	private AdReDAO dao = new AdReDAO();
	
	
	/**
	 * 리뷰 목록
	 * @return reviewlist
	 * @throws Exception
	 */
	public List<Review> reviewList() throws Exception {
		Connection conn = getConnection();
		
		List<Review> reviewList = dao.reviewList(conn);
		
		close(conn);
		
		return reviewList;
	}

}
