package getonFast.hj.semi.res.model.service;

import static getonFast.hj.semi.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import getonFast.hj.semi.res.model.dao.ResDAO;
import getonFast.hj.semi.res.model.vo.Res;
import getonFast.hj.semi.space.model.dao.SpaceDAO;
import getonFast.hj.semi.space.model.vo.Space;

public class ResService {
	
	private ResDAO dao = new ResDAO();

	/** 예약공간 등록
	 * @param res
	 * @return resSpace
	 * @throws Exception
	 */
	public int insertRes(Res res) throws Exception {
		Connection conn = getConnection();
		
		int resNo = dao.nextResNo(conn);
		res.setResNo(resNo);
		
		int resSpace = dao.insertRes(res, conn);
		
		if (resSpace > 0) {
			commit(conn);
			resSpace = resNo;
		}
		else rollback(conn);
		
		return resSpace;
	}
	
	/** 예약정보 조회
	 * @param resNo
	 * @param sort
	 * @return resList
	 * @throws Exception
	 */
	public List<Res> selectResList(int memberNo, String sort) throws Exception {
		Connection conn = getConnection();
		List<Res> resList = dao.selectResList(memberNo, sort, conn);
		close(conn);
		
		return resList;
	}
	
	/** 예약정보 상세 조회
	 * @param resNo
	 * @return res
	 * @throws Exception
	 */
	public Res selectRes(int resNo) throws Exception {
		Connection conn = getConnection();
		Res res = dao.selectRes(resNo, conn);
		close(conn);
		
		return res;
	}
	
	/** 결제취소 상태값 변경
	 * @param resNo
	 * @return updateDt
	 * @throws Exception
	 */
	public int updateDt(int resNo) throws Exception {
		Connection conn = getConnection();
		
		int updateDt = dao.updateDt(resNo, conn);
		
		if (updateDt > 0) commit(conn);
		else rollback(conn);
		
		close(conn);
		return updateDt;
	}

	/**
	 * 공간 상세 이용 후기 작성 여부
	 * @param spaceNo
	 * @param memberNo
	 * @return selectResReview
	 */
	public Map<String, String> selectResReview(int spaceNo, int memberNo) throws Exception {
		Connection conn = getConnection();
		
//		Map<Integer, String> selectResReview = new HashMap<Integer, String>();
		Map<String, String> selectResReview = dao.selectResReview(spaceNo, memberNo, conn);
		
		close(conn);
		
		return selectResReview;
	}

}
