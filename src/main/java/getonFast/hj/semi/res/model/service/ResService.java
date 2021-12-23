package getonFast.hj.semi.res.model.service;

import static getonFast.hj.semi.common.JDBCTemplate.*;

import java.sql.Connection;

import getonFast.hj.semi.res.model.dao.ResDAO;
import getonFast.hj.semi.res.model.vo.Res;
import getonFast.hj.semi.space.model.dao.SpaceDAO;

public class ResService {
	
	private ResDAO dao = new ResDAO();

	/** 예약공간 등록
	 * @param res
	 * @return result
	 * @throws Exception
	 */
	public int insertRes(Res res) throws Exception {
		Connection conn = getConnection();
		int result = dao.insertRes(res, conn);

		if (result > 0) {
			
		}
			
		
		close(conn);
		
		return result;
	}

}
