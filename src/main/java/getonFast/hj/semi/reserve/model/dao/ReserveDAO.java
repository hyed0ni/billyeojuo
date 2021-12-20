package getonFast.hj.semi.reserve.model.dao;

import static getonFast.hj.semi.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import getonFast.hj.semi.reserve.model.vo.Reserve;

public class ReserveDAO {
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private Properties prop;
	
	public ReserveDAO() {
		String filePath = ReserveDAO.class.getResource("/getonFast/hj/semi/sql/reserve-query.xml").getPath();                    
		
		try {
			prop = new Properties();
			prop.loadFromXML(new FileInputStream(filePath));
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 예약 조회
	 * @param memberNo 
	 * @param conn
	 * @return
	 * @throws Exception
	 */
	public List<Reserve> selectReserveList(int memberNo, Connection conn) throws Exception {
		
		List<Reserve> reserveList = new ArrayList<Reserve>();
		
		try {
			String sql = prop.getProperty("selectReserveList");
			pstmt = conn.prepareStatement(sql);
			
			// member_no
			pstmt.setInt(1, memberNo);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Reserve reserve = new Reserve();
				
				reserve.setResNo(rs.getInt("RES_NO"));
				reserve.setResPersonnel(rs.getString("RES_PERSONNEL"));
				reserve.setResNm(rs.getString("RES_NM"));
				reserve.setResPno(rs.getString("RES_PNO"));
				reserve.setResEmail(rs.getString("RES_EMAIL"));
				reserve.setResPurpose(rs.getString("RES_PURPOSE"));
				reserve.setResReq(rs.getString("RES_REQ"));
				reserve.setResAgree(rs.getString("RES_AGREE"));
				reserve.setPayMethod(rs.getInt("PAY_METHOD"));
				reserve.setPayDate(rs.getDate("PAY_DATE"));
				reserve.setUseDate(rs.getDate("USE_DATE"));
				reserve.setResDt(rs.getInt("RES_DT"));
				reserve.setMemberNo(rs.getInt("MEMBER_NO"));
				reserve.setSpaceRoomNo(rs.getInt("SPACE_ROOM_NO"));
				
				reserveList.add(reserve);
			}
			
		} finally {
			close(rs);
			close(pstmt);
			
		}
		
		return reserveList;
	}

}
