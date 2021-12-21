package getonFast.hj.semi.my.model.service;

import static getonFast.hj.semi.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import getonFast.hj.semi.my.model.dao.QnaDAO;
import getonFast.hj.semi.my.model.vo.Qna;

public class QnaService {
	private QnaDAO dao = new QnaDAO();

	/**
	 * 문의 조회
	 * @param memberNo
	 * @return qnaList
	 * @throws Exception
	 */
	public List<Qna> qnaList(int memberNo) throws Exception {
		Connection conn = getConnection();
		
		List<Qna> qnaList = dao.qnaList(memberNo, conn);
		
		close(conn);
		
		return qnaList;
	}

	/**
	 * 문의 등록
	 * @param qna
	 * @return result
	 * @throws Exception
	 */
	public int qnaInsert(Qna qna) throws Exception {
		Connection conn = getConnection();
		
		int result = dao.qnaInsert(qna, conn);
		
		if (result > 0) commit(conn);
		else rollback(conn);
		
		return result;
	}

}
