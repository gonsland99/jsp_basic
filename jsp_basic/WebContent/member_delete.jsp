<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="javax.sql.*" %>
<%@ page import="javax.naming.*" %>
<%
	String id = null;
	
	if((session.getAttribute("id")==null) || 
			(!((String)session.getAttribute("id")).equals("admin"))){
		out.println("<script>");
		out.println("location.href='loginForm.jsp'");
		out.println("</script>");
	}
	String delete_id = request.getParameter("id");
	
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	try{
		Context init = new InitialContext();
		DataSource ds = (DataSource)init.lookup("java:comp/env/jdbc/testDB");
		con = ds.getConnection();
		
		ps = con.prepareStatement("delete from member where id=?");
		ps.setString(1, delete_id);
		ps.executeUpdate();
		
		out.println("<script>");
		out.println("location.href='member_list.jsp'");
		out.println("</script>");
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		try{
			ps.close();
			con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
%>