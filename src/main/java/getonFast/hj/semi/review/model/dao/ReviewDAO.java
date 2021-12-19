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
	

}
