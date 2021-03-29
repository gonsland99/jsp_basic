<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String lang = "kor";
	String cookie = request.getHeader("Cookie");
	
	if(cookie != null){
		Cookie cookies[] = request.getCookies();
		for(int i=0; i<cookies.length; i++){
			if(cookies[i].getName().equals("lang")){
				lang = cookies[i].getValue();
			}
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
	<%if(lang.equals("kor")){ %>
		쿠키예제 시작
	<%}else{ %>
		cookie start!
	<%} %>
	<form action="cookieTest2.jsp">
		<input type="radio" name="lang" value="kor" <%if(lang.equals("kor")){%>checked<%} %>> 한국어
		<input type="radio" name="lang" value="eng" <%if(lang.equals("eng")){%>checked<%} %>> 영어
		<input type="submit" value="언어설정">
	</form>
</body>
</html>