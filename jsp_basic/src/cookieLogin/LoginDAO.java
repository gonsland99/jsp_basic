package cookieLogin;

import java.sql.Connection;



import java.sql.PreparedStatement;
import java.sql.ResultSet;

import cookieLogin.Member;
import static cookieLogin.JdbcUtil.*;
public class LoginDAO {
	
	private static LoginDAO loginDAO;
	Connection con;
	public static LoginDAO getInstance() {
		if(loginDAO == null) {
			loginDAO = new LoginDAO();
		}
		return loginDAO;
	}

	public void setConnection(Connection con) {
		this.con = con;
	}

	public Member selectLoginMember(String id, String pass) {
		Member loginMember = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = con.prepareStatement("select * from users where id = ? and pass = ?");
			pstmt.setString(1, id);
			pstmt.setString(2, pass);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				loginMember = new Member();
				loginMember.setId(rs.getString("id"));
				loginMember.setPass(rs.getString("pass"));
				loginMember.setAddr(rs.getString("addr"));
				loginMember.setAge(rs.getInt("age"));
				loginMember.setEmail(rs.getString("email"));
				loginMember.setGender(rs.getString("gender"));
				loginMember.setName(rs.getString("name"));
				loginMember.setNation(rs.getString("nation"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) close(rs);
				if(pstmt != null) close(pstmt);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return loginMember;
	}
	
}
