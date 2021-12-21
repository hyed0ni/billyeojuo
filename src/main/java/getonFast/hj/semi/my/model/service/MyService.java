package getonFast.hj.semi.my.model.service;

import static getonFast.hj.semi.common.JDBCTemplate.close;
import static getonFast.hj.semi.common.JDBCTemplate.commit;
import static getonFast.hj.semi.common.JDBCTemplate.getConnection;
import static getonFast.hj.semi.common.JDBCTemplate.rollback;

import java.sql.Connection;

import getonFast.hj.semi.member.vo.Member;
import getonFast.hj.semi.my.model.dao.MyDAO;

public class MyService {

	MyDAO dao = new MyDAO();

	/**
	 * 닉네임 변경하기
	 * 
	 * @param loginMember
	 * @return result
	 * @throws Exception
	 */
	public int updateNickName(Member member) throws Exception {

		Connection conn = getConnection();

		int result = dao.updateNickName(member, conn);

		if (result > 0)
			commit(conn);
		else
			rollback(conn);

		close(conn);

		return result;

	}

	/**
	 * 전화번호 수정
	 * 
	 * @param member
	 * @return result
	 * @throws Exception
	 */
	public int updatePhone(Member member) throws Exception {

		Connection conn = getConnection();

		System.out.println(member);

		int result = dao.updatePhone(member, conn);

		if (result > 0)
			commit(conn);
		else
			rollback(conn);

		close(conn);

		return result;

	}

}
