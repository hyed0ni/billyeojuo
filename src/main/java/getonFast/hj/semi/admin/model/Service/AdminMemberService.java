package getonFast.hj.semi.admin.model.Service;

import static getonFast.hj.semi.common.JDBCTemplate.*;
import java.sql.Connection;
import java.util.List;

import getonFast.hj.semi.admin.model.dao.AdminMemberDAO;
import getonFast.hj.semi.admin.model.vo.AdminMember;

public class AdminMemberService {
	private AdminMemberDAO dao = new AdminMemberDAO();

	/**
	 * 회원 목록
	 * @param search
	 * @return memberList
	 * @throws Exception
	 */
	public List<AdminMember> selectMemberList(String search) throws Exception {
		
		Connection conn = getConnection();
		
		List<AdminMember> memberList = dao.selectMemberList(search, conn);
		
		close(conn);
		
		return memberList;
	}

}
