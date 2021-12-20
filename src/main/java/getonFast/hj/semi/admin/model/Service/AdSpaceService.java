package getonFast.hj.semi.admin.model.Service;

import static getonFast.hj.semi.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import getonFast.hj.semi.admin.model.dao.AdSpaceDAO;
import getonFast.hj.semi.admin.model.vo.AdSpaceOption;
import getonFast.hj.semi.admin.model.vo.AdSpaceType;


public class AdSpaceService {
	
	AdSpaceDAO dao = new AdSpaceDAO();
	

	public List<AdSpaceType> selectSpaceType() throws Exception {
		
		Connection conn = getConnection();
		
		List<AdSpaceType> spaceType = dao.selectspaceType(conn);
		
		close(conn);
		
		return spaceType;
	}


	public List<AdSpaceOption> selectSpaceOption() throws Exception {
		Connection conn = getConnection();
		
		List<AdSpaceOption> spaceOption = dao.selectspaceOption(conn);
		
		close(conn);
		
		return spaceOption;
	}

}
