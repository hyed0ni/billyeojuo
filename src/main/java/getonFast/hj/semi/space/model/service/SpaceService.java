package getonFast.hj.semi.space.model.service;

import static getonFast.hj.semi.common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	/** 공간옵션 조회
	 * @param spaceRoomList
	 * @return spaceOptionMap
	 * @throws Exception
	 */
	public Map<Integer, List<Space>> selectSpaceOption(List<Space> spaceRoomList) throws Exception {
		Connection conn = getConnection();
		Map<Integer, List<Space>> spaceOptionMap = new HashMap<Integer, List<Space>>();
		
		for (Space spaceRoom : spaceRoomList) {
			List<Space> spaceOptionList = dao.selectSpaceOption(spaceRoom.getSpaceRoomNo(), conn);
			
			// key : spaceRoomNo	/	value : spaceOptionList
			spaceOptionMap.put(spaceRoom.getSpaceRoomNo(), spaceOptionList);
		}
		
		close(conn);
		
		return spaceOptionMap;
	}
	

	/** 찜한공간 등록, 삭제
	 * @param spaceNo
	 * @param memberNo
	 * @return heart
	 * @throws Exception
	 */
	public int heartSpace(int spaceNo, int memberNo) throws Exception {
		Connection conn = getConnection();
		
		int heart = 0;
		
		try {
			heart = dao.insertHeart(spaceNo, memberNo, conn);
			
		} catch (SQLException e) {
			heart = dao.deleteHeart(spaceNo, memberNo, conn);
		}
		
		if (heart > 0) commit(conn);
		else rollback(conn);
		
		close(conn);
		
		return heart;
	}

	/** 찜한공간 조회
	 * @param spaceNo
	 * @param memberNo
	 * @return spaceHeart
	 * @throws Exception
	 */
	public int selectHeart(int spaceNo, int memberNo) throws Exception{
		Connection conn = getConnection();
		int spaceHeart = dao.selectHeart(spaceNo, memberNo, conn);
		close(conn);
		
		return spaceHeart;
	}
	
//	------------------------------------------------------------------------------------------------------

	/** 공간룸 상세 조회
	 * @param spaceRoomNo
	 * @return spaceRoom
	 * @throws Exception
	 */
	public Space selectSpaceRoomRes(int spaceRoomNo) throws Exception {
		Connection conn = getConnection();
		Space spaceRoom = dao.selectSpaceRoomRes(spaceRoomNo, conn);
		close(conn);
		
		return spaceRoom;
	}
	
	/** 공간 상세 조회
	 * @param spaceRoomNo
	 * @return space
	 * @throws Exception
	 */
	public Space selectSpaceRes(int spaceRoomNo) throws Exception {
		Connection conn = getConnection();
		Space space = dao.selectSpaceRes(spaceRoomNo, conn);
		close(conn);
		
		return space;
	}
	
	/** 공간유형 조회
	 * @param spaceRoomNo
	 * @return spaceType
	 * @throws Exception
	 */
	public Space selectSpaceTypeRes(int spaceRoomNo) throws Exception {
		Connection conn = getConnection();
		Space spaceType = dao.selectSpaceTypeRes(spaceRoomNo, conn);
		close(conn);
		
		return spaceType;
	}

	/** 공간 이미지 조회
	 * @param spaceRoomNo
	 * @return spaceImg
	 * @throws Exception
	 */
	public Space selectSpaceImgRes(int spaceRoomNo) throws Exception {
		Connection conn = getConnection();
		Space spaceImg = dao.selectSpaceImgRes(spaceRoomNo, conn);
		close(conn);
		
		return spaceImg;
	}

}
