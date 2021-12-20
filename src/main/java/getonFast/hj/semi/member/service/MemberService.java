package getonFast.hj.semi.member.service;

import java.sql.Connection;


import static getonFast.hj.semi.common.JDBCTemplate.*;

import getonFast.hj.semi.member.dao.MemberDAO;
import getonFast.hj.semi.member.vo.Member;



public class MemberService {
	
	private MemberDAO dao = new MemberDAO();

	public int emailDupCheck(String inputEmail) throws Exception{
		
		Connection conn = getConnection();

		int result = dao.emailDupCheck(inputEmail, conn);

		close(conn);

		return result;
		
		
	}

	/** 회원가입 서비스
	 * @param member
	 * @return result
	 * @throws Exception
	 */
	public int signUp(Member member) throws Exception {
		
		Connection conn = getConnection();

		
		int result = dao.signUp(member, conn);

		
		if (result > 0)
			commit(conn);
		else
			rollback(conn);

		
		close(conn);

		return result;
	}

}
