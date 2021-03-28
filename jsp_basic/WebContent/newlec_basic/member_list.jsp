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
	
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	try{
		Context init = new InitialContext();
		DataSource ds = (DataSource)init.lookup("java:comp/env/jdbc/testDB");
		con = ds.getConnection();
		
		ps = con.prepareStatement("select * from member");
		rs = ps.executeQuery();
	}catch(Exception e){
		e.printStackTrace();
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>joinForm</title>
<style>
	table {
		margin: 100px auto;
		width: 400px;
		border: 1px solid gray;
		text-align: center;
	}
	.td_title{
		font-weight: bold;
		font-size: x-large;
	}
</style>
</head>
<body>
	<table>
		<tr>
			<td colspan="2" class="td_title">회원목록</td>
			<%while(rs.next()) {%>
			<tr>
				<td>
					<a href="member_info.jsp?id=<%=rs.getString("id") %>">
						<%=rs.getString("id") %>
					</a>
				</td>
				<td>
					<a href="member_delete.jsp?id=<%=rs.getString("id") %>">
						삭제
					</a>
				</td>
			</tr>
			<%} %>
		</tr>
		<tr>
			<td><a href=""></a></td>
		</tr>
	</table>
</body>
</html>