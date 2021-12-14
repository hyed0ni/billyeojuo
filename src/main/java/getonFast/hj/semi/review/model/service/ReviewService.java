package getonFast.hj.semi.review.model.service;

import static getonFast.hj.semi.common.JDBCTemplate.*;
import java.sql.Connection;
import java.util.List;

import getonFast.hj.semi.review.model.dao.ReviewDAO;
import getonFast.hj.semi.review.model.vo.Review;

public class ReviewService {
	private ReviewDAO dao = new ReviewDAO();
	

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
