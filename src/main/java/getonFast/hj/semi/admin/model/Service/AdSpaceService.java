package getonFast.hj.semi.admin.model.Service;

import static getonFast.hj.semi.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import getonFast.hj.semi.admin.model.dao.AdSpaceDAO;
import getonFast.hj.semi.admin.model.vo.AdRoomtype;
import getonFast.hj.semi.admin.model.vo.AdSpace;
import getonFast.hj.semi.admin.model.vo.AdSpaceImage;
import getonFast.hj.semi.admin.model.vo.AdSpaceOption;
import getonFast.hj.semi.admin.model.vo.AdSpaceRoomOption;
import getonFast.hj.semi.admin.model.vo.AdSpaceType;


/**
 * @author heeye
 *
 */
public class AdSpaceService {
	
	AdSpaceDAO dao = new AdSpaceDAO();
	

	/** 공간타입 조회 
	 * @return spaceType
	 * @throws Exception
	 */
	public List<AdSpaceType> selectSpaceType() throws Exception {
		
		Connection conn = getConnection();
		
		List<AdSpaceType> spaceType = dao.selectspaceType(conn);
		
		close(conn);
		
		return spaceType;
	}

	
	/** 공간 옵션 조회 
	 * @return spaceOption
	 * @throws Exception
	 */
	public List<AdSpaceOption> selectSpaceOption() throws Exception {
		Connection conn = getConnection();
		
		List<AdSpaceOption> spaceOption = dao.selectspaceOption(conn);
		
		close(conn);
		
		return spaceOption;
	}


	/** 공간등록 
	 * @param space
	 * @param imgList
	 * @return spaceNo
	 * @throws Exception
	 */
	public int insertSpace(AdSpace space, List<AdSpaceImage> imgList) throws Exception {
		
		Connection conn = getConnection();
		
		// 다음 차례 게시글 번호 얻어오기 
		int spaceNo = dao.nextSpaceNo(conn);
		space.setSpaceNo(spaceNo);
		
		
		//공간 소개 등 개행문자 <br> 
		String intro = space.getSpaceIntro().replaceAll("(\r\n|\r|\n|\n\r)", "<br>");
		String guide = space.getSpaceGuide().replaceAll("(\r\n|\r|\n|\n\r)", "<br>");
		String refund = space.getRefundPolicy().replaceAll("(\r\n|\r|\n|\n\r)", "<br>");
		String caution = space.getPrecautions().replaceAll("(\r\n|\r|\n|\n\r)", "<br>");
		
		space.setPrecautions(caution);
		space.setRefundPolicy(refund);
		space.setSpaceIntro(intro);
		space.setSpaceGuide(guide);
		
		//공간 삽입
		int result = dao.insertSpace(space,imgList,conn);

		// 공간 삽입 후 이미지 삽입
		if(result > 0) {
			for(AdSpaceImage img:imgList) {
				if(img.getImgLevel() != 0) {
					img.setSpaceNo(spaceNo);
					result = dao.insertSpaceImage(conn, img);
					
					if(result == 0) {
						rollback(conn);
						break;
					}
				}
			}
			
			if(result >0) {
				commit(conn);
				result = spaceNo;
				
			}else rollback(conn);
			
		}else rollback(conn);
		
		close(conn);
		
		return result;
	}


	/** 룸 타입 등록
	 * @param roomType
	 * @param optionArrList
	 * @param rn
	 * @param imgList
	 * @return
	 * @throws Exception
	 */
	public int insertRoom(List<AdRoomtype> roomType, List<AdSpaceRoomOption> optionArrList, int rn, List<AdRoomtype> imgList) throws Exception {
		Connection conn = getConnection();
		int result = 0;
		
		System.out.println("------------roomType------------");
		System.out.println(roomType);
		for(AdRoomtype rt : roomType) {
			//다음차례 룸 넘버 얻어오기
			int roomNo = dao.nextRoomNo(conn);
			
			
			rt.setRoomNo(roomNo);
			
			//룸타입의 룸소개 개행문자 변경 
			String desc = rt.getRoomDesc().replaceAll("\n\r|\n|\r|\r\n","<br>");
			rt.setRoomDesc(desc);
			
			//룸타입 삽입
			result = dao.insertRoomType(rt, rn, conn);
			
			//룸옵션 삽입
			if(result > 0) {
				
				for(AdSpaceRoomOption spaceRoomOption : optionArrList) {
					spaceRoomOption.setRoomNo(roomNo); // 공간 번호 세팅
					result = dao.insertspaceRoomOption(spaceRoomOption, conn);
					if(result == 0) {
						rollback(conn);
						break;
					}
				}
			} 
			
			if(result > 0) {
				for(AdRoomtype img : imgList) {
					img.setRoomNo(roomNo);
					result = dao.insertRoomImg(img, conn);
					
					if(result == 0 ) {
						rollback(conn);
						break;
					}
				}
			}
			if(result >0) {
				commit(conn);
				result = roomNo;
				
			}else rollback(conn);
		
		}
		close(conn);
		
		
		return result ;
	}


	/**
	 * 공간 목록
	 * @return adSpaceList
	 * @throws Exception
	 */
	public List<AdSpace> selectAdSpaceList() throws Exception {
		Connection conn = getConnection();
		
		List<AdSpace> adSpaceList = dao.selectAdSpaceList(conn);
		
		close(conn);
		
		return adSpaceList;
	}

}
