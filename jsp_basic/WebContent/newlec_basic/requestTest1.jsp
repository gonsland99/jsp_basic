<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Request 내장객체</title>
</head>
<body>
	<h1>Request예제1</h1>
	<form action="requestTest1.jsp" method="post">
		<table>
			<tr>
				<td><label for="name">이름</label></td>
				<td><%=request.getParameter("name") %></td>
			</tr>
			<tr>
				<td><label for="gender">성별</label></td>
				<td>
					<%if(request.getParameter("gender").equals("male")){ %>남자
					<%}else{%>여자<%} %>
				</td>
			</tr>
			<tr>
				<td><label for="hobby">취미</label></td>
				<td>
					<%
					String[] hobby = request.getParameterValues("hobby");
					for(int i=0; i<hobby.length; i++){
					%>
					<%=hobby[i] %>&nbsp;&nbsp;
					<%} %>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>