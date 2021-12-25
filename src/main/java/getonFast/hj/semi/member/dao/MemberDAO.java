package getonFast.hj.semi.member.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import getonFast.hj.semi.member.vo.Member;


import static getonFast.hj.semi.common.JDBCTemplate.*;


public class MemberDAO {

	
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;

	
	private Properties prop;
	

	public MemberDAO() { 

		

		try {
			prop = new Properties();

			String filePath = MemberDAO.class.getResource("/getonFast/hj/semi/sql/member-query.xml").getPath();
			// -> SQL이 작성된 XML 파일의 경로

			prop.loadFromXML(new FileInputStream(filePath));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public int emailDupCheck(String inputEmail, Connection conn) throws Exception{
		
		int result = 0;
		try {
			String sql = prop.getProperty("emailDupCheck");
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, inputEmail);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				result = rs.getInt(1);

			}

		} finally {
			close(rs);
			close(pstmt);
		}

		return result;
		

	}

	/** 회원가입 DAO
	 * @param member
	 * @param conn
	 * @return result
	 * @throws Exception
	 */
	public int signUp(Member member, Connection conn) throws Exception {
		
		int result = 0;

		try {

			
			String sql = prop.getProperty("signUp");
			
			pstmt = conn.prepareStatement(sql);

			
			
			pstmt.setString(1, member.getMemberEmail());
			pstmt.setString(2, member.getMemberPw());
			pstmt.setString(3, member.getMemberName());
			pstmt.setInt(4, member.getMemberSMSChk());
			pstmt.setInt(5, member.getMemberEmailChk());
			
			

		
			result = pstmt.executeUpdate();

		} finally {

			
			close(pstmt);

		}
		
		return result;
	}

	/** 로그인 DAO
	 * @param memberEmail
	 * @param memberPw
	 * @param conn
	 * @return loginMember
	 * @throws Exception
	 */
	public Member login(String memberEmail, String memberPw, Connection conn) throws Exception{
		
				Member loginMember = null;

				try {
					
					String sql = prop.getProperty("login");
				
					pstmt = conn.prepareStatement(sql);

					
					pstmt.setString(1, memberEmail);
					pstmt.setString(2, memberPw);
					
					
					
					rs = pstmt.executeQuery();

					
					if (rs.next()) {
						loginMember = new Member();

						loginMember.setMemberNo(rs.getInt("MEMBER_NO"));
						loginMember.setMemberEmail(memberEmail); 
						loginMember.setMemberName(rs.getString("MEMBER_NM"));
						loginMember.setMemberPhone(rs.getString("MEMBER_PNO"));
						loginMember.setStatusCode(rs.getInt("MEMBER_ST"));
						loginMember.setGradeCode(rs.getInt("MEMBER_GRADE"));
						loginMember.setEnrollDate(rs.getDate("MEMBER_REG_DT"));
						loginMember.setMemberSMSChk(rs.getInt("MEMBER_SMSCHK"));
						loginMember.setMemberSMSChk(rs.getInt("MEMBER_EMAILCHK"));
						loginMember.setImgName(rs.getString("MEMBER_IMG_NM"));
						loginMember.setImgOrg(rs.getString("MEMBER_IMG_ORG"));
						loginMember.setImgPath(rs.getString("MEMBER_IMG_PATH"));
						loginMember.setCertify(rs.getInt("MEMBER_CERTIFY"));

					}

				} finally {

					
					close(rs);
					close(pstmt);

				}
				
				return loginMember;
	}

	/** 회원탈퇴
	 * @param loginMember
	 * @param conn
	 * @return result
	 * @throws Exception
	 */
	public int secession(Member loginMember, Connection conn) throws Exception{
		int result = 0;
		try {
			// SQL 얻어오기
			String sql = prop.getProperty("secession");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, loginMember.getMemberNo());
			
			
			
			result = pstmt.executeUpdate();
			
			
		} finally {
			
			close(pstmt);
		}
		
		return result;
	}

	public int findPwdUpdate(String findUpdatePwd1, String email, Connection conn) throws Exception{
		
		
		int result = 0;

		try {

			String sql = prop.getProperty("findPwdUpdate");
			
			
			
			pstmt = conn.prepareStatement(sql);

			

			pstmt.setString(1, findUpdatePwd1);

			pstmt.setString(2, email);

			result = pstmt.executeUpdate();

		} finally {

			close(pstmt);
		}

		return result;
		
		
		
		
	}

	/** 이메일 인증
	 * @param certifyPwd
	 * @param email
	 * @param conn
	 * @return result
	 * @throws Exception
	 */
	public int certifyEmail(String certifyPwd, String email, Connection conn) throws Exception{
		
		int result = 0;
		System.out.println(certifyPwd);
		System.out.println(email);

		try {

			String sql = prop.getProperty("certifyEmail");
			
			
			
			pstmt = conn.prepareStatement(sql);


			pstmt.setString(1, email);
			
			pstmt.setString(2, certifyPwd);


			result = pstmt.executeUpdate();

		} finally {

			close(pstmt);
		}

		return result;
		
		
	}
}


