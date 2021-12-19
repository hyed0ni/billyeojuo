package getonFast.hj.semi.main.model.service;

import static getonFast.hj.semi.common.JDBCTemplate.*;
import java.sql.Connection;
import java.util.List;

import getonFast.hj.semi.main.model.dao.MainDAO;
import getonFast.hj.semi.main.model.vo.Exhibit;
import getonFast.hj.semi.main.model.vo.SpaceType;

public class MainService {
	private MainDAO dao = new MainDAO();

	/**
	 * 공간 타입 조회
	 * @return spaceTypeList
	 * @throws Exception
	 */
	public List<SpaceType> selectSpaceType() throws Exception {
		Connection conn = getConnection();
		
		List<SpaceType> spaceTypeList = dao.selectSpaceType(conn);
		
		close(conn);
		
		return spaceTypeList;
	}

	/**
	 * 기획전 조회
	 * @return exhibitList
	 * @throws Exception
	 */
	public List<Exhibit> selectExhibit() throws Exception {
		Connection conn = getConnection();
		
		List<Exhibit> exhibitList = dao.selectExhibit(conn);
		
		close(conn);
		
		return exhibitList;
	}

}
