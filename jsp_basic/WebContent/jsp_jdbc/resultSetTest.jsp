<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="javax.sql.*"%>
<%@ page import="javax.naming.*"%>

<!DOCTYPE html>
<%
	Connection con = null;
	String sql = "select * from student";
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	ResultSetMetaData rsmd = null; //ResultSet에 저장된 데이터
	
	try{
		Context init = new InitialContext();
		DataSource ds = (DataSource)init.lookup("java:comp/env/jdbc/testDB");
		con = ds.getConnection();
		pstmt = con.prepareStatement(sql,ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		rs = pstmt.executeQuery();
		rsmd = rs.getMetaData();
		
		//ResultSet
		while(rs.next()){
			out.print("<span>"+rs.getInt(1)+". "+rs.getString(2)+"</span> ");
		}
		out.println("</br></br>");
		
		//ResultSetMetaData
		out.println("컬럼 수: "+rsmd.getColumnCount()+"</br>");
		out.println("1번 컬럼이름: "+rsmd.getColumnName(1)+"</br>");
		out.println("1번 컬럼타입: "+rsmd.getColumnTypeName(1)+"</br></br>");
		
		//ResultSet의 커서이동
		rs.last();
		out.println(rs.getInt(1)+". "+rs.getString(2)+"</br>");
		rs.first();
		out.println(rs.getInt(1)+". "+rs.getString(2)+"</br>");
		rs.absolute(3);
		out.println(rs.getInt(1)+". "+rs.getString(2)+"</br>");
	}catch(Exception e){
		out.println("<h3>데이터 가져오기 실패!</h3>");
		e.printStackTrace();
	}finally{
		try{
			rs.close();
			pstmt.close();
			con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
%>
