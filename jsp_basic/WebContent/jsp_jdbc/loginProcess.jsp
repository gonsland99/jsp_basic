<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="javax.sql.*" %>
<%@ page import="javax.naming.*" %>
<%
	request.setCharacterEncoding("utf-8");
	String id = request.getParameter("id");
	String pass = request.getParameter("pass");
	
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	try{
		Context init = new InitialContext(); //톰캣 contetxt 환경설정 불러옴
		DataSource ds = (DataSource)init.lookup("java:comp/env/jdbc/testDB");
		con = ds.getConnection();
		
		ps = con.prepareStatement("select * from member where id=?");
		ps.setString(1,id);
		rs = ps.executeQuery();
		
		if(rs.next()){
			if(pass.equals(rs.getString("pass"))){
				session.setAttribute("id", id);
				out.println("<script>");
				out.println("location.href='main.jsp'");
				out.println("</script>");
			}else{
				out.println("<script>alert('비밀번호가 일치하지 않습니다.'); location.href='loginForm.jsp';</script>");
				out.flush();
			}
		}
		out.println("<script>");
		out.println("location.href='loginForm.jsp'");
		out.println("</script>");
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		try{
			rs.close();
			ps.close();
			con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
%>