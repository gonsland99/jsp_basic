<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.sql.*"%>
<%
	Connection con = null;	//con변수 생성
	String driver="com.mysql.cj.jdbc.Driver";	//mysql 드라이브명
	String url="jdbc:mysql://localhost:3306/testDB?useUnicode=true&serverTimezone=Asia/Seoul";//서울시간 기준으로 mysql testDB에 접근경로 
	Boolean connect = false;
	
	try{
		Class.forName(driver);	//드라이버 로드
		con = DriverManager.getConnection(url,"root","1234");
		connect = true;
		con.close();
	}catch(Exception e){
		connect = false;
		e.printStackTrace();
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>
		<%if(connect == true){ %>
		 	연결되었습니다.
		<%}else{ %>
			연결에 실패했습니다.
		<%} %>
	</h3>
</body>
</html>