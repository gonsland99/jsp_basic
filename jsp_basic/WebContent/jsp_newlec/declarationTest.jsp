<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>선언문 테스트</title>
</head>
<body>
	<!-- 선언문: 변수나 메소드를 정의하는 형식 -->
	<!-- 위치와 상관없이 페이지 내 어디서든 참조가능 -->
	<h1><%=getStr() %></h1>
	<%!
		private String getStr(){
		str += " 테스트";
		return str;
	}
	private String str="선언문";
	%>
</body>
</html>