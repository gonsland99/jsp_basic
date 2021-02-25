<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<%@ page import="java.sql.*" %>
<%
	Connection con = null;
	String driver = "com.mysql.jdbc.Driver";
	String url="jdbc:mysql://localhost:3306/testDB";
	Boolean connect = false;
	try{
		Class.forName(driver);
		con=DriverManager.getConnection(url,"root","1234");
		connect = true;
		con.close();
	}catch(Exception e){
		connect=false;
		e.printStackTrace();
	}
%>

<html>
<head>
<meta charset="utf-8">
<title>jdbc 연동</title>
</head>
<body>
	<h3>
	<% if(connect == true){ %>
		연결되었습니다.
	<%}else{ %>
		연결실패!
	<%} %>
	</h3>
</body>
</html>