package getonFast.hj.semi.reserve.model.service;

import static getonFast.hj.semi.common.JDBCTemplate.*;
import java.sql.Connection;
import java.util.List;

import getonFast.hj.semi.reserve.model.dao.ReserveDAO;
import getonFast.hj.semi.reserve.model.vo.Reserve;

public class ReserveService {
	
	private ReserveDAO dao = new ReserveDAO();

	/**
	 * 예약 목록
	 * @param memberNo 
	 * @return reserveList
	 * @throws Exception
	 */
	public List<Reserve> selectReserveList(int memberNo) throws Exception {
		Connection conn = getConnection();
		
		List<Reserve> reserveList = dao.selectReserveList(memberNo, conn);
		
		close(conn);
		
		return reserveList;
	}

}
