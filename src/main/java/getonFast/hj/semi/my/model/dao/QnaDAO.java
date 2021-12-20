package getonFast.hj.semi.my.model.dao;

import static getonFast.hj.semi.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
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
	 * @param conn
	 * @return qnaList
	 * @throws Exception
	 */
	public List<Qna> qnaList(int memberNo, Connection conn) throws Exception {
		List<Qna> qnaList = new ArrayList<Qna>();
		
		try {
			String sql = prop.getProperty("qnaList");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, memberNo);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Qna qna = new Qna();
				qna.setQueNo(rs.getInt("QUE_NO"));
				qna.setInqType(rs.getInt("INQ_TYPE"));
				qna.setQueTitle(rs.getString("QUE_TITLE"));
				qna.setQueContent(rs.getString("QUE_CONTENT"));
				qna.setQueDt(rs.getDate("QUE_DT"));
				qna.setQueSt(rs.getInt("QUE_ST"));
				qna.setMemberNo(rs.getInt("MEMBER_NO"));
				qna.setSpaceNo(rs.getInt("SPACE_NO"));
				
				qnaList.add(qna);
			}
			
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return qnaList;
	}

}
