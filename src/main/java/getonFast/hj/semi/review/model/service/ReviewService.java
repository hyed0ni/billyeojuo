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
	 * @param memberNo 
	 * @return reviewlist
	 * @throws Exception
	 */
	public List<Review> reviewList(int memberNo) throws Exception {
		Connection conn = getConnection();
		
		List<Review> reviewList = dao.reviewList(memberNo, conn);
		
		close(conn);
		
		return reviewList;
	}


	/**
	 * 공간상세 리뷰 조회
	 * @param spaceNo
	 * @return reviewSpaceList
	 * @throws Exception
	 */
	public List<Review> reviewSpaceList(int spaceNo) throws Exception {
		Connection conn = getConnection();
		
		List<Review> reviewSpaceList = dao.reviewSpaceList(spaceNo, conn);
		
		close(conn);
		
		return reviewSpaceList;
	}
	
	

}
