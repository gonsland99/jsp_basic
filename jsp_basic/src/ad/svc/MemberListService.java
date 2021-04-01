package ad.svc;

import static ad.db.JdbcUtil.*;

import java.sql.Connection;
import java.util.ArrayList;

import ad.dao.MemberDAO;
import ad.vo.MemberBean;

public class MemberListService {

	public ArrayList<MemberBean> getMemberList() {
		Connection con = getConnection();
		MemberDAO memberDAO = MemberDAO.getInstance();
		memberDAO.setConnection(con);
		ArrayList<MemberBean> memberList = memberDAO.selectMemberList();
		close(con);
		return memberList;
	}

}
