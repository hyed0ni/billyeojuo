package getonFast.hj.semi.my.model.dao;

import static getonFast.hj.semi.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Properties;

import getonFast.hj.semi.my.model.vo.Qna;
import getonFast.hj.semi.review.model.dao.ReviewDAO;

public class QnaDAO {
	
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private Properties prop;
	
	public QnaDAO () {
		try {
			prop = new Properties();
			
			String filePath = QnaDAO.class.getResource("/getonFast/hj/semi/sql/qna-query.xml").getPath();
			// -> SQL이 작성된 XML 파일의 경로
			
			prop.loadFromXML( new FileInputStream(filePath));
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
		

	/**
	 * 문의 조회
	 * @param memberNo
	 * @param sort 
	 * @param conn
	 * @return qnaList
	 * @throws Exception
	 */
	public List<Qna> qnaList(int memberNo, String sort, Connection conn) throws Exception {
		List<Qna> qnaList = new ArrayList<Qna>();
		
		try {
			
			if (sort.equals("one")) {
				String sql = prop.getProperty("qnaListSortOne");
				pstmt = conn.prepareStatement(sql);
			} else if (sort.equals("space")) {
				String sql = prop.getProperty("qnaListSortSpace");
				pstmt = conn.prepareStatement(sql);
			} else {
				String sql = prop.getProperty("qnaList");
				pstmt = conn.prepareStatement(sql);
			}
			
			pstmt.setInt(1, memberNo);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Qna qna = new Qna();
				qna.setQueNo(rs.getInt("QUE_NO"));
				qna.setInqType(rs.getInt("INQ_TYPE"));
				qna.setQueTitle(rs.getString("QUE_TITLE"));
				qna.setQueContent(rs.getString("QUE_CONTENT"));
				qna.setQueDt(rs.getString("QUE_DT"));
				qna.setQueSt(rs.getInt("QUE_ST"));
				qna.setMemberNo(rs.getInt("MEMBER_NO"));
				qna.setSpaceNo(rs.getInt("SPACE_NO"));
				qna.setSpaceNm(rs.getString("SPACE_NM"));
				qna.setSpaceImgPath(rs.getString("SPACE_IMG_PATH"));
				qna.setSpaceImgNm(rs.getString("SPACE_IMG_NM"));
				qna.setSpaceImgOrg(rs.getString("SPACE_IMG_ORG"));
				
				qnaList.add(qna);
			}
			
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return qnaList;
	}

	/**
	 * 문의 등록
	 * @param qna
	 * @param conn
	 * @return result
	 * @throws Exception
	 */
	public int qnaInsert(Qna qna, Connection conn) throws Exception {
		int result = 0;
		
		try {
			String sql = prop.getProperty("qnaInsert");
			
			int inqType = (qna.getSpaceNo() > 0) ? 62 : 61;
			String queTitle = (qna.getSpaceNo() > 0) ? "장소문의" : "1:1문의";
			
			
					
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, inqType);
			pstmt.setString(2, queTitle);
			pstmt.setString(3, qna.getQueContent());
			pstmt.setInt(4, qna.getMemberNo());
			
			if (qna.getSpaceNo() > 0) {
				pstmt.setInt(5, qna.getSpaceNo());
			} else {
				pstmt.setObject(5, null);
			}
			
			result = pstmt.executeUpdate();
			
		} finally {
			close(pstmt);
			
		}
		
		return result;
	}


	/**
	 * 공간상세 문의 내용
	 * @param spaceNo
	 * @param conn
	 * @return qnaSpaceList
	 * @throws Exception
	 */
	public List<Qna> qnaSpaceList(int spaceNo, Connection conn) throws Exception {
		List<Qna> qnaSpaceList = new ArrayList<Qna>();
		
		try {
			String sql = prop.getProperty("qnaSpaceList");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, spaceNo);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				
				Qna qna = new Qna();
				qna.setQueNo(rs.getInt("QUE_NO"));
				qna.setInqType(rs.getInt("INQ_TYPE"));
				qna.setQueContent(rs.getString("QUE_CONTENT"));
				qna.setQueDt(rs.getString("QUE_DT"));
				qna.setQueSt(rs.getInt("QUE_ST"));
				qna.setMemberNo(rs.getInt("MEMBER_NO"));
				qna.setMemberNm(rs.getString("MEMBER_NM"));
				qna.setMemberImgPath(rs.getString("MEMBER_IMG_PATH"));
				qna.setMemberImgNm(rs.getString("MEMBER_IMG_NM"));
				
				qnaSpaceList.add(qna);
				
			}
			
		} finally {
			
		}
		
		return qnaSpaceList;
	}

}
