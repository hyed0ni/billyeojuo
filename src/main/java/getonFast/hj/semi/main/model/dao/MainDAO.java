package getonFast.hj.semi.main.model.dao;

import static getonFast.hj.semi.common.JDBCTemplate.*;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import getonFast.hj.semi.main.model.vo.Exhibit;
import getonFast.hj.semi.main.model.vo.SpaceType;

public class MainDAO {
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private Properties prop;
	
	public MainDAO() {
		String filePath = MainDAO.class.getResource("/getonFast/hj/semi/sql/main-query.xml").getPath();                    
		
		try {
			prop = new Properties();
			prop.loadFromXML(new FileInputStream(filePath));
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 공간타입 조회
	 * @param conn
	 * @return spaceTypeList
	 * @throws Exception
	 */
	public List<SpaceType> selectSpaceType(Connection conn) throws Exception {
		
		List<SpaceType> spaceTypeList = new ArrayList<SpaceType>();
		
		try {
			String sql = prop.getProperty("selectSpaceType");
			
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				SpaceType spaceType = new SpaceType();
				
				spaceType.setSpaceTypeNo(rs.getInt("SPACE_TYPE_NO"));
				spaceType.setSpaceTypeNm(rs.getString("SPACE_TYPE_NM"));
				spaceType.setSpaceTypeSt(rs.getInt("SPACE_TYPE_ST"));
				spaceType.setSpaceTypeImg(rs.getString("SPACE_TYPE_IMG"));
				
				spaceTypeList.add(spaceType);
			}
			
		} finally {
			close(rs);
			close(pstmt);
			
		}
		
		return spaceTypeList;
	}

	/**
	 * 기획전 조회
	 * @param conn
	 * @return exhibitList
	 * @throws Exception
	 */
	public List<Exhibit> selectExhibit(Connection conn) throws Exception {
		List<Exhibit> exhibitList = new ArrayList<Exhibit>();
		
		try {
			String sql = prop.getProperty("selectExhibit");
			
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Exhibit exhibit = new Exhibit();
				
				exhibit.setExNo(rs.getInt("EX_NO"));
				exhibit.setExNm(rs.getString("EX_NM"));
				exhibit.setExSubNm(rs.getString("EX_SUB_NM"));
				exhibit.setExImg(rs.getString("EX_IMG"));
				
				exhibitList.add(exhibit);
				
			}
			
		} finally {
			close(rs);
			close(pstmt);
			
		}
				
		return exhibitList;
	}



}
