package ad.dao;

import static ad.db.JdbcUtil.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import ad.vo.MemberBean;

public class MemberDAO {
	private static MemberDAO memberDAO;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	
	private MemberDAO() {
	}
	public static MemberDAO getInstance() {
		if(memberDAO == null) {
			memberDAO = new MemberDAO();
		}
		return memberDAO;
	}

	public void setConnection(Connection con) {
		this.con = con;
	}

	public int insertMember(MemberBean member) {
		String sql = "insert into members values (?,?,?,?,?,?)";
		int insertCount = 0;
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPass());
			pstmt.setString(3, member.getName());
			pstmt.setInt(4, member.getAge());
			pstmt.setString(5, member.getGender());
			pstmt.setString(6, member.getEmail());
			insertCount = pstmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return insertCount;
	}
	public String selectLoginId(MemberBean member) {
		String loginId = null;
		String sql="select id from members where id=? and pass=?";
		
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPass());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				loginId = rs.getString("id");
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return loginId;
	}
	public ArrayList<MemberBean> selectMemberList() {
		String sql="select * from members";
		ArrayList<MemberBean> memberList=new ArrayList<MemberBean>();
		MemberBean mb = null;
		try{
			
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			if(rs.next()){
				do {
				mb=new MemberBean();
				mb.setId(rs.getString("id"));
				mb.setPass(rs.getString("pass"));
				mb.setName(rs.getString("name"));
				mb.setAge(rs.getInt("age"));
				mb.setGender(rs.getString("gender"));
				mb.setEmail(rs.getString("email"));
				memberList.add(mb);
				} while(rs.next());
			}
		}catch(Exception e){
			System.out.println("getDeatilMember 에러: " + e);			
		}finally{
			close(rs);
			close(pstmt);
		}
		return memberList;
	}
	public MemberBean selectMember(String viewId) {
		String sql="select * from members where id=?";
		MemberBean mb = null;
		try{
			
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, viewId);
			rs=pstmt.executeQuery();
			
			if(rs.next()){
				mb=new MemberBean();
				mb.setId(rs.getString("id"));
				mb.setPass(rs.getString("pass"));
				mb.setName(rs.getString("name"));
				mb.setAge(rs.getInt("age"));
				mb.setGender(rs.getString("gender"));
				mb.setEmail(rs.getString("email"));
			}
		}catch(Exception e){
			System.out.println("getDeatilMember 에러: " + e);			
		}finally{
			close(rs);
			close(pstmt);
		}
		
		return mb;
	}
	public int deleteMember(String deleteId) {
		String sql="delete from members where id=?";
		int deleteCount = 0;

		try{
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, deleteId);
			deleteCount = pstmt.executeUpdate();
		}catch(Exception e){
			System.out.println("deleteMember 에러: " + e);	
		}finally{
			close(pstmt);
		}
		
		return deleteCount;
	}
}
