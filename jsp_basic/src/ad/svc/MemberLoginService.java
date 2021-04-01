package ad.svc;

import static ad.db.JdbcUtil.*;

import java.sql.Connection;

import ad.dao.MemberDAO;
import ad.vo.MemberBean;

public class MemberLoginService {

	public boolean login(MemberBean member) {
		Connection con = getConnection();
		MemberDAO memberDAO = MemberDAO.getInstance();
		memberDAO.setConnection(con);
		boolean loginResult = false;
		String loginId = memberDAO.selectLoginId(member);
		
		if(loginId != null) {
			loginResult = true;
		}
		close(con);
		return loginResult;
	}

}
