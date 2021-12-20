package getonFast.hj.semi.promotion.model.dao;

import static getonFast.hj.semi.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import getonFast.hj.semi.promotion.model.vo.Promotion;

public class PromotionDAO {
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private Properties prop;
	
	public PromotionDAO() {
		String filePath = PromotionDAO.class.getResource("/getonFast/hj/semi/sql/promotion-query.xml").getPath();                    
		
		try {
			prop = new Properties();
			prop.loadFromXML(new FileInputStream(filePath));
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 기획전 조회
	 * @param conn
	 * @return promotionList
	 * @throws Exception
	 */
	public List<Promotion> selectPromotionList(Connection conn) throws Exception {
		
		List<Promotion> promotionList = new ArrayList<Promotion>();
		
		try {
			String sql = prop.getProperty("selectPromotionList");
			
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Promotion promotion = new Promotion();
				
				promotion.setExNo(rs.getInt("EX_NO"));
				promotion.setExNm(rs.getString("EX_NM"));
				promotion.setExSubNm(rs.getString("EX_SUB_NM"));
				promotion.setExImg(rs.getString("EX_IMG"));
				
				promotionList.add(promotion);
				
			}
			
		} finally {
			close(rs);
			close(pstmt);
			
		}
				
		return promotionList;
	}
}
