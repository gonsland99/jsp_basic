package cookieLogin;
import java.sql.Connection;


import static login.JdbcUtil.*;
import cookieLogin.LoginDAO;
import cookieLogin.Member;

public class LoginService {

	public Member getLoginMember(String id, String pass) {
		LoginDAO loginDAO = LoginDAO.getInstance();
		Connection con = getConnection();
		loginDAO.setConnection(con);
		Member loginMember = loginDAO.selectLoginMember(id, pass);
		close(con);
		return loginMember;
	}

}
