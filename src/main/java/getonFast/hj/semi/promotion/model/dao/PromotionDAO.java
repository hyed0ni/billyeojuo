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
import getonFast.hj.semi.promotion.model.vo.PromotionDetail;

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

	public List<PromotionDetail> selectProDetailList(Connection conn, int exNo) throws Exception{
		List<PromotionDetail> resultList = new ArrayList<PromotionDetail>();
		
		try {
			String sql = prop.getProperty("selectProDetailList");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, exNo);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				PromotionDetail pd = new PromotionDetail();
				
				pd.setSpaceNo(rs.getInt("SPACE_NO"));
				pd.setSpaceNm(rs.getString("SPACE_NM"));
				pd.setSpaceSubNm(rs.getString("SPACE_SUB_NM"));
				pd.setRoomPrice(rs.getInt("MIN(SPACE_ROOM_PRICE)"));
				pd.setRoomFit(rs.getString("SPACE_ROOM_FIT"));
				pd.setLike(rs.getInt("NVL(COUNT(MEMBER_NO),0)"));
				pd.setSpaceImgPath(rs.getString("SPACE_IMG_PATH"));
				pd.setSpaceImgName(rs.getString("SPACE_IMG_NM"));
				
				resultList.add(pd);
			}
			
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return resultList;
	}

	public Promotion selectProDetailTitle(Connection conn, int exNo) throws Exception {
		
		Promotion title = new Promotion();
		
		try {
			 String sql = prop.getProperty("selectPromotionList") + prop.getProperty("wherePro") ;
			
			 pstmt = conn.prepareStatement(sql);
			 pstmt.setInt(1, exNo);
			 
			 rs = pstmt.executeQuery();
			 
			 if(rs.next()) {
				 
				title.setExNo(rs.getInt("EX_NO"));
				title.setExNm(rs.getString("EX_NM"));
				title.setExSubNm(rs.getString("EX_SUB_NM"));
				title.setExImg(rs.getString("EX_IMG"));
		 }
			 
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return title;
	}
}
