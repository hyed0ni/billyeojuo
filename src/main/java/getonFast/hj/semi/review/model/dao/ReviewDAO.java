package getonFast.hj.semi.review.model.dao;

import static getonFast.hj.semi.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import getonFast.hj.semi.member.vo.Member;
import getonFast.hj.semi.review.model.vo.Review;

public class ReviewDAO {
	
	// JDBC 객체 참조 변수
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	// XML에 작성된 SQL을 얻어와 저장할 Collection 객체 참조 변수 선언
	private Properties prop;
	// Properties : key, value가 모두 String 인 MAP
	
	public ReviewDAO () {
		// DAO 객체 생성 시 특정 위치에 있는 XML 파일을 읽어와 prop에 저장
		try {
			prop = new Properties();
			
			String filePath = ReviewDAO.class.getResource("/getonFast/hj/semi/sql/review-query.xml").getPath();
			// -> SQL이 작성된 XML 파일의 경로
			
			prop.loadFromXML( new FileInputStream(filePath));
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 리뷰 목록
	 * @param memberNo 
	 * @param conn
	 * @return reviewList
	 * @throws Exception
	 */
	public List<Review> reviewList(int memberNo, Connection conn) throws Exception {
		List<Review> reviewList = new ArrayList<Review>();
		
		try {
			String sql = prop.getProperty("reviewList");
			
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Review review = new Review();
				
				review.setRevNo(rs.getInt("REV_NO"));
				review.setRevContent(rs.getString("REV_CONTENT"));
				review.setRevDt(rs.getString("REV_DT"));
				review.setRevSt(rs.getInt("REV_ST"));
				review.setResNo(rs.getInt("RES_NO"));
				
				reviewList.add(review);
				
			}
			
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return reviewList;
	}

	/**
	 * 공간 상세 리뷰 조회
	 * @param spaceNo
	 * @param conn
	 * @return reviewSpaceList
	 * @throws Exception
	 */
	public List<Review> reviewSpaceList(int spaceNo, Connection conn) throws Exception {
		List<Review> reviewSpaceList = new ArrayList<Review>();
		
		try {
			String sql = prop.getProperty("reviewSpaceList");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, spaceNo);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Review review = new Review();
				review.setRevNo(rs.getInt("REV_NO"));
				review.setRevContent(rs.getString("REV_CONTENT"));
				review.setRevDt(rs.getString("REV_DT"));
				review.setRevSt(rs.getInt("REV_ST"));
				review.setResNo(rs.getInt("RES_NO"));
				
				review.setSpaceRoomNo(rs.getInt("SPACE_ROOM_NO"));
				review.setSpaceNo(rs.getInt("SPACE_NO"));
				
				Member member = new Member();
				member.setImgPath(rs.getString("MEMBER_IMG_PATH"));
				member.setImgName(rs.getString("MEMBER_IMG_NM"));
				member.setMemberName(rs.getString("MEMBER_NM"));
				
				review.setMember(member);
				
				reviewSpaceList.add(review);
			}
			
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return reviewSpaceList;
	}

	
	/**
	 * 이용 후기 등록
	 * @param spaceNo
	 * @param reviewContent
	 * @param memberNo
	 * @param resNo 
	 * @param conn
	 * @return result
	 * @throws Exception
	 */
	public int insertReview(int spaceNo, String reviewContent, int memberNo, int resNo, Connection conn) throws Exception {
		int result = 0;
		
		try {
			String sql = prop.getProperty("insertReview");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, reviewContent);
			pstmt.setInt(2, resNo);
			
			result = pstmt.executeUpdate();
			
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	

}
