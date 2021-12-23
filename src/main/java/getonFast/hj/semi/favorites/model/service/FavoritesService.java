package getonFast.hj.semi.favorites.model.service;

import static getonFast.hj.semi.common.JDBCTemplate.*;
import java.sql.Connection;
import java.util.List;

import getonFast.hj.semi.common.Pagination;
import getonFast.hj.semi.favorites.model.DAO.FavoriteDAO;
import getonFast.hj.semi.main.model.vo.SpaceList;

public class FavoritesService {
	
	FavoriteDAO dao = new FavoriteDAO();

	public Pagination getPagination(int cp, int limit, int memberNo) throws Exception{
		
		Connection conn = getConnection();
		int listCount = dao.getlistCount(conn, memberNo);
		
		System.out.println(listCount);
		
		if(listCount < 1) {
			listCount = 1;
		}
		
		int pageSize = (int)(Math.ceil((double)listCount/limit));
		
		close(conn);
		
		return new Pagination(listCount, cp, limit, pageSize);
	}

	
	
	public List<SpaceList> selectLikeList(int memberNo, Pagination pagination) throws Exception {
		
		Connection conn = getConnection();
		
		List< SpaceList> resultList = dao.selectLikeList(conn,memberNo, pagination);
		
		close(conn);
 		return resultList;
	}


}
