package getonFast.hj.semi.my.model.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import static getonFast.hj.semi.common.JDBCTemplate.*;

import getonFast.hj.semi.member.vo.Member;

public class MyDAO {

	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private Properties prop;

	Member member = new Member();

	public MyDAO() {
		try {
			prop = new Properties();

			String filePath = QnaDAO.class.getResource("/getonFast/hj/semi/sql/my-query.xml").getPath();
			// -> SQL이 작성된 XML 파일의 경로

			prop.loadFromXML(new FileInputStream(filePath));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 닉네임 수정
	 * 
	 * @param loginMember
	 * @param conn
	 * @return result
	 * @throws Exception
	 */
	public int updateNickName(Member member, Connection conn) throws Exception {

		int result = 0;

		try {

			String sql = prop.getProperty("updateNickName");

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, member.getMemberName());

			pstmt.setInt(2, member.getMemberNo());

			result = pstmt.executeUpdate();

		} finally {

			close(pstmt);

		}

		return result;
	}

	/**
	 * 전화번호 수정 DAO
	 * 
	 * @param member2
	 * @param conn
	 * @return result
	 * @throws Exception
	 */
	public int updatePhone(Member member, Connection conn) throws Exception {

		int result = 0;

		try {

			String sql = prop.getProperty("updatePhone");

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, member.getMemberPhone());

			pstmt.setInt(2, member.getMemberNo());

			result = pstmt.executeUpdate();

		} finally {

			close(pstmt);

		}

		return result;

	}

	/**
	 * 비밀번호 변경
	 * 
	 * @param member
	 * @param inputPwd
	 * @param conn
	 * @return member
	 */
	public int pwdUpdate(Member member, String inputPwd, Connection conn) throws Exception {

		int result = 0;

		try {

			String sql = prop.getProperty("pwdCheck");
			
			
			
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, member.getMemberPw());

			pstmt.setString(2, inputPwd);

			pstmt.setInt(3, member.getMemberNo());

			result = pstmt.executeUpdate();

		} finally {

			close(pstmt);
		}

		return result;
	}

	public int updateProfile(Member temp, int memberNo, Connection conn) throws Exception{
		int result = 0;

		try {
			String sql = prop.getProperty("updateProfile");
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, temp.getImgOrg());
			pstmt.setString(2, temp.getImgPath());
			pstmt.setString(3, temp.getImgName());
			pstmt.setInt(4, memberNo);
			
			result = pstmt.executeUpdate();
			
		} finally {
			close(pstmt);
		}
		
		return result;
		
	}

}
