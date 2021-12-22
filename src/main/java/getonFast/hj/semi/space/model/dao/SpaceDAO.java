package getonFast.hj.semi.space.model.dao;

import static getonFast.hj.semi.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
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

	/** 공간룸 조회
	 * @param spaceNo
	 * @param conn
	 * @return spaceRoom
	 * @throws Exception
	 */
	public List<Space> selectSpaceRoom(int spaceNo, Connection conn) throws Exception {
		List<Space> spaceRoomList = new ArrayList<Space>();
		
		try {
			String sql = prop.getProperty("selectSpaceRoom");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, spaceNo);
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				
				Space spaceRoom = new Space();
				spaceRoom.setSpaceRoomNo(rs.getInt("SPACE_ROOM_NO"));
				spaceRoom.setSpaceRoomNm(rs.getString("SPACE_ROOM_NM"));
				spaceRoom.setSpaceRoomPrice(rs.getInt("SPACE_ROOM_PRICE"));
				spaceRoom.setSpaceRoomFit(rs.getString("SPACE_ROOM_FIT"));
				spaceRoom.setSpaceRoomDesc(rs.getString("SPACE_ROOM_DESC"));
				
				spaceRoomList.add(spaceRoom);
			}
			
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return spaceRoomList;	
	}

	/** 공간유형 조회
	 * @param spaceNo
	 * @param conn
	 * @return spaceType
	 * @throws Exception
	 */
	public Space selectSpaceType(int spaceNo, Connection conn) throws Exception {
		Space spaceType = null;
		
		try {
			String sql = prop.getProperty("selectSpaceType");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, spaceNo);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				spaceType = new Space();
				spaceType.setSpaceTypeNm(rs.getString("SPACE_TYPE_NM"));

			}
			
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return spaceType;
	}
	
	/** 공간옵션 조회
	 * @param spaceRoomNo
	 * @param conn
	 * @return spaceOptionList
	 * @throws Exception
	 */
	public List<Space> selectSpaceOption(int spaceRoomNo, Connection conn) throws Exception {
		List<Space> spaceOptionList = new ArrayList<Space>();
			
		try {
			String sql = prop.getProperty("selectSpaceOption");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, spaceRoomNo);
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				Space spaceOption = new Space();
				
				spaceOption.setOptionNm(rs.getString("OPTION_NM"));
				spaceOption.setOptionIcon(rs.getString("OPTION_ICON"));
				
				spaceOptionList.add(spaceOption);
			}
			
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return spaceOptionList;
	}

	/** 찜한공간 등록
	 * @param spaceNo
	 * @param memberNo
	 * @param conn
	 * @return heart
	 */
	public int insertHeart(int spaceNo, int memberNo, Connection conn) throws SQLException {
		int heart = 0;
		
		try {
			String sql = prop.getProperty("insertHeart");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, memberNo);
			pstmt.setInt(2, spaceNo);
			
			heart = pstmt.executeUpdate();
			
		} finally {
			close(pstmt);
		}
		
		
		return heart;
	}
	
	/** 찜한공간 삭제
	 * @param spaceNo
	 * @param memberNo
	 * @param conn
	 * @return heart
	 */
	public int deleteHeart(int spaceNo, int memberNo, Connection conn) throws SQLException {
		int heart = 0;
		
		try {
			String sql = prop.getProperty("deleteHeart");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, memberNo);
			pstmt.setInt(2, spaceNo);
			
			heart = pstmt.executeUpdate();
			
		} finally {
			close(pstmt);
		}
		
		return heart;
	}

	/** 찜한공간 조회
	 * @param spaceNo
	 * @param memberNo
	 * @param conn 
	 * @return spaceHeart
	 * @throws Exception
	 */
	public int selectHeart(int spaceNo, int memberNo, Connection conn) throws Exception {
		int spaceHeart = 0;
		
		try {
			String sql = prop.getProperty("selectHeart");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, memberNo);
			pstmt.setInt(2, spaceNo);
			
			rs = pstmt.executeQuery();
			
			if (rs.next())
				spaceHeart = rs.getInt(1);
			
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return spaceHeart;
	}
	
//	------------------------------------------------------------------------------------------------------

	/** 공간룸 상세 조회
	 * @param spaceRoomNo
	 * @param conn
	 * @return spaceRoom
	 * @throws Exception
	 */
	public Space selectSpaceRoomRes(int spaceRoomNo, Connection conn) throws Exception {
		Space spaceRoom = null;
		
		try {
			String sql = prop.getProperty("selectSpaceRoomRes");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, spaceRoomNo);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				spaceRoom = new Space();
				spaceRoom.setSpaceRoomNm(rs.getString("SPACE_ROOM_NM"));
				spaceRoom.setSpaceRoomPrice(rs.getInt("SPACE_ROOM_PRICE"));
				spaceRoom.setSpaceRoomFit(rs.getString("SPACE_ROOM_FIT"));
				spaceRoom.setSpaceRoomDesc(rs.getString("SPACE_ROOM_DESC"));

			}
			
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return spaceRoom;
	}
	
	/** 공간 상세 조회
	 * @param spaceRoomNo
	 * @param conn
	 * @return space
	 * @throws Exception
	 */
	public Space selectSpaceRes(int spaceRoomNo, Connection conn) throws Exception {
		Space space = null;
		
		try {
			String sql = prop.getProperty("selectSpaceRes");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, spaceRoomNo);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				space = new Space();
				space.setSpaceNm(rs.getString("SPACE_NM"));
				space.setPrecautions(rs.getString("PRECAUTIONS"));
				
			}
			
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return space;
	}
	
	/** 공간유형 조회
	 * @param spaceRoomNo
	 * @param conn
	 * @return spaceType
	 * @throws Exception
	 */
	public Space selectSpaceTypeRes(int spaceRoomNo, Connection conn) throws Exception {
		Space spaceType = null;
		
		try {
			String sql = prop.getProperty("selectSpaceTypeRes");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, spaceRoomNo);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				spaceType = new Space();
				spaceType.setSpaceTypeNm(rs.getString("SPACE_TYPE_NM"));

			}
			
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return spaceType;
	}

	/** 공간 이미지 조회
	 * @param spaceRoomNo
	 * @param conn
	 * @return spaceImg
	 * @throws Exception
	 */
	public Space selectSpaceImgRes(int spaceRoomNo, Connection conn) throws Exception {
		Space spaceImg = null;
		
		try {
			String sql = prop.getProperty("selectSpaceImgRes");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, spaceRoomNo);
			
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
