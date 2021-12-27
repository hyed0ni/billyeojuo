package getonFast.hj.semi.admin.model.dao;

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

public class AdReDAO {
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private Properties prop;
	
	public AdReDAO() {
		String filePath = AdReDAO.class.getResource("/getonFast/hj/semi/sql/ad-answer-query.xml").getPath();                    
		
		try {
			prop = new Properties();
			prop.loadFromXML(new FileInputStream(filePath));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 리뷰 목록
	 * @param conn
	 * @return reviewList
	 * @throws Exception
	 */
	public List<Review> reviewList(Connection conn) throws Exception {
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