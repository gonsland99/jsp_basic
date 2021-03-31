<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.*"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<%@ page import="java.sql.*" %>
<%
	Connection con = null;
	String sql = "insert into student (num,name) values(?,'ho')";
	PreparedStatement pst = null;
	//JNDI(Java Naming Directory Interface)
	try{
		Context init = new InitialContext();
		DataSource ds = (DataSource)init.lookup("java:comp/env/jdbc/testDB");
		con = ds.getConnection();
		pst = con.prepareStatement(sql);
		
		for(int i=16; i<=17; i++){
			pst.setInt(1, i);
			if(pst.executeUpdate()!=0){
				out.println("<h3>"+i+"번 레코드 등록!</h3>");
			}
		}
	}catch(Exception e){
		out.println("<h3>레코드 등록실패!</h3>");
		e.printStackTrace();
	}finally{
		try{
			pst.close();
			con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
%>
