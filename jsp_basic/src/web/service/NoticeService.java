package web.service;

import java.sql.Connection;

import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import web.entity.Notice;

public class NoticeService {
	public int removeNoticeAll(int[] ids){
		return 0;
	}
	public int pubNoticeAll(int[] ids){
		return 0;
	}
	public int insertNotice(Notice notice){
		int result = 0;
		String sql ="insert into notice(id, title, content, writer_id, pub) values(0,?,?,?,?)"; 
		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url,"GON","a12345");
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, notice.getTitle());
			st.setString(2, notice.getContent());
			st.setString(3, notice.getWriterId());
			st.setBoolean(4, notice.getPub());
			result = st.executeUpdate();
			st.close();
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	public int deleteNoticeAll(int[] ids){
		int result = 0;
		String params = "";
		for(int i=0; i<ids.length; i++) {
			params += ids[i];
			if(i < ids.length-1)
				params += ",";
		}
		String sql ="delete notice where id in ("+params+")"; 
		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url,"GON","a12345");
			Statement st = con.createStatement();
			result = st.executeUpdate(sql);
			st.close();
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	public int updateNotice(Notice notice){
		return 0;
	}
	List<Notice> getNoticeNewestList(){
		return null;
	}
	
	//오버로딩
	public List<Notice> getNoticeList(){
		return getNoticeList("title","",1);
	}
	public List<Notice> getNoticeList(int page){
		return getNoticeList("title","",page);
	}
	public List<Notice> getNoticeList(String field, String query, int page){
		List<Notice> list = new ArrayList<>();

		String sql = "select * from ( " + 
				"select rownum num, n.* from (select * from notice where "+field+" like ? order by regdate desc) n " +
				") where num between ? and ?";					//field는 ?를 쓰지않는이유: 'title'과 같이 들어감을 방지
		// 1,11,21,31 -> an = 1+(page-1)*10 등비수열
		// 10,20,30,40 -> page*10
		
		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url,"GON","a12345");
			PreparedStatement st = con.prepareStatement(sql);	//sql ?값들을 사전준비
			st.setString(1, "%"+query+"%");
			st.setInt(2, 1+(page-1)*10);
			st.setInt(3, page*10);
			ResultSet rs = st.executeQuery();
			
			while(rs.next()){
				int id = rs.getInt("ID");
				String title = rs.getString("TITLE");
				Date regdate = rs.getDate("REGDATE");
				String writerId = rs.getString("WRITER_ID");
				int hit = rs.getInt("hit") ;
				String files = rs.getString("FILES");
				String content = rs.getString("CONTENT");
				boolean pub = rs.getBoolean("PUB");
				
			//sql 데이터 값들을 list화(객체화)
				Notice notice = new Notice(
						id,
						title,
						regdate,
						writerId,
						hit,
						files,
						content,
						pub
					);
				list.add(notice);
			}

			rs.close();
			st.close();
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public int getNoticeCount() {
		return getNoticeCount("title",""); 
	}
	public int getNoticeCount(String field, String query) {
		int count = 0;
		
		String sql = "select count(id) count from (" + 
				"select rownum num, n.* from (select * from notice where "+field+" like ? order by regdate desc) n " + 
				") ";
		
		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
				
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con = DriverManager.getConnection(url,"GON","a12345");
					PreparedStatement st = con.prepareStatement(sql);
					st.setString(1, "%"+query+"%");
					ResultSet rs = st.executeQuery();
					if(rs.next()) {
						count = rs.getInt("count");
					}
					rs.close();
					st.close();
					con.close();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		
		return count; 
	}
	public Notice getNotice(int id) {
		Notice notice = null; 
		
		String sql = "select * from notice where id=?";
		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
				
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con = DriverManager.getConnection(url,"GON","a12345");
					PreparedStatement st = con.prepareStatement(sql);
					st.setInt(1, id);
					ResultSet rs = st.executeQuery();
					
					if(rs.next()){
						int nid = rs.getInt("ID");
						String title = rs.getString("TITLE");
						Date regdate = rs.getDate("REGDATE");
						String writerId = rs.getString("WRITER_ID");
						int hit = rs.getInt("hit") ;
						String files = rs.getString("FILES");
						String content = rs.getString("CONTENT");
						boolean pub = rs.getBoolean("PUB");
						
						notice = new Notice(
								nid,
								title,
								regdate,
								writerId,
								hit,
								files,
								content,
								pub
							);
					}
		
					rs.close();
					st.close();
					con.close();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
		return notice;
	}
	public Notice getNextNotice(int id) {
		Notice notice = null;
		String sql ="select id from notice where id = ( " + 
				"select id from notice where regdate > "+
				"(select regdate from notice where id=?) and rownum = 1 " + 
				")";
		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url,"GON","a12345");
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			
			if(rs.next()){
				int nid = rs.getInt("ID");
				String title = rs.getString("TITLE");
				Date regdate = rs.getDate("REGDATE");
				String writerId = rs.getString("WRITER_ID");
				int hit = rs.getInt("hit") ;
				String files = rs.getString("FILES");
				String content = rs.getString("CONTENT");
				boolean pub = rs.getBoolean("PUB");
				
				notice = new Notice(
						nid,
						title,
						regdate,
						writerId,
						hit,
						files,
						content,
						pub
					);
			}

			rs.close();
			st.close();
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return notice;
	}
	public Notice getPrevNotice(int id) {
		Notice notice = null;
		String sql ="select id from (select * from notice order by regdate desc) " + 
				"where regdate < (select regdate from notice where id=?) and rownum = 1 ";
		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url,"GON","a12345");
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			
			if(rs.next()){
				int nid = rs.getInt("ID");
				String title = rs.getString("TITLE");
				Date regdate = rs.getDate("REGDATE");
				String writerId = rs.getString("WRITER_ID");
				int hit = rs.getInt("hit") ;
				String files = rs.getString("FILES");
				String content = rs.getString("CONTENT");
				boolean pub = rs.getBoolean("PUB");
				
				notice = new Notice(
						nid,
						title,
						regdate,
						writerId,
						hit,
						files,
						content,
						pub
					);
			}

			rs.close();
			st.close();
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return notice;
	}
}
