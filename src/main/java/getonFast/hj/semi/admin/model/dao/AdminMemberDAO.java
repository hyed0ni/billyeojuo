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

import getonFast.hj.semi.admin.model.vo.AdminMember;

public class AdminMemberDAO {
	
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private Properties prop;
	
	public AdminMemberDAO() {
		String filePath = AdminMemberDAO.class.getResource("/getonFast/hj/semi/sql/adminMember-query.xml").getPath();                    
		
		try {
			prop = new Properties();
			prop.loadFromXML(new FileInputStream(filePath));
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	/**
	 * 회원 목록
	 * @param search
	 * @param conn
	 * @return memberList
	 * @throws Exception
	 */
	public List<AdminMember> selectMemberList(String search, Connection conn) throws Exception {
		List<AdminMember> memberList = new ArrayList<AdminMember>();
		
		try {
			String sql = prop.getProperty("selectMemberList");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, search);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				AdminMember member = new AdminMember();
				member.setMemberNo(rs.getInt(1));
				member.setMemberEmail(rs.getString(2));
				member.setMemberNm(rs.getString(3));
				member.setMemberImgPath(rs.getString(4));
				member.setMemberImgNm(rs.getString(5));
				member.setMemberSt(rs.getInt(6));
				member.setMemberRegDt(rs.getString(7));
				member.setMemberSecDt(rs.getString(8));
				
				memberList.add(member);
				
			}
			
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return memberList;
	}

}
