package getonFast.hj.semi.favorites.model.DAO;

import static getonFast.hj.semi.common.JDBCTemplate.*;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import getonFast.hj.semi.common.Pagination;
import getonFast.hj.semi.main.model.dao.MainDAO;
import getonFast.hj.semi.main.model.vo.SpaceList;

public class FavoriteDAO {
	
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private Properties prop;
	
	
	public FavoriteDAO() {
		String filePath = MainDAO.class.getResource("/getonFast/hj/semi/sql/like-query.xml").getPath();                    
		
		try {
			prop = new Properties();
			prop.loadFromXML(new FileInputStream(filePath));
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}


	public List<SpaceList> selectLikeList(Connection conn, int memberNo, Pagination pagination) throws Exception {
		
		List<SpaceList> resultList  = new ArrayList<SpaceList>();
		
		try {
			
			int startRow = (pagination.getCurrentPage() -1 ) * pagination.getLimit() + 1;
			int endRow = startRow + pagination.getLimit() -	1;
			
			String sql = prop.getProperty("selctLikeList");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, memberNo);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				SpaceList rc = new SpaceList();
				rc.setSpaceNo(rs.getInt("SPACE_NO"));
				rc.setSpaceNm(rs.getString("SPACE_NM"));
				rc.setSpaceSubNm(rs.getString("SPACE_SUB_NM"));
				rc.setRoomPrice(rs.getInt("PRICE"));
				rc.setRoomFit(rs.getString("SPACE_ROOM_FIT"));
				rc.setLike(rs.getInt("LIKE"));
				rc.setImgPath(rs.getString("SPACE_IMG_PATH"));
				rc.setImgName(rs.getString("SPACE_IMG_NM"));
				
				resultList.add(rc);
			}
			
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return resultList;
	}


	public int getlistCount(Connection conn, int memberNo) throws Exception{
		int listCount = 0;
		try {
			
			String sql = prop.getProperty("selectLikeListAll");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, memberNo);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				listCount = rs.getInt(1);
			}
			
		}finally {
			close(pstmt);
		}
		
		return listCount;
	}
	
	
}
