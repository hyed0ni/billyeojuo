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

import getonFast.hj.semi.admin.model.vo.AdSpaceOption;
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

}
