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

	/**
	 * 이용 후기 등록
	 * @param spaceNo
	 * @param reviewContent
	 * @param memberNo
	 * @param resNo 
	 * @return result
	 * @throws Exception
	 */
	public int insertReview(int spaceNo, String reviewContent, int memberNo, int resNo) throws Exception {
		Connection conn = getConnection();
		
		int result = dao.insertReview(spaceNo, reviewContent, memberNo, resNo, conn);
		
		if (result > 0) commit(conn);
		else rollback(conn);
				
		return result;
	}
	
	

}
