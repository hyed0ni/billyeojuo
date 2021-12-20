package getonFast.hj.semi.space.model.dao;

import static getonFast.hj.semi.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import getonFast.hj.semi.space.model.vo.Space;

public class SpaceDAO {
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private Properties prop;
	
	public SpaceDAO() {
		String filePath = SpaceDAO.class.getResource("/getonFast/hj/semi/sql/space-query.xml").getPath();                    
		
		try {
			prop = new Properties();
			prop.loadFromXML(new FileInputStream(filePath));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/** 공간 상세 조회
	 * @param spaceNo
	 * @param conn
	 * @return space
	 * @throws Exception
	 */
	public Space selectSpace(int spaceNo, Connection conn) throws Exception {
		Space space = null;
		
		try {
			String sql = prop.getProperty("selectSpace");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, spaceNo);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				
				space = new Space();
				
				space.setSpaceNm(rs.getString("SPACE_NM"));
				space.setSpaceSubNm(rs.getString("SPACE_SUB_NM"));
				space.setSpaceIntro(rs.getString("SPACE_INTRO"));
				space.setSpaceGuide(rs.getString("SPACE_GUIDE"));
				space.setPrecautions(rs.getString("PRECAUTIONS"));
				space.setRefundPolicy(rs.getString("REFUND_POLICY"));
				space.setSpaceAddr(rs.getString("SPACE_ADDR"));
				space.setSpacePno(rs.getString("SPACE_PNO"));
				space.setSpaceTime(rs.getString("SPACE_TIME"));
				space.setSpaceClosedDt(rs.getString("SPACE_CLOSED_DT"));
				space.setSpaceMapImg(rs.getString("SPACE_MAP_IMG"));
				space.setSpaceMapPath(rs.getString("SPACE_MAP_PATH"));

			}
			
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return space;
	}

	/** 공간 이미지 조회
	 * @param spaceNo
	 * @param conn
	 * @return spaceImg
	 * @throws Exception
	 */
	public Space selectSpaceImg(int spaceNo, Connection conn) throws Exception {
		Space spaceImg = null;
		
		try {
			String sql = prop.getProperty("selectSpaceImg");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, spaceNo);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				
				spaceImg = new Space();
				spaceImg.setSpaceImgPath(rs.getString("SPACE_IMG_PATH"));
				spaceImg.setSpaceImgNm(rs.getString("SPACE_IMG_NM"));

			}
			
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return spaceImg;
	}

}
