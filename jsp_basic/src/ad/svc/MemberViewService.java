package ad.svc;

import static ad.db.JdbcUtil.*;

import java.sql.Connection;

import ad.dao.MemberDAO;
import ad.vo.MemberBean;

public class MemberViewService {

	public MemberBean getMember(String viewId) {
		Connection con = getConnection();
		MemberDAO memberDAO = MemberDAO.getInstance();
		memberDAO.setConnection(con);
		MemberBean member = memberDAO.selectMember(viewId);
		close(con);
		return member;
	}

}
