package db;

import java.sql.Connection;

//import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class JdbcUtil {
	//Ä¿³ØÆ® Ç®
	public static Connection getConnection(){
		Connection con=null;
		
		try {
			Context init = new InitialContext();
			DataSource ds = (DataSource)init.lookup("java:comp/env/jdbc/model2");
			con = ds.getConnection();
			con.setAutoCommit(false); //Ä¿³ØÆ® Ç® Æ®·£Àè¼Ç Àû¿ë
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return con;
	}
	//Ä¿³ØÆ® °´Ã¼ close	
	public static void close(Connection con){
		
		try {
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	//Statement°´Ã¼ close	
	public static void close(Statement stmt){
		
		try {
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
//	public static void close(PreparedStatement pstmt){
//		
//		try {
//			pstmt.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//	}
	//ResultSet°´Ã¼ close
	public static void close(ResultSet rs){
		
		try {
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void commit(Connection con){
		
		try {
			con.commit();
			System.out.println("commit success");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void rollback(Connection con){
		
		try {
			con.rollback();
			System.out.println("rollback success");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
