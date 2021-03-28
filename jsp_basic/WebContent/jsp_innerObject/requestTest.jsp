<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내장객체 request</title>
</head>
<body>
	<table>
		<tr>
			<td>이름: </td>
			<td><%=request.getParameter("name") %></td>
		</tr>
		<tr>
			<td>성별: </td>
			<td>
				<%if(request.getParameter("gender").equals("male")) {%>남자
				<%}else{%>여자<%}%>
			</td>
		</tr>
		<tr>
			<td>취미: </td>
			<td>
				<%
					String[] hobby = request.getParameterValues("hobby");
					for(String h : hobby){
				%>
					<%=h %>&nbsp;&nbsp;
				<%} %>
			</td>
		</tr>
	</table>
</body>
</html>