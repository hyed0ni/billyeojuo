package getonFast.hj.semi.main.model.service;

import static getonFast.hj.semi.common.JDBCTemplate.*;
import java.sql.Connection;
import java.util.List;

import getonFast.hj.semi.common.Pagination;
import getonFast.hj.semi.main.model.dao.MainDAO;
import getonFast.hj.semi.main.model.vo.SpaceList;
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

	/** 추천공간 목록 
	 * @return
	 * @throws Exception
	 */
	public List<SpaceList> selectRecommendList() throws Exception {
		Connection conn = getConnection();
		
		List<SpaceList> recommendList = dao.selectRecommendList(conn);
		
		close(conn);
		return recommendList;
	}

	
	/** pagination
	 * @param cp
	 * @return
	 * @throws Exception
	 */
	public Pagination getPagination(int cp) throws Exception{
		
		Connection conn = getConnection();
		int listCount = dao.getlistCount(conn);
		
		close(conn);
		
		return new Pagination(listCount, cp);
	}
	
	/** 검색목록 
	 * @param sv
	 * @return
	 * @throws Exception
	 */
	public List<SpaceList> selectSeacrhList(String sv) throws Exception {
		Connection conn = getConnection();
		
		List<SpaceList> searchList = dao.selectSearchList(sv, conn);
		
		close(conn);
		
		return searchList;
	}



}
