<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.*"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<%@ page import="java.sql.*" %>
<%
	Connection con = null;
	String sql = "insert into board(board_num,board_name,board_pass,board_subject,board_content) values(1,'gon','1234','테스트','test')";
	Statement st = null;
	//JNDI(Java Naming Directory Interface)
	try{
		Context init = new InitialContext();
		DataSource ds = (DataSource)init.lookup("java:comp/env/jdbc/tes");
		con = ds.getConnection();
		st = con.createStatement();
		
		int result = st.executeUpdate(sql);
		if(result!=0)
			out.println("<h3>레코드 등록됨</h3>");
	}catch(Exception e){
		out.println("<h3>레코드 등록실패!</h3>");
		e.printStackTrace();
	}finally{
		try{
			st.close();
			con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
%>
