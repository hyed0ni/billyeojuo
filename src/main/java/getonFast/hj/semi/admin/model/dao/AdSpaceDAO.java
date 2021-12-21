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

import getonFast.hj.semi.admin.model.vo.AdRoomtype;
import getonFast.hj.semi.admin.model.vo.AdSpace;
import getonFast.hj.semi.admin.model.vo.AdSpaceImage;
import getonFast.hj.semi.admin.model.vo.AdSpaceOption;
import getonFast.hj.semi.admin.model.vo.AdSpaceRoomOption;
import getonFast.hj.semi.admin.model.vo.AdSpaceType;
import getonFast.hj.semi.promotion.model.dao.PromotionDAO;

public class AdSpaceDAO {
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private Properties prop;
	
	public  AdSpaceDAO() {
		String filePath = PromotionDAO.class.getResource("/getonFast/hj/semi/sql/ad-space-query.xml").getPath();                    
		
		try {
			prop = new Properties();
			prop.loadFromXML(new FileInputStream(filePath));
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	public List<AdSpaceType> selectspaceType(Connection conn) throws Exception{
		List<AdSpaceType> spaceType = new ArrayList<AdSpaceType>();
		
		try {
			String sql= prop.getProperty("selectSpaceType");
			pstmt=conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				AdSpaceType st = new AdSpaceType();
				st.setAdSpaceTypeNo(rs.getInt(1));
				st.setAdSpaceTypeName(rs.getString(2));
				
				spaceType.add(st);
			}
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return spaceType;
	}


	public List<AdSpaceOption> selectspaceOption(Connection conn) throws Exception {
		List<AdSpaceOption> spaceOption = new ArrayList<AdSpaceOption>();
		
		try {
			String sql= prop.getProperty("selectSpaceOption");
			pstmt=conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				AdSpaceOption so = new AdSpaceOption();
				so.setAdOptionNo(rs.getInt(1));
				so.setAdOptionName(rs.getString(2));
				
				spaceOption.add(so);
			}
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return spaceOption;
	}


	/** 다음 차례 공간번호 불러오기 
	 * @param conn
	 * @return
	 */
	public int nextSpaceNo(Connection conn) throws Exception {
		int spaceNo =0;
		try {
			String sql = prop.getProperty("nextSpaceNo");
			pstmt = conn.prepareStatement(sql);
			
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				spaceNo = rs.getInt(1);
			}
		}finally {
			close(rs);
			close(pstmt);
		}
		
		
		return spaceNo;
	}


	public int nextRoomNo(Connection conn) throws Exception{
		int roomNo =0;
		try {
			String sql = prop.getProperty("nextRoomNo");
			pstmt = conn.prepareStatement(sql);
			
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				roomNo = rs.getInt(1);
			}
		}finally {
			close(rs);
			close(pstmt);
		}
		
		
		return roomNo;
	}

	/** 공간 등록 
	 * @param space
	 * @param imgList 
	 * @param conn
	 * @return
	 * @throws Exception
	 */
	public int insertSpace(AdSpace space, List<AdSpaceImage> imgList, Connection conn) throws Exception{
		int result = 0;
		
		try {
			String sql = prop.getProperty("insertSpace");
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, space.getSpaceNo());
			pstmt.setString(2, space.getSpaceName());
			pstmt.setString(3, space.getSpaceSubName());
			pstmt.setString(4, space.getSpaceIntro());
			pstmt.setString(5, space.getSpaceGuide());
			pstmt.setString(6, space.getPrecautions());
			pstmt.setString(7, space.getRefundPolicy());
			pstmt.setString(8, space.getSpaceAddr());
			pstmt.setString(9, space.getSpacePhone());
			pstmt.setString(10, space.getSpaceTime());
			pstmt.setString(11, space.getSpaceClosedDt());
			pstmt.setString(12, imgList.get(0).getImgName());
			pstmt.setString(13, imgList.get(0).getImgPath());
			pstmt.setInt(14, space.getSpaceTypeNo());
			
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
		}
		
		return result;
	}


	/** 룸 타입 등록 
	 * @param roomType
	 * @param conn
	 * @return
	 * @throws Exception
	 */
	public int insertRoomType(AdRoomtype roomType, Connection conn) throws Exception {
		int result = 0;
		try {
			String sql = prop.getProperty("insertRoopType");
	
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, roomType.getRoomNo());
			pstmt.setString(2, roomType.getRoomName());
			pstmt.setInt(3, roomType.getRoomPrice());
			pstmt.setString(4, roomType.getRoomFit());
			pstmt.setString(5, roomType.getRoomDesc());
			pstmt.setInt(6, roomType.getSpaceNo());
			
			result= pstmt.executeUpdate();
			
			
		}finally {
			close(pstmt);
		}
		return result;
	}


	/** 공간 이미지 등록 
	 * @param conn
	 * @param img
	 * @return
	 * @throws Exception
	 */
	public int insertSpaceImage(Connection conn, AdSpaceImage img) throws Exception {
		
		int result = 0;
		try {
			String sql = prop.getProperty("insertImage");
			pstmt = conn.prepareStatement(sql);
			
			
			pstmt.setString(1, img.getImgPath());
			pstmt.setString(2, img.getImgName());
			pstmt.setString(3, img.getImgOriginal());
			pstmt.setInt(4, img.getImgLevel());
			pstmt.setInt(5, img.getSpaceNo());
			
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
		}
		return result;
	}


	public int insertspaceRoomOption(AdSpaceRoomOption spaceRoomOption, Connection conn) throws Exception{
		int result = 0;
		
		try {
			String sql = prop.getProperty("insertRoomOption");
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, spaceRoomOption.getRoomNo());
			pstmt.setInt(2, spaceRoomOption.getOptionNo());
			
			result = pstmt.executeUpdate();
			
			
		}finally {
			close(pstmt);
			
		}
		
		return result;
	}




}
