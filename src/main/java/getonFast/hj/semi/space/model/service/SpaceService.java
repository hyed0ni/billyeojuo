package getonFast.hj.semi.space.model.service;

import static getonFast.hj.semi.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import getonFast.hj.semi.space.model.dao.SpaceDAO;
import getonFast.hj.semi.space.model.vo.Space;

public class SpaceService {
	
	private SpaceDAO dao = new SpaceDAO();

	/** 공간 상세 조회
	 * @param spaceNo
	 * @return space
	 * @throws Exception
	 */
	public Space selectSpace(int spaceNo) throws Exception {
		Connection conn = getConnection();
		Space space = dao.selectSpace(spaceNo, conn);
		close(conn);
		
		return space;
	}

	/** 공간 이미지 조회
	 * @param spaceNo
	 * @return spaceImg
	 * @throws Exception
	 */
	public Space selectSpaceImg(int spaceNo) throws Exception {
		Connection conn = getConnection();
		Space spaceImg = dao.selectSpaceImg(spaceNo, conn);
		close(conn);
		
		return spaceImg;
	}

	/** 공간룸 조회
	 * @param spaceNo
	 * @return spaceRoomList
	 * @throws Exception
	 */
	public List<Space> selectSpaceRoom(int spaceNo) throws Exception {
		Connection conn = getConnection();
		List<Space> spaceRoomList = dao.selectSpaceRoom(spaceNo, conn);
		close(conn);
		
		return spaceRoomList;
	}

	/** 공간유형 조회
	 * @param spaceNo
	 * @return spaceType
	 * @throws Exception
	 */
	public Space selectSpaceType(int spaceNo) throws Exception {
		Connection conn = getConnection();
		Space spaceType = dao.selectSpaceType(spaceNo, conn);
		close(conn);
		
		return spaceType;
	}

}
