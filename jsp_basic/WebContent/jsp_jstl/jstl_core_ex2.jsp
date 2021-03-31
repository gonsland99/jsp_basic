<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:forEach var = "test" begin = "1" end = "10" step = "2">
		<b>${test }</b>&nbsp;
	</c:forEach>
	<br>
	<c:forTokens items="a,b,c,d,e,f,g,h,i,j,k" delims="," var = "alp">
		<b>${alp }</b>&nbsp;
	</c:forTokens>
	<br>
	<c:set var = "data" value = "홍길동,김길동,공길동"></c:set>
	<c:forTokens items="${data }" delims="," var = "varData">
		<b>${varData }</b>&nbsp;
	</c:forTokens>
</body>
</html>