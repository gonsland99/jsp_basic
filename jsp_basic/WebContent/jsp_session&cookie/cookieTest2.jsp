<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Cookie cookie = new Cookie("lang",request.getParameter("lang"));
	cookie.setMaxAge(600);
	response.addCookie(cookie);
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<script>location.href="cookieTest.jsp"</script>
</body>
</html>