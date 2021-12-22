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

import getonFast.hj.semi.main.model.vo.SpaceList;
import getonFast.hj.semi.main.model.vo.SpaceType;
import getonFast.hj.semi.space.model.vo.Space;

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

	public List<SpaceList> selectRecommendList(Connection conn) throws Exception {
		
		List<SpaceList> recommendList = new ArrayList<SpaceList>();
		
		try {
			String sql = prop.getProperty("selectRecommend");
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				SpaceList rc = new SpaceList();
				rc.setSpaceNo(rs.getInt("SPACE_NO"));
				rc.setSpaceNm(rs.getString("SPACE_NM"));
				rc.setSpaceSubNm(rs.getString("SPACE_SUB_NM"));
				rc.setRoomPrice(rs.getInt("MIN(SPACE_ROOM_PRICE)"));
				rc.setRoomFit(rs.getString("SPACE_ROOM_FIT"));
				rc.setLike(rs.getInt("NVL(COUNT(MEMBER_NO),0)"));
				rc.setImgPath(rs.getString("SPACE_IMG_PATH"));
				rc.setImgName(rs.getString("SPACE_IMG_NM"));
				
				recommendList.add(rc);
			}
			
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return recommendList;
	}

	public List<SpaceList> selectSearchList(String sv, Connection conn) throws Exception {

		List<SpaceList> searchList = new ArrayList<SpaceList>();
		
		try {
			
			String sql = prop.getProperty("selectSearchList");
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, sv);

			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				SpaceList rc = new SpaceList();
				rc.setSpaceNo(rs.getInt("SPACE_NO"));
				rc.setSpaceNm(rs.getString("SPACE_NM"));
				rc.setSpaceSubNm(rs.getString("SPACE_SUB_NM"));
				rc.setRoomPrice(rs.getInt("MIN(SPACE_ROOM_PRICE)"));
				rc.setRoomFit(rs.getString("SPACE_ROOM_FIT"));
				rc.setLike(rs.getInt("NVL(COUNT(MEMBER_NO),0)"));
				rc.setImgPath(rs.getString("SPACE_IMG_PATH"));
				rc.setImgName(rs.getString("SPACE_IMG_NM"));
				
				searchList.add(rc);
			}
			
		}finally {
			close(rs);
			close(pstmt);
		}
			
		return searchList;
	}

}
