<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix = "sql" uri = "http://java.sun.com/jsp/jstl/sql" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<sql:setDataSource var = "conn"
					driver = "com.mysql.cj.jdbc.Driver"
					url = "jdbc:mysql://localhost:3306/testDB?useUnicode=true&serverTimezone=Asia/Seoul"
					user = "root" password = "1234"/>

<sql:update dataSource="${conn }">
	insert into student values(1, '홍길동');
</sql:update>
<sql:update dataSource="${conn }">
	insert into student values(2, '김길동');
</sql:update>
<sql:update dataSource="${conn }">
	insert into student values(3, '홍길동');
</sql:update>
<sql:update dataSource="${conn }">
	insert into student values(4, '홍길순');
</sql:update>

<sql:query var="rs" dataSource="${conn }">
	select * from student where name = ?
	<sql:param>홍길동</sql:param>
</sql:query>

<c:forEach var = "data" items = "${rs.rows }">
	<c:out value="${data.num }"></c:out>
	<c:out value="${data.name }"></c:out>
	<br>
</c:forEach>
</body>
</html>