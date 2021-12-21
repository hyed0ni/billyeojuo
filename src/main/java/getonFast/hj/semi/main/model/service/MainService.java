package getonFast.hj.semi.main.model.service;

import static getonFast.hj.semi.common.JDBCTemplate.*;
import java.sql.Connection;
import java.util.List;

import getonFast.hj.semi.main.model.dao.MainDAO;
import getonFast.hj.semi.main.model.vo.Recommend;
import getonFast.hj.semi.main.model.vo.SpaceType;
import getonFast.hj.semi.space.model.vo.Space;

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

	public List<Recommend> selectRecommendList() throws Exception {
		Connection conn = getConnection();
		
		List<Recommend> recommendList = dao.selectRecommendList(conn);
		
		close(conn);
		return recommendList;
	}

}
