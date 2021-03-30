<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String id = null;
	if(session.getAttribute("id") != null){
		id=(String)session.getAttribute("id");
	}else{
		out.println("<script>");
		out.println("location.href='loginForm.jsp'");
		out.println("</script>");
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>main</title>
</head>
<body>
	<h3><%=id %>로 로그인 되었습니다.</h3>
	<%if(id.equals("admin")){ %>
		<a href="member_list.jsp">관리자모드 접속(회원목록 보기)</a>
	<%} %>
</body>
</html>