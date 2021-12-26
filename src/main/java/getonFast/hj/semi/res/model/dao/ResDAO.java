package getonFast.hj.semi.res.model.dao;

import static getonFast.hj.semi.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import getonFast.hj.semi.res.model.vo.Res;
import getonFast.hj.semi.space.model.dao.SpaceDAO;
import getonFast.hj.semi.space.model.vo.Space;

public class ResDAO {
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private Properties prop;
	
	public ResDAO() {
		String filePath = ResDAO.class.getResource("/getonFast/hj/semi/sql/res-query.xml").getPath();                    
		
		try {
			prop = new Properties();
			prop.loadFromXML(new FileInputStream(filePath));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/** 예약공간 등록
	 * @param res
	 * @param conn
	 * @return resSpace
	 * @throws Exception
	 */
	public int insertRes(Res res, Connection conn) throws Exception {
		int resSpace = 0;
		
		try {
			String sql = prop.getProperty("insertRes");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, res.getResNo());
			pstmt.setString(2, res.getResPersonnel());
			pstmt.setString(3, res.getResNm());
			pstmt.setString(4, res.getResPno());
			pstmt.setString(5, res.getResEmail());
			pstmt.setString(6, res.getResPurpose());
			pstmt.setString(7, res.getResReq());
			pstmt.setString(8, res.getUseDate());
			pstmt.setInt(9, res.getMemberNo());
			pstmt.setInt(10, res.getSpace().getSpaceRoomNo());
			
			resSpace = pstmt.executeUpdate();
			
		} finally {
			close(pstmt);
		}
		
		return resSpace;
	}

	/** 다음 예약번호 조회
	 * @param conn
	 * @return resNo
	 * @throws Exception
	 */
	public int nextResNo(Connection conn) throws Exception {
		int resNo = 0;
		
		try {
			String sql = prop.getProperty("nextResNo");
			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if (rs.next())
				resNo = rs.getInt(1);
			
		} finally {
			close(rs);
			close(pstmt);
		}

		return resNo;
	}
	
	/** 예약정보 조회
	 * @param resNo
	 * @param sort
	 * @param conn
	 * @return resList
	 * @throws Exception
	 */
	public List<Res> selectResList(int memberNo, String sort, Connection conn) throws Exception {
		List<Res> resList = new ArrayList<Res>();
		
		try {
			String sql = prop.getProperty("selectResList-" + sort);
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, memberNo);
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				Res resSpace = new Res();
				
				resSpace.setResNo(rs.getInt("RES_NO"));
				resSpace.setUseDate(rs.getString("USE_DATE"));
				resSpace.setResDt(rs.getInt("RES_DT"));
				
				resSpace.setSpace(new Space());
				
				resSpace.getSpace().setSpaceRoomNm(rs.getString("SPACE_ROOM_NM"));
				resSpace.getSpace().setSpaceRoomPrice(rs.getInt("SPACE_ROOM_PRICE"));
				resSpace.getSpace().setSpaceNm(rs.getString("SPACE_NM"));
				resSpace.getSpace().setSpaceImgPath(rs.getString("SPACE_IMG_PATH"));
				resSpace.getSpace().setSpaceImgNm(rs.getString("SPACE_IMG_NM"));
				
				resList.add(resSpace);
			}
			
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return resList;
	}

	/** 예약공간 상세 조회
	 * @param resNo
	 * @param conn
	 * @return res
	 * @throws Exception
	 */
	public Res selectRes(int resNo, Connection conn) throws Exception {
		Res res = null;
		
		try {
			String sql = prop.getProperty("selectRes");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, resNo);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				res = new Res();
				
				res.setResNo(rs.getInt("RES_NO"));
				res.setResPersonnel(rs.getString("RES_PERSONNEL"));
				res.setResNm(rs.getString("RES_NM"));
				res.setResPno(rs.getString("RES_PNO"));
				res.setResEmail(rs.getString("RES_EMAIL"));
				res.setResPurpose(rs.getString("RES_PURPOSE"));
				res.setResReq(rs.getString("RES_REQ"));
				res.setPayDate(rs.getString("PAY_DATE"));
				res.setUseDate(rs.getString("USE_DATE"));
				res.setResDt(rs.getInt("RES_DT"));
				
				res.setSpace(new Space());
				
				res.getSpace().setSpaceRoomNm(rs.getString("SPACE_ROOM_NM"));
				res.getSpace().setSpaceRoomPrice(rs.getInt("SPACE_ROOM_PRICE"));
				res.getSpace().setSpaceNm(rs.getString("SPACE_NM"));
				res.getSpace().setRefundPolicy(rs.getString("REFUND_POLICY"));
				res.getSpace().setSpaceAddr(rs.getString("SPACE_ADDR"));
				res.getSpace().setSpacePno(rs.getString("SPACE_PNO"));
				res.getSpace().setSpaceMapImg(rs.getString("SPACE_MAP_IMG"));
				res.getSpace().setSpaceMapPath(rs.getString("SPACE_MAP_PATH"));
				res.getSpace().setSpaceImgPath(rs.getString("SPACE_IMG_PATH"));
				res.getSpace().setSpaceImgNm(rs.getString("SPACE_IMG_NM"));
			}
			
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return res;
	}
	
	/** 결제취소 상태값 변경
	 * @param resNo
	 * @param conn
	 * @return updateDt
	 * @throws Exception
	 */
	public int updateDt(int resNo, Connection conn) throws Exception {
		int updateDt = 0;
		
		try {
			String sql = prop.getProperty("updateDt");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, resNo);
			
			updateDt = pstmt.executeUpdate();
			
		} finally {
			close(pstmt);
		}
		
		return updateDt;
	}

	/**
	 * 공간 상세 이용 후기 작성 여부
	 * @param spaceNo
	 * @param memberNo
	 * @param conn
	 * @return 공간 상세 이용 후기 작성 여부
	 * @throws Exception
	 */
	public Map<String, String> selectResReview(int spaceNo, int memberNo, Connection conn) throws Exception {
		Map<String, String> selectResReview = new HashMap<String, String>();
		
		try {
			String sql = prop.getProperty("selectResReview");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, memberNo);
			pstmt.setInt(2, spaceNo);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				selectResReview.put("resNo", Integer.toString(rs.getInt("RES_NO")));
				selectResReview.put("spaceNo", Integer.toString(rs.getInt("SPACE_NO")));
				selectResReview.put("memberNo", Integer.toString(rs.getInt("MEMBER_NO")));
				selectResReview.put("resDt", Integer.toString(rs.getInt("RES_DT")));
				selectResReview.put("revNo", Integer.toString(rs.getInt("REV_NO")));
			}
			
		} finally {
			close(rs);
			close(pstmt);
			
		}
		
		return selectResReview;
	}

}
