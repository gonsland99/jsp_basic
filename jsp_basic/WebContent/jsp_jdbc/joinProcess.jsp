<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="javax.sql.*" %>
<%@ page import="javax.naming.*" %>
<%
	request.setCharacterEncoding("utf-8");
	String id = request.getParameter("id");
	String pass = request.getParameter("pass");
	String name = request.getParameter("name");
	int age = Integer.parseInt(request.getParameter("age"));
	String gender = request.getParameter("gender");
	String email = request.getParameter("email");
	
	Connection con = null;
	PreparedStatement ps = null;
	
	try{
		Context init = new InitialContext(); //톰캣 contetxt 환경설정 불러옴
		DataSource ds = (DataSource)init.lookup("java:comp/env/jdbc/testDB");
		con = ds.getConnection();
		
		ps = con.prepareStatement("insert into member values(?,?,?,?,?,?)");
		ps.setString(1,id);
		ps.setString(2,pass);
		ps.setString(3,name);
		ps.setInt(4,age);
		ps.setString(5,gender);
		ps.setString(6,email);
		int result = ps.executeUpdate();
		
		if(result!=0){
			out.println("<script>");
			out.println("location.href='loginForm.jsp'");
			out.println("</script>");
		}else{
			out.println("<script>");
			out.println("location.href='joinForm.jsp'");
			out.println("</script>");
		}
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
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>